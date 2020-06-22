package no.agitec.fagaften.eksempelapp.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class EmployeeResponseEntityBuilder {

    private HttpStatus httpStatus;
    private String message;

    public EmployeeResponseEntityBuilder() {}

    public EmployeeResponseEntityBuilder httpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public EmployeeResponseEntityBuilder message(String message) {
        this.message = message;
        return this;
    }

    public ResponseEntity<RestResponseBody> build() {
        if (httpStatus == null) {
            throw new IllegalStateException("HttpStatus må være satt");
        }
        RestResponseBody brevResponseEntity = new RestResponseBody(this.httpStatus, this.message);
        return new ResponseEntity<>(brevResponseEntity, httpStatus);
    }

    @SuppressWarnings("WeakerAccess") //Public på feltene er nødvendig for at Jackson skal greie å serialisere til JSON
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
