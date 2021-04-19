package no.dfo.springbootdockermvn.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.dfo.springbootdockermvn.common.CalcResponseEntityBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalcRestController {

    private final ObjectMapper objectMapper;

    public CalcRestController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping("/add")
    public ResponseEntity<?> add(@RequestParam(name="parm1") Integer parm1,
                                 @RequestParam(name="parm2") Integer parm2)  {
        try {
            int addResult = parm1 + parm2;
            return ResponseEntity.ok(objectMapper.writeValueAsString(addResult));
        } catch (JsonProcessingException | NullPointerException e) {
            return new CalcResponseEntityBuilder()
                    .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                    .message("FEIL Å LAGGE TIL")
                    .build();
        }
    }

}
