package com.myapp.kuleba.bank.services;

import com.myapp.kuleba.bank.entities.CardHistory;
import com.myapp.kuleba.bank.entities.Person;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ReportsService {

    Map<String, Long> findCitiesWithClientsAmount();

    List<Person> findClientsWithSeveralCards();

    //List<CardHistory> findLastOperationsOfCards();

    Map<Long, CardHistory> findLastOperationsOfCards();

    List getGeneralReport();

}
