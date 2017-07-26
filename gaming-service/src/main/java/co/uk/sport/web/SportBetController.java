package co.uk.sport.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value="/bets")
public class SportBetController {

    @RequestMapping(value = "/", method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Balance placeBet(@RequestBody Bet bet){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Balance> balance = restTemplate.getForEntity(URI.create("http://localhost:8080/players/1512/balance/"), Balance.class);
        return balance.getBody();
    }

}
