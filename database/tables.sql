create database ecosenac;

drop database ecosenac;

use ecosenac;

create table cliente (
	NOME VARCHAR(40),
    EMAIL VARCHAR(30) UNIQUE,
    SENHA VARCHAR(20),
    TELEFONE VARCHAR(14),
    ID VARCHAR(100) PRIMARY KEY AUTO_INCREMENT UNIQUE
);