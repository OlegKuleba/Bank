package com.myapp.kuleba.bank.services;

import com.myapp.kuleba.bank.entities.CardHistory;
import com.myapp.kuleba.bank.entities.Person;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.*;

public class ReportsServiceImpl implements ReportsService {

    private JdbcTemplate jdbcTemplate;
    private static final String SQL_QUERY_1 = "SELECT city, count(address_id) AS amount FROM person, address WHERE address_id = address.id GROUP BY city";
    private static final String SQL_QUERY_2 = "SELECT person.id, name, last_name, father_name FROM person, card WHERE person.id = person_id GROUP BY name HAVING count(person_id) > 1";
    private static final String SQL_QUERY_3 = "SELECT * FROM card_history WHERE card_history.date IN (SELECT max(card_history.date) FROM card_history GROUP BY card_id)";
    private static final String SQL_QUERY_4 = "SELECT p.last_name, p.name, p.father_name, c.number, ch.date, c.balance FROM card_history ch " +
            "JOIN card c ON c.id = ch.card_id\n" +
            "JOIN person p ON c.person_id = p.id\n" +
            "WHERE ch.date IN (SELECT max(card_history.date) FROM card_history GROUP BY card_id)";

    private static final String CITY = "city";
    private static final String AMOUNT = "amount";

    public ReportsServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Long> findCitiesWithClientsAmount() {
        Map<String, Long> citiesAndClients = jdbcTemplate.query(SQL_QUERY_1, resultSet -> {
            Map<String, Long> map = new HashMap<>();
            while (resultSet.next()) {
                map.put(resultSet.getString(CITY), resultSet.getLong(AMOUNT));
                /*System.out.println("resultSet.getString(CITY) = " + resultSet.getString(CITY) + ", resultSet.getLong(AMOUNT) = " + resultSet.getLong(AMOUNT));*/
            }
            return map;
        });
        return citiesAndClients;
    }

    @Override
    public List<Person> findClientsWithSeveralCards() {
        return jdbcTemplate.query(SQL_QUERY_2, new BeanPropertyRowMapper<>(Person.class));
    }

    /*@Override
    public List<CardHistory> findLastOperationsOfCards() {
        List<CardHistory> cardHistoryList = jdbcTemplate.query(SQL_QUERY_3, resultSet -> {
            List<CardHistory> cardHistories = new ArrayList<>();
            Calendar date = GregorianCalendar.getInstance();
            while (resultSet.next()) {
                date.setTime(resultSet.getDate("date"));
                cardHistories.add(new CardHistory(resultSet.getLong("id"), date, resultSet.getString("operation_type"), resultSet.getBigDecimal("amount")));
            }
            return cardHistories;
        });
        return cardHistoryList;
    }*/

    @Override
    public Map<Long, CardHistory> findLastOperationsOfCards() {
        Map<Long, CardHistory> cardHistoryMap = jdbcTemplate.query(SQL_QUERY_3, resultSet -> {
            Map<Long, CardHistory> cardHistories = new HashMap<>();
            Calendar date = GregorianCalendar.getInstance();
            while (resultSet.next()) {
                date.setTime(resultSet.getDate("date"));
                cardHistories.put(resultSet.getLong("card_id"), new CardHistory(resultSet.getLong("id"), date, resultSet.getString("operation_type"), resultSet.getBigDecimal("amount")));
            }
            return cardHistories;
        });
        return cardHistoryMap;
    }

    @Override
    public List getGeneralReport() {

        return null;
    }
}
