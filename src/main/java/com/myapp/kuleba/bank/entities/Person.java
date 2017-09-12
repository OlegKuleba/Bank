package com.myapp.kuleba.bank.entities;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String lastName;
    private String fatherName;
    private List<Card> cardList;

    public Person() {
    }

    public Person(String name, String lastName, String fatherName) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.cardList = new ArrayList<>(3);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    public boolean addCard(Card card) {
        return this.cardList.add(card);
    }
    public Card deleteCard(String number) throws IndexOutOfBoundsException {
        int index = -1;
        for (int i = 0; i < cardList.size(); i++) {
            if (cardList.get(i).getNumber().equals(number)) {
                index = i;
            }
        }
        return this.cardList.remove(index);
    }
}
