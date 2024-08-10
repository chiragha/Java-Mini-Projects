create database feemanagementsystem;

show databases;

use feemanagementsystem;

create table login(username varchar(20), password varchar(20));

insert into login values("admin", "12345");

select * from login;

create table studentd(name varchar(20), email varchar(40), dob varchar(30), course varchar(20), fee varchar(20),paid varchar(20), phone varchar(20), address varchar(100), country varchar(20), studid varchar(20));

select * from studentd;