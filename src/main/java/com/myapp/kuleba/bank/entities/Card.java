package com.myapp.kuleba.bank.entities;

import java.math.BigDecimal;

public class Card {

    private String number;
    private String expDate;
    private BigDecimal balance;
    private Person owner;

    public Card() {
    }

    public Card(String number, String expDate, BigDecimal balance, Person owner) {
        this.number = number;
        this.expDate = expDate;
        this.balance = balance;
        this.owner = owner;
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
}
