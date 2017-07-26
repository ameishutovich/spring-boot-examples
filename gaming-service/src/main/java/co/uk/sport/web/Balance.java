package co.uk.sport.web;

import java.math.BigDecimal;

public class Balance {

    private long playerId;
    private BigDecimal balance;
    private String currency;

    public Balance() {
    }

    public Balance(long playerId, BigDecimal balance, String currency) {
        this.playerId = playerId;
        this.balance = balance;
        this.currency = currency;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
