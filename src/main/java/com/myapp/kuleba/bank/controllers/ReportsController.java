package com.myapp.kuleba.bank.controllers;

import com.myapp.kuleba.bank.entities.CardHistory;
import com.myapp.kuleba.bank.entities.Person;
import com.myapp.kuleba.bank.services.ReportsService;
import com.myapp.kuleba.bank.services.ReportsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ReportsController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private ReportsService reportsService;

    private void init() {
        if (reportsService == null) {
            reportsService = new ReportsServiceImpl(jdbcTemplate);
        }
    }

    @RequestMapping("/getCitiesClientsReport")
    public Map<String, Long> getCitiesClientsReport() {
        init();
        return reportsService.findCitiesWithClientsAmount();
    }

    @RequestMapping("/getClientsWithSeveralCards")
    public List<Person> getClientsWithSeveralCards() {
        init();
        return reportsService.findClientsWithSeveralCards();
    }

    @RequestMapping("/getLastOperationsOfCards")
    public Map<Long, CardHistory> getLastOperationsOfCards() {
        init();
        return reportsService.findLastOperationsOfCards();
    }

    /*@RequestMapping("/getLastOperationsOfCards")
    public List<CardHistory> getLastOperationsOfCards() {
        init();
        return reportsService.findLastOperationsOfCards();
    }*/

}
