package co.uk.wallet.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping(value="/players/{playerId}/balance")
public class BalanceController {

    @RequestMapping(value = "/")
    @ResponseBody
    public Balance getBalance(@PathVariable long playerId) {
        return new Balance(playerId, BigDecimal.valueOf(100), "GBP");
    }

}
