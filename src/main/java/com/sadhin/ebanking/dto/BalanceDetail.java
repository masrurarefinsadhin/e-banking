package com.sadhin.ebanking.dto;

import java.math.BigDecimal;

public class BalanceDetail {
    private int balanceId;
    private int userId;
    private BigDecimal balance;
    private String currency;

    public BalanceDetail() {
    }

    public BalanceDetail(int balanceId, int userId, BigDecimal balance, String currency) {
        this.balanceId = balanceId;
        this.userId = userId;
        this.balance = balance;
        this.currency = currency;
    }

    public int getBalanceId() {
        return balanceId;
    }

    public void setBalanceId(int balanceId) {
        this.balanceId = balanceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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
