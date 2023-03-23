package no.dfo.whatsnewinjava.httpclient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientSimple {

    public static void main(String... args) throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest req = HttpRequest.newBuilder(URI.create("https://app.pluralsight.com/profile/author/sander-mak"))
                .GET()
                .build();

        HttpResponse<String> response = httpClient.send(req, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.headers().map());
    }
}