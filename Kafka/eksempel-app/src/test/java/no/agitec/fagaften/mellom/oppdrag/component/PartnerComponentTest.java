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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    public void getPartnerAccessProtected() throws Exception {
        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/partner")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn();

        assertNotNull(result);
        assertNotNull(result.getResponse());
        assertEquals(401, result.getResponse().getStatus());
        assertEquals(result.getResponse().getErrorMessage(), "Unauthorized"); //Need login
    }

    @Test
    public void accessProtected_Login_RedirectsToRoot() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(MockMvcRequestBuilders.get("/partner"))
                .andExpect(status().is4xxClientError()) // Unauthorized
                .andReturn();

        assertEquals(mvcResult.getResponse().getErrorMessage(), "Unauthorized");

        mvcResult = this.mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(authenticated()).andReturn();

        assertEquals(302, mvcResult.getResponse().getStatus());
        assertEquals(mvcResult.getResponse().getErrorMessage(), null);
        assertThat(mvcResult.getResponse().getRedirectedUrl()).endsWith("/");
    }

    @Test
    public void loginUser() throws Exception {
        this.mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(authenticated());
    }

    @Test
    public void loginInvalidUser() throws Exception {
        this.mockMvc.perform(formLogin().user("invalid").password("invalid"))
                .andExpect(unauthenticated())
                .andExpect(status().is3xxRedirection());
    }

    @Test
    public void loginUserAccessProtected() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(authenticated()).andReturn();

        MockHttpSession httpSession = (MockHttpSession) mvcResult.getRequest().getSession(false);

        assert httpSession != null;
        this.mockMvc.perform(get("/partner").session(httpSession))
                .andExpect(status().isOk());
    }

    @Test
    public void loginUserValidateLogout() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(formLogin().user("user").password("password"))
                .andExpect(authenticated()).andReturn();

        MockHttpSession httpSession = (MockHttpSession) mvcResult.getRequest().getSession(false);

        assert httpSession != null;
        this.mockMvc.perform(post("/logout").with(csrf()).session(httpSession))
                .andExpect(unauthenticated());
        //login?logout
        this.mockMvc.perform(get("/login").session(httpSession))
                .andExpect(unauthenticated())
                .andExpect(status().isOk()); // is3xxRedirection()
    }

}
