package no.dfo.whatsnewinjava.httpclient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientHead {

    public static void main(String... args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                //.localAddress(InetAddress.getLocalHost())
                //HttpClientHead.java:14: error: cannot find symbol
                .build();

        HttpRequest head = HttpRequest.newBuilder(URI.create("https://www.pluralsight.com"))
                //.HEAD()
                //HttpClientHead.java:18: error: cannot find symbol
                .build();

        client.send(head, HttpResponse.BodyHandlers.discarding());

    }


}
