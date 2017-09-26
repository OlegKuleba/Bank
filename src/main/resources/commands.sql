/*TABLES DESCRIPTION*/
SHOW COLUMNS FROM person;
SHOW COLUMNS FROM address;
SHOW COLUMNS FROM card;
SHOW COLUMNS FROM card_history;

/*SELECTS*/
SELECT * FROM person;
SELECT * FROM address;
SELECT * FROM card;
SELECT * FROM card_history;

/*REPORTS*/
SELECT city, count(address_id) AS amount FROM person, address WHERE address_id = address.id GROUP BY city;
SELECT person.id, name, last_name, father_name FROM person, card WHERE person.id = person_id GROUP BY name HAVING count(person_id) > 1;
SELECT * FROM card_history WHERE card_history.date IN (SELECT max(card_history.date) FROM card_history GROUP BY card_id);
SELECT p.last_name, p.name, p.father_name, c.number, ch.date, c.balance FROM card_history ch
  JOIN card c ON c.id = ch.card_id
  JOIN person p ON c.person_id = p.id
WHERE ch.date IN (SELECT max(card_history.date) FROM card_history GROUP BY card_id);