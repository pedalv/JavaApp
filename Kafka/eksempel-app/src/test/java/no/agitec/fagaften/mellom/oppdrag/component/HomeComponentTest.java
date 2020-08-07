package no.agitec.fagaften.mellom.oppdrag.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class HomeComponentTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getHome() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/home")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertNotNull(result);
        assertNotNull(result.getResponse());
        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("Welcome home page"));
    }

}