insert into person(last_name, name, father_name) values ('�������', '�����', '����������');
insert into person(last_name, name, father_name) values ('�������', '���������', '��������');
insert into person(last_name, name, father_name) values ('�������', '���������', '�������������');
insert into person(last_name, name, father_name) values ('��������', '������', '����������');
insert into person(last_name, name, father_name) values ('�����', '���', '����������');
insert into person(last_name, name, father_name) values ('���������', '������', '�����������');
insert into person(last_name, name, father_name) values ('��������', '�����', '���������');

insert into address(city, street, building, apartment) values ('������',	'��������',	'103�',	'1213');
UPDATE person SET address_id = 1 WHERE last_name = '�������';

insert into address(city, street, building, apartment) values ('����',	'�����',	'520',	'70');
UPDATE person SET address_id = 2 WHERE last_name = '�������';

insert into address(city, street, building, apartment) values ('������',	'�������������',	'12',	'7');
UPDATE person SET address_id = 3 WHERE last_name = '�����';

insert into address(city, street, building, apartment) values ('������',	'�������',	'7',	'32');
UPDATE person SET address_id = 4 WHERE last_name = '���������';
