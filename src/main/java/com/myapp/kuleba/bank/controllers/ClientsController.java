package com.myapp.kuleba.bank.controllers;

import com.myapp.kuleba.bank.entities.Address;
import com.myapp.kuleba.bank.entities.Card;
import com.myapp.kuleba.bank.entities.CardHistory;
import com.myapp.kuleba.bank.entities.Person;
import com.myapp.kuleba.bank.services.CardHistoryRepo;
import com.myapp.kuleba.bank.services.CardRepo;
import com.myapp.kuleba.bank.services.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.GregorianCalendar;
import java.util.List;

@RestController
public class ClientsController {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private CardHistoryRepo cardHistoryRepo;
/*
    @RequestMapping("/persons")
    @ResponseBody
    public String getPersons() {
        List<Person> people = (List<Person>) personRepo.findAll();
        StringBuilder sb = new StringBuilder("PERSON: ");
        for (Person person : people) {
            sb.append(person.getName()).append(", ").append(person.getLastName()).append(", ").append(person.getFatherName());
        }

        return sb.toString();
    }*/

    @RequestMapping("/getPersons")
    public List<Person> getPersons() {
        List<Person> people = (List<Person>) personRepo.findAll();
        return people;
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public List<Person> addPerson(@RequestBody Person person) {
        personRepo.save(person);
        return (List<Person>) personRepo.findAll();
    }

    @RequestMapping(value = "/addAddress", method = RequestMethod.POST)
    public List<Person> addAddress(@RequestBody Person person) {
        Address addressFromDB = personRepo.findOne(person.getId()).getAddress();
        if (null != addressFromDB) {
            person.getAddress().setId(addressFromDB.getId());
        }
        personRepo.save(person);
        return (List<Person>) personRepo.findAll();
    }

    @RequestMapping(value = "/showCards", method = RequestMethod.POST)
    public List<Card> showCards(@RequestBody Person person) {
        List<Card> cardList = cardRepo.findAllByOwner(person);
        return cardList;
    }

    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public List<Card> addCard(@RequestBody Card card) {
        cardRepo.save(card);
        return cardRepo.findAllByOwner(card.getOwner());
    }

    @RequestMapping(value = "/addCardHistory", method = RequestMethod.POST)
    public List<CardHistory> addCardHistory(@RequestBody CardHistory cardHistory) {
        cardHistory.setDate(GregorianCalendar.getInstance());
        //cardHistoryRepo.save(cardHistory);
        Card card = cardHistory.getCard();
        if (cardHistory.getOperationType().equals("give away money")) {
            /*if (cardHistory.getCard().getBalance() < cardHistory.getAmount()) {
                throw new Exception("");
            }*/
            card.setBalance(card.getBalance().subtract(cardHistory.getAmount()));
        } else {
            card.setBalance(card.getBalance().add(cardHistory.getAmount()));
        }
        cardHistoryRepo.save(cardHistory);
        cardRepo.save(card);
        return cardHistoryRepo.findAllByCard(card);
    }

    @RequestMapping(value = "/showCardHistory", method = RequestMethod.POST)
    public List<CardHistory> showCardHistory(@RequestBody Card card) {
        return cardHistoryRepo.findAllByCard(card);
    }


}
