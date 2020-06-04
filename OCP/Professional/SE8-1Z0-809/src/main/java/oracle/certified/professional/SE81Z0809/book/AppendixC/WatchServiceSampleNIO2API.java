package oracle.certified.professional.SE81Z0809.book.AppendixC;

import java.io.IOException;
import java.nio.file.*;

/*
The Java NIO.2 API includes the WatchService framework for monitoring changes to
directories in real time. In modern operating systems, it is common for two processes
to access the same files in the same directory during their execution. If we expect a
directory or its contents to be changed over time by another process, we can use the
WatchService API to monitor the directory for changes and react to those changes as
soon as they occur.

Applying the WatchService API to monitor a directory requires a number of steps.

The following is a high-level overview of the WatchService process:

Overview of WatchService API
1. Create an instance of WatchService from the file system.
2. Register each directory and event type.
3. Create a loop that repeatedly queries the WatchService for changes.
4. Retrieve a WatchKey.
5. Retrieve all pending events for the WatchKey and do something with them.
6. Reset the WatchKey.
7. Once you no longer need the WatchService, close the resource.

If it seems like a lot of steps, don’t worry! In this section, we start with the first step and
build out from there—one step at a time.
 */


/*
Limitations of the WatchService API

Even though the WatchService API allows us to monitor a directory for changes, it does
    so with a number of known drawbacks.
First off, it is possible to miss directory change events, hence the need for the OVERFLOW event
    to tell the application that a set of changes was discarded.
Second, when events are lost, we do not get any information about the lost events, other than
    we know that something was lost. Receiving no information about precisely which events
    were lost might make some people refrain from using the WatchService API altogether.
Finally, some JVMs implementations of the WatchService API are inefficient, with significant
    delays between the time that the directory is modified and the moment that the
    application is notified about the change. Some developers have even reported delays of
    up to five seconds.

This may not seem like a significant amount of time to you, but for
    someone writing an application that continuously monitors a directory for changes, this
    may have a drastic impact on their application.
 */
public class WatchServiceSampleNIO2API {


    public static void main(String[] args) throws IOException {

        // 1. Create an instance of WatchService from the file system.
        // 7. Once you no longer need the WatchService, close the resource.
        // we can apply the try-with-resource syntax,
        // as WatchService extends Closeable in order to complete the first and last steps
        try (WatchService service = FileSystems.getDefault().newWatchService()) {

            // 2. Register each directory and event type

            /*
            The WatchService can be used on any class that implements the Watchable
                interface, which requires the class to implement register() methods.
            In the NIO.2 API, the Path interface extends the Watchable interface;
                therefore we can use our WatchService instance to monitor any number of Path objects
                by calling a register() method.
            Along with the WatchService instance, the register() method takes a vararg of
                StandardWatchEventKinds enum values, which indicates the events for which we want to listen.
            The WatchService API supports the four event types listed below.

            Enum Value                                  Description
            StandardWatchEventKinds.ENTRY_CREATE        An element is added to the directory.
            StandardWatchEventKinds.ENTRY_DELETE        An element is removed from the directory.
            StandardWatchEventKinds.ENTRY_MODIFY        An existing element is modified in the directory.
            StandardWatchEventKinds.OVERFLOW            An event may have been lost. It is possible to
                                                            receive this event even if it is not registered for.
             */

            Path ocp = Paths.get("C:\\OracleCertificationProgram");
            Path download = Paths.get("C:\\OracleCertificationProgram\\Space1");
            ocp.register(
                    service,
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY
            );
            download.register(
                    service,
                    StandardWatchEventKinds.ENTRY_MODIFY
            );

            // 3. Create a loop that repeatedly queries the WatchService for changes.

            /*
            Creating a process that loops infinitely on a WatchService instance is great if the entire
                purpose of your application is to detect changes in a directory.
            More likely, though, detecting changes in a directory is an ancillary process in your application.

            while(true) <=> for(;;)

            For example, the primary function of your application might be to present a set of data
                to the user, and you need to monitor the data file for changes. Obviously, you would
                not want the application to be frozen constantly while polling for changes in the data
                file. As you may recall from Chapter 7, you can improve processes such as these by
                spawning a separate thread to monitor for changes to the file system.
             */

            for(;;) { // Handling of events

                // 4. Retrieve a WatchKey.

                /*
                The next step is to poll the WatchService to determine if an event has occurred. The
                    WatchService API has three methods that check for and return an event key, which differ
                    only in how they handle a lack of available events:

                1. poll() This method retrieves and removes the next WatchKey, returning null if none are present.

                2. poll(long,TimeUnit) This method retrieves and removes the next WatchKey, waiting a
                    specified amount of time if none are present. If the time limit is reached without any events,
                    the method returns null.

                3. take() This method retrieves and removes the next WatchKey, waiting indefinitely if
                    none are present.

                The second and third methods can throw an InterruptedException if the process is
                    interrupted by another thread before the task could be completed. You saw numerous methods
                    that threw this type of exception in Chapter 7.
                 */

                WatchKey key;
                try {
                    key = service.take();
                } catch (InterruptedException x) {
                    break;
                }

                // 5. Retrieve all pending events for the WatchKey and do something with them

                /*
                Now that we have WatchKey , we can use that to retrieve a list of available events and process
                    them. This is the core of our WatchService functionality, as it is where we decide what
                    to do when something has changed.

                 To keep things simple in our sample application, we are just going to output the
                    information about the directory change to the System.out stream.

                 First, we request all available events by calling pollEvents() on our WatchKey instance.
                 For each event found, we read and process the event details.
                 The event details include the type of the event, which is retrieved by calling the kind() method.
                 It also includes a reference to the Path associated with the event, which is retrieved
                    by using the context() method.

                 Once we have processed all of the events available to the WatchKey , we must call the reset()
                    method on the current WatchKey instance before the next call to retrieve a new WatchKey .
                 */


                // Retrieve events for key
                for (WatchEvent<?> event: key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();
                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        continue;
                    }
                    // Process event
                    WatchEvent<Path> watchEvent = (WatchEvent<Path>)event;
                    Path path = watchEvent.context();
                    System.out.println("[eventType="+kind
                            +", path="+path.getFileName()+"]");
                }

                // 6. Reset the WatchKey.
                if(!key.reset()) {
                    break;
                }

                /*
                In this application we first check the event type and discard OVERFLOW events, since
                    they do not provide details about what data was lost.
                We then explicitly cast the event to a WatchEvent<Path> reference, allowing us to access
                    the Path object associated with the WatchEvent using the context() method.
                As we mentioned earlier, any class can register for an event, so WatchService<T> is generic.

                For the exam, though, you only need to know how to use it with Path objects.

                Finally, we print the information about the event to System.out.
                Once we have finished reading all of the events, we call reset() on the WatchKey instance.
                If the method reset() returns false, it means that the key is no longer valid, and
                    we use this error condition as an indication that we should stop the WatchService loop.
                The following is sample output from this application on a file system:

                [eventType=ENTRY_MODIFY, path=NIO2]
                [eventType=ENTRY_MODIFY, path=NIO2]
                [eventType=ENTRY_MODIFY, path=NIO2]
                [eventType=ENTRY_MODIFY, path=NIO2]
                [eventType=ENTRY_MODIFY, path=Nytt tekstdokument.txt]
                [eventType=ENTRY_MODIFY, path=Nytt punktgrafikkbilde.bmp]
                 */

            }

        }
        /*
        Alternatively, if we are not creating and closing the WatchService instance within a
            single method, we need to explicitly call the close() method on the WatchService instance
            after we have finished using it. Failure to close the WatchService after we have finished
            with it could lead to resource-contention issues within the file system.
         */
    }

}
