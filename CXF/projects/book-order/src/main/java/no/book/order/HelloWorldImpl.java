
package no.book.order;

import javax.jws.WebService;

@WebService(endpointInterface = "no.book.order.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

