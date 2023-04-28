package no.dfo.whatsnewinjava.processapi;

public class KillOtherProcess {

    public static void main(String... args) throws Exception {

      ProcessHandle textEditHandle =
          ProcessHandle.allProcesses()
            .filter(h -> h.info().commandLine().map(cmd -> cmd.contains("TextEdit")).orElse(false))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));

      /*
      Exception in thread "main" java.lang.IllegalArgumentException: No matching handle found
	at no.dfo.whatsnewinjava.processapi.KillOtherProcess.lambda$main$2(KillOtherProcess.java:11)
	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
	at no.dfo.whatsnewinjava.processapi.KillOtherProcess.main(KillOtherProcess.java:11)

       */
      System.out.println(textEditHandle.info());

      textEditHandle.onExit()
              .thenAccept(h -> System.out.println("TextEdit was killed by Java!"));
      //thenAccept : CompletedFuture, asynchronous

      boolean shutdown = textEditHandle.destroy();

      textEditHandle.onExit().join(); //to wait current thread wait to complete the CompletedFuture
      System.out.println("Shutdown: " + shutdown);


    }

}
