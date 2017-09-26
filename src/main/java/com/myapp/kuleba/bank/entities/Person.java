package com.myapp.kuleba.bank.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String lastName;

    @Column(length = 30)
    private String fatherName;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Address address;

    @OneToMany
    private List<Card> cardList;

    public Person() {
    }

    public Person(String name, String lastName, String fatherName) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.cardList = new ArrayList<>(3);
    }

    public Person(long id, String name, String lastName, String fatherName, Address address) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.address = address;
        this.cardList = new ArrayList<>(3);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
