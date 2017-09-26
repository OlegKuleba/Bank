package com.myapp.kuleba.bank.services;

import com.myapp.kuleba.bank.entities.Card;
import com.myapp.kuleba.bank.entities.CardHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardHistoryRepo extends CrudRepository<CardHistory, Long> {
    List<CardHistory> findAllByCard(Card card);
}
