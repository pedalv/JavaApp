package no.dfo.whatsnewinjava.webserver;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandler;
//import com.sun.net.httpserver.HttpHandlers;
import com.sun.net.httpserver.HttpServer;
//import com.sun.net.httpserver.Request;
//import com.sun.net.httpserver.SimpleFileServer;

import java.net.InetSocketAddress;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

/**
 * javadoc .\src\main\java\no\dfo\whatsnewinjava\WhatsNewInJavaApplication.java
 * tree
 * jwebserver
 * jwebserver -p 7000
 * jwebserver -h
 *
 * PS C:\workspace2\JavaApp\CloudComputing\whats-new-in-java> ..\..\..\..\Java\jdk-19.0.2\bin\jwebserver.exe
 * Binding to loopback by default. For all interfaces use "-b 0.0.0.0" or "-b ::".
 * Serving C:\workspace2\JavaApp\CloudComputing\whats-new-in-java and subdirectories on 127.0.0.1 port 8000
 * URL http://127.0.0.1:8000/
 *
 * http://127.0.0.1:8000/resources/
 */
public class MainWebServer {


    public static void main(String... args) {



       /*

        HttpServer server = SimpleFileServer.createFileServer(
                new InetSocketAddress(7000),
                Path.of("/var/www/html"),
                SimpleFileServer.OutputLevel.INFO
        );

        server.start();
        server.stop(0);

        HttpHandler handler = SimpleFileServer.createFileHandler(
                Path.of("/dev/javadoc")
        );
        server.createContext("/javadoc", handler);

        //Static response handler
        HttpHandler unauthorizedhandler = HttpHandlers.of(
                401,
                Headers.of("WWW-Authenticate", "Basic"),
                ""
        );
        server.createContext("/secret", unauthorizedhandler);


        HttpHandler fileHandler = SimpleFileServer.createFileHandler(Path.of("/dev/javadoc"));

        Predicate<Request> isAuthorized = req -> validateAuth(req.getRequestHeaders().get("Authorization"));

        //compose handler
        HttpHandler protectedFiles = HttpHandlers.handleOrElse(
                isAuthorized,
                fileHandler,
                unauthorizedhandler
        );

        */

    }

    private static boolean validateAuth(List<String> authorization) {
        return false;
    }


}
