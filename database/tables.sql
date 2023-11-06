create database ecosenac;

drop database ecosenac;

use ecosenac;

CREATE TABLE cliente (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    NOME VARCHAR(40),
    EMAIL VARCHAR(30) UNIQUE,
    SENHA VARCHAR(20),
    TELEFONE VARCHAR(14)
);
