
CREATE DATABASE dbtest;

USE dbtest;

CREATE TABLE tabellatest(
	person_id INT,
    nome VARCHAR(255),
    cognome VARCHAR(255),
    indirizzo VARCHAR(255),
    citta VARCHAR(255)
);

CREATE TABLE test2 
SELECT name, population
FROM world.city;

SELECT * FROM test2;

-- truncate table elimina solo i valori e non la tabella
TRUNCATE TABLE test2;

DROP TABLE test2;

DROP TABLE tabellatest;

DROP DATABASE dbtest;