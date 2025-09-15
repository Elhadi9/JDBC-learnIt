DROP DATABASE IF EXISTS idbc_db;

CREATE DATABASE idbc_db;

USE idbc_db;

CREATE TABLE employee (
    id INT(15) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    gender BOOLEAN,
    birth_data DATE,
    salary REAL
);