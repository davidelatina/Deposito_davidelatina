USE world;
CREATE VIEW american_cities AS
SELECT name, population
FROM city
WHERE countrycode = 'USA'
ORDER BY population DESC;

SELECT * FROM american_cities;