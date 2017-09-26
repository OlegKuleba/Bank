insert into person(last_name, name, father_name) values ('Алтунян', 'Генріх', 'Ованесович');
insert into person(last_name, name, father_name) values ('Ананьєв', 'Володимир', 'Іванович');
insert into person(last_name, name, father_name) values ('Андріяка', 'Олександр', 'Олександрович');
insert into person(last_name, name, father_name) values ('Андрощук', 'Василь', 'Оверянович');
insert into person(last_name, name, father_name) values ('Аптер', 'Яків', 'Михайлович');
insert into person(last_name, name, father_name) values ('Артеменко', 'Микола', 'Миколайович');
insert into person(last_name, name, father_name) values ('Архіпова', 'Ганна', 'Григорівна');

insert into address(city, street, building, apartment) values ('Днипро',	'Гагарина',	'103а',	'1213');
UPDATE person SET address_id = 1 WHERE last_name = 'Алтунян';

insert into address(city, street, building, apartment) values ('Киев',	'Славы',	'520',	'70');
UPDATE person SET address_id = 2 WHERE last_name = 'Ананьєв';

insert into address(city, street, building, apartment) values ('Одесса',	'Дерибасовская',	'12',	'7');
UPDATE person SET address_id = 3 WHERE last_name = 'Аптер';

insert into address(city, street, building, apartment) values ('Днипро',	'Пушкина',	'7',	'32');
UPDATE person SET address_id = 4 WHERE last_name = 'Артеменко';
