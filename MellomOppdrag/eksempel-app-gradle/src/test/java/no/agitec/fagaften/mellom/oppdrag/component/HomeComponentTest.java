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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HomeComponentTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void getHome() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/home")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertNotNull(result);
        assertNotNull(result.getResponse());
        assertEquals(200, result.getResponse().getStatus());
        assertTrue(result.getResponse().getContentAsString().contains("Welcome to home page!"));
    }

    @Test
    public void accessUnprotected() throws Exception {
        // @formatter:off
        this.mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                .andExpect(status().isOk());
        // @formatter:on
    }

}