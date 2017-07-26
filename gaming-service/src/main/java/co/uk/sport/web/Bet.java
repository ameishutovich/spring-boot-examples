package co.uk.sport.web;

import java.math.BigDecimal;

public class Bet {

    private long playerId;
    private int gameId;
    private BigDecimal amount;
    private String currency;

    public Bet(long playerId, int gameId, BigDecimal amount, String currency) {
        this.playerId = playerId;
        this.gameId = gameId;
        this.amount = amount;
        this.currency = currency;
    }

    public Bet() {
    }

    public long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
