package no.insurance.webIntegration;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.insurance.InsuranceAppApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by p on 29/10/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(InsuranceAppApplication.class)
@WebIntegrationTest
public class LetterStubServiceTest {

    @Test
    public void testListAll() throws IOException {
        RestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/letterstub", String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());
        //LIST has 3 objjects
        assertThat(responseJson.size(), greaterThanOrEqualTo(1));
        assertThat(responseJson.isMissingNode(), is(false));
        assertThat(responseJson.toString(), equalTo("[{\"id\":1,\"userid\":1,\"type\":2,\"product\":\"product got for my car\",\"state\":1,\"price\":3450.5},{\"id\":2,\"userid\":2,\"type\":1,\"product\":\"product got for my home\",\"state\":2,\"price\":3450.5},{\"id\":3,\"userid\":3,\"type\":5,\"product\":\"product got for my boat\",\"state\":4,\"price\":799.0}]"));
    }
}
