package com.myapp.kuleba.bank.entities;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CardHistory {

    private Calendar date;
    private String operationType;
    private BigDecimal amount;
    private Card card;

    public CardHistory() {
    }

    public CardHistory(String operationType, BigDecimal amount, Card card) {
        this.date = GregorianCalendar.getInstance();
        this.operationType = operationType;
        this.amount = amount;
        this.card = card;
    }

    public Calendar getDate() {
        return date;
    }

    public void setDate(Calendar date) {
        this.date = date;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
