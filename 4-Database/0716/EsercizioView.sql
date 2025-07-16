USE world;
CREATE VIEW italian_cities AS
SELECT name, population
FROM city
WHERE countrycode = 'ITA'
ORDER BY population DESC;

SELECT * FROM italian_cities
WHERE population < 100000
ORDER BY population ASC;