package no.dfo.whatsnewinjava.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

public class HttpClientAsync {

    //Caused by: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target
    public static void main(String... args) throws Exception {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest req = HttpRequest.newBuilder(URI.create("https://app.pluralsight.com/profile/author/sander-mak"))
                .GET()
                .build();
        /*
        //https://stackoverflow.com/questions/6908948/java-sun-security-provider-certpath-suncertpathbuilderexception-unable-to-find
        HttpRequest req = HttpRequest.newBuilder(URI.create("https://google.com"))
                .GET()
                .build();
        */
        CompletableFuture<HttpResponse<String>> resFuture = httpClient.sendAsync(req, HttpResponse.BodyHandlers.ofString());

        resFuture.thenAccept(res -> System.out.println(res.version()));
        resFuture.join();
    }
}