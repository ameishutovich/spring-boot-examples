package co.uk.wallet.contract;

import co.uk.wallet.web.Balance;
import co.uk.wallet.web.BalanceController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = "app.baseUrl=http://localhost:6060", webEnvironment = SpringBootTest.WebEnvironment.NONE)
@DirtiesContext
@AutoConfigureWireMock(port = 6060)
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class BalanceContract {

    @Autowired
    private BalanceController service;

    @Test
    public void contextLoads() throws Exception {
        stubFor(get(urlMatching("/players/.*/balance"))
                .willReturn(aResponse().withHeader("Content-Type", "application/json").withBody("{\"playerId\":1521, \"balance\":100, \"currency\":\"GBP\"}")));
        assertEquals(service.getBalance(1521).toString(), new Balance(1521, BigDecimal.valueOf(100), "GBP").toString());
    }

}