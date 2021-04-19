package no.dfo.springbootdockermvn.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
class CalcRestControllerTest {

    private CalcRestController calcRestController;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = Mockito.mock(ObjectMapper.class);
        calcRestController = new CalcRestController(objectMapper);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testAdd_parmsOk_returnOK() throws JsonProcessingException {
        Integer parm1 = 1;
        Integer parm2 = 1;

        //given
        when(objectMapper.writeValueAsString(any())).thenReturn(any());

        //when
        ResponseEntity<?> actual = calcRestController.add(parm1, parm2);

        //then
        assertNotNull(actual.getStatusCode());
        assertEquals(200, actual.getStatusCode().value());
        assertEquals("OK", actual.getStatusCode().name());
        assertEquals(200, actual.getStatusCodeValue());
        verify(objectMapper, times(1)).writeValueAsString(anyInt());
    }

    @Test
    void testAdd_parmsOk_returnFeil() throws JsonProcessingException {
        Integer parm1 = 1;
        Integer parm2 = 1;
        String expected = "FAIL";

        //given
        when(objectMapper.writeValueAsString(any())).thenThrow(new RuntimeException("FAIL"));

        //when
        try {
            calcRestController.add(parm1, parm2);
            fail();
        } catch (Exception e) {
            assertEquals(expected, e.getMessage());
        }

        //then
        verify(objectMapper, times(1)).writeValueAsString(anyInt());
    }

    @Test
    void testAdd_parmsNotOk_returnFeil() throws JsonProcessingException {
        Integer parm1 = null;
        Integer parm2 = null;

        //given

        //when
        ResponseEntity<?> actual = calcRestController.add(parm1, parm2);

        //then
        assertNotNull(actual.getStatusCode());
        assertEquals(500, actual.getStatusCode().value());
        assertEquals("INTERNAL_SERVER_ERROR", actual.getStatusCode().name());
        assertEquals(500, actual.getStatusCodeValue());

        verify(objectMapper, never()).writeValueAsString(anyInt());
    }

}