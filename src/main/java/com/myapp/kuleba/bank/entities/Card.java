package com.myapp.kuleba.bank.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Card {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false, length = 16)
    private String number;

    @Column(nullable = false, length = 5)
    private String expDate;

    @Column(nullable = false)
    private BigDecimal balance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "person_id")
    private Person owner;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CardHistory> cardHistoryList;

    public Card() {
    }

    public Card(String number, String expDate, BigDecimal balance, Person owner) {
        this.number = number;
        this.expDate = expDate;
        this.balance = balance;
        this.owner = owner;
        this.cardHistoryList = new ArrayList<>(3);
    }

    public long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public List<CardHistory> getCardHistoryList() {
        return cardHistoryList;
    }

    public boolean addCardHistory(CardHistory history) {
        return this.cardHistoryList.add(history);
    }
}
