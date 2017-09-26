package com.myapp.kuleba.bank.services;

import com.myapp.kuleba.bank.entities.Card;
import com.myapp.kuleba.bank.entities.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface CardRepo extends CrudRepository<Card, Long> {

    List<Card> findAllByOwner(Person person);

}
