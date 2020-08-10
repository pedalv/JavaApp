package no.agitec.fagaften.mellom.oppdrag.component;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PartnerComponentTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getPartner_MovedTemporarily() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/partner")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertNotNull(result);
        assertNotNull(result.getResponse());
        assertEquals(302, result.getResponse().getStatus());
    }

    @Test
    public void accessProtectedRedirectsToLogin() throws Exception {
        // @formatter:off
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/partner"))
                .andExpect(status().is3xxRedirection())
                .andReturn();
        // @formatter:on

        assertThat(mvcResult.getResponse().getRedirectedUrl()).endsWith("/login");
    }

    @Test
    public void loginUser() throws Exception {
        // @formatter:off
        this.mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(authenticated());
        // @formatter:on
    }

    @Test
    public void loginInvalidUser() throws Exception {
        // @formatter:off
        this.mockMvc.perform(formLogin().user("invalid").password("invalid"))
                .andExpect(unauthenticated())
                .andExpect(status().is3xxRedirection());
        // @formatter:on
    }

    @Test
    public void loginUserAccessProtected() throws Exception {
        // @formatter:off
        MvcResult mvcResult = this.mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(authenticated()).andReturn();
        // @formatter:on

        MockHttpSession httpSession = (MockHttpSession) mvcResult.getRequest().getSession(false);

        // @formatter:off
        assert httpSession != null;
        this.mockMvc.perform(get("/partner").session(httpSession))
                .andExpect(status().isOk());
        // @formatter:on
    }

    @Test
    public void loginUserValidateLogout() throws Exception {
        // @formatter:off
        MvcResult mvcResult = this.mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(authenticated()).andReturn();
        // @formatter:on

        MockHttpSession httpSession = (MockHttpSession) mvcResult.getRequest().getSession(false);

        // @formatter:off
        assert httpSession != null;
        this.mockMvc.perform(post("/logout").with(csrf()).session(httpSession))
                .andExpect(unauthenticated());
        this.mockMvc.perform(get("/partner").session(httpSession))
                .andExpect(unauthenticated())
                .andExpect(status().is3xxRedirection());
        // @formatter:on
    }

}
