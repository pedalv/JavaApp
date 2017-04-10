package no.das.boot.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.das.boot.Das;
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
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by p on 14/09/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Das.class)
@WebIntegrationTest
//@SpringBootTest
public class ShipwreckControllerWebIntegrationTest {
    @Test
    public void testListAll() throws IOException {
        RestTemplate restTemplate = new TestRestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/v1/shipwrecks", String.class);

        assertThat( response.getStatusCode() , equalTo(HttpStatus.OK));

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode responseJson = objectMapper.readTree(response.getBody());

        assertThat( responseJson.isMissingNode() , is(false) );
        assertThat( responseJson.toString() , equalTo("[{\"id\":34,\"name\":\"S.S. Yongala\",\"description\":\"A luxury passenger ship wrecked on the great barrier reef\",\"condition\":\"FAIR\",\"depth\":50,\"latitude\":44.12,\"longitude\":138.44,\"yearDiscovered\":1994},{\"id\":1,\"name\":\"UB69\",\"description\":\"A very deep German UBoat\",\"condition\":\"FAIR\",\"depth\":200,\"latitude\":44.34,\"longitude\":138.44,\"yearDiscovered\":1994}]") );

    }

}