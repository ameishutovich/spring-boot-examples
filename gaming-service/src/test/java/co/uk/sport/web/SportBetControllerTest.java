package co.uk.sport.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
@AutoConfigureWireMock
public class SportBetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private SportBetController betController;

    private JacksonTester<Bet> jsonBet;
    private JacksonTester<Balance> jsonBalance;

    @Before
    public void setup() {
        ObjectMapper objectMapper = new ObjectMapper();
        JacksonTester.initFields(this, objectMapper);
    }

    @Test
    public void should_be_able_place_a_bet() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/bets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonBet.write(new Bet(17732L, 25, BigDecimal.TEN, "GBP")).getJson()))
                .andExpect(status().isOk())
                .andExpect(content().json(jsonBalance.write(new Balance(17732L, BigDecimal.valueOf(100), "GBP")).getJson()));

    }
}