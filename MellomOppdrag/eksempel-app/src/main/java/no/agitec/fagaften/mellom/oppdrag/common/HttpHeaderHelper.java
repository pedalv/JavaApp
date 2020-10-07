package no.agitec.fagaften.mellom.oppdrag.common;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class HttpHeaderHelper {

    /**
     * the Accept header is used by HTTP clients to tell the server what content types they'll accept.
     * The server will then send back a response, which will include a
     * Content-Type header telling the client what the content type of the returned content actually is.
     *
     * @return
     */
    public HttpHeaders createHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        //headers.setBearerAuth(); //TODO JWT

        return headers;
    }

}
