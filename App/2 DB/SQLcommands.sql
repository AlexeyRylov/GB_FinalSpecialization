CREATE SCHEMA IF NOT EXISTS `HumanFriends`;
 -- drop schema `humanFriends`;
use `HumanFriends`;

## Создаем низкоуровневые таблицы
create table cat (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table dog (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table hamster (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);



create table horse (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);


create table camel (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);


create table donkey (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
	Birthday DATE
);

## Создаем таблицы уровня выше
create table pet (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);


create table packAnimal (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    liftWeight INT,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday DATE
);

## Создаем общую таблицу
create table humanFriend(
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(45),
    Command VARCHAR(45),
    Birthday Date
    );
    
## Заполняем данными низкоуровневые таблицы
    
    insert into cat (Name, Command, Birthday) values
    ('Астра', 'Спать', '218-10-01'),
    ('Айвори', 'Спать', '2012-09-01'),
	('Анора', 'Спать', '2010-02-09'),
    ('Бьянка', 'Спать', '2017-03-10');
    
    select * from cat;

    insert into dog (Name, Command, Birthday) values
    ('Дарман', 'Лежать', '2020-01-11'),
    ('Цезарь', 'Лежать', '2010-06-08'),
	('Одиссей', 'Лежать', '2013-01-07'),
    ('Эмир', 'Лежать', '2001-03-12');
	
    select * from dog;
 
	insert into hamster (Name, Command, Birthday) values
    ('Эйс', 'Бежать', '2012-01-01'),
    ('Аксель', 'Бежать', '2010-06-06'),
	('Баки', 'Бежать', '2010-01-06'),
    ('Бруно', 'Бежать', '2018-03-17');
	
    select * from hamster;
     
	insert into camel (Name, Command, LiftWeight, Birthday) values
    ('Чарли', 'Поднять', 100, '2022-01-01'),
    ('Бейли', 'Поднять', 200, '2017-06-06'),
	('Купер', 'Поднять', 400, '2023-01-06'),
    ('Макс', 'Поднять', 50, '2021-03-17');
	
    select * from camel;
     
	insert into horse (Name, Command, liftWeight, Birthday) values
    ('Зус', 'Галоп', 100, '2022-01-01'),
    ('Локи', 'Галоп', 100, '2017-06-06'),
	('Мики', 'Галоп', 250, '2023-01-06'),
    ('Оскар', 'Галоп', 350, '2021-03-17');
	
    select * from horse;    
     
	insert into donkey (Name, Command, liftWeight, Birthday) values
    ('Девид', 'Жевать', 55, '2022-01-01'),
    ('Френк', 'Жевать', 50, '2017-06-06'),
	('Чип', 'Жевать', 45, '2023-01-06'),
    ('Спарки', 'Жевать', 40, '2021-03-17');
	
    select * from donkey;  	
 
 ## Удаление таблицы верблюдов
 delete from camel where id > 0;
 select * from camel;
 
## Объединение таблицы лошадей и ослов в одну таблицу.
create table packAnimalNew (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command, 
        Birthday
from horse union 
select  Name, 
        Command, 
        Birthday
from donkey;

select * from packAnimalNew;

## Создание таблицы, в которой все животные в возрасте от 1 до 3 лет.
INSERT into pet (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from cat union 
select  Name, 
        Command, 
        Birthday
from dog union
select  Name, 
        Command, 
        Birthday
from hamster;
select * from pet;

INSERT into humanFriend (Name, Command, Birthday)
select  Name, 
        Command, 
        Birthday
from pet union 
select  Name, 
        Command, 
        Birthday
from packAnimalNew;
select * from humanFriend;

create table youngAnimals (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select Name, 
        Command, 
        Birthday,
        Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) as age
from humanfriend
where Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) > 1 
	and Round((year(current_date()) - year(Birthday)) + (month(current_date() - month(Birthday)))/10, 2) < 3;
select * from youngAnimals;

## Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам.

create table newhumanFriend (id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
select  Name, 
        Command,
        Birthday,
        'cat' as oldTable
from cat union 
select  Name, 
        Command, 
        Birthday,
        'dog' as oldTable
from dog union
select  Name, 
        Command, 
        Birthday,
        'hamster' as oldTable
from hamster union 
select  Name, 
        Command, 
        Birthday,
        'horse' as oldTable
from horse union 
select  Name, 
        Command, 
        Birthday,
        'donkey' as oldTable
from donkey;

select * from newhumanFriend;