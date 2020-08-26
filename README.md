# Crud_javaweb
app web dinamica(Maven, jstl,jsp,serlvet

Script para crear la base de datos 'bd_users' y una tabla 'usuarios'.

create database bd_users;

create table usuarios (user_id int auto_increment primary key,
username varchar(50) not null,
password varchar(50) not null,
firstname varchar(50) not null,
lastname varchar(50) not null);
