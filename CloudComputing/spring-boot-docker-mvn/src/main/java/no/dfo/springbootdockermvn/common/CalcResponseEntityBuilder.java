package no.dfo.springbootdockermvn.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class CalcResponseEntityBuilder {

    private HttpStatus httpStatus;
    private String message;

    public CalcResponseEntityBuilder() {
    }

    public CalcResponseEntityBuilder httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public CalcResponseEntityBuilder message(String message) {
        this.message = message;
        return this;
    }

    public ResponseEntity<RestResponseBody> build() {
        if (httpStatus == null) {
            throw new IllegalStateException("HttpStatus må være satt");
        }
        RestResponseBody calcResponseEntity = new RestResponseBody(this.httpStatus, this.message);
        return new ResponseEntity<>(calcResponseEntity, this.httpStatus);
    }

    public static class RestResponseBody {

        public final LocalDateTime timestamp;
        public final int status;
        public final String reasonPhrase;
        public final String message;

        private RestResponseBody(HttpStatus httpStatus, String message) {
            this.timestamp = LocalDateTime.now();
            this.status = httpStatus.value();
            this.reasonPhrase = httpStatus.getReasonPhrase();
            this.message = message;
        }

    }

}
