package com.myapp.kuleba.bank.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Entity
public class CardHistory implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Calendar date;

    @Column(nullable = false, length = 20)
    private String operationType;

    @Column(nullable = false)
    private BigDecimal amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "card_id")
    private Card card;

    public CardHistory() {
    }

    public CardHistory(String operationType, BigDecimal amount, Card card) {
        this.date = GregorianCalendar.getInstance();
        this.operationType = operationType;
        this.amount = amount;
        this.card = card;
    }

    public CardHistory(long id, Calendar date, String operationType, BigDecimal amount) {
        this.id = id;
        this.date = date;
        this.operationType = operationType;
        this.amount = amount;
    }

    public long getId() {
        return id;
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
