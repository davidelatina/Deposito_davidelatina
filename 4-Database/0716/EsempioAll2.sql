USE world;

-- città dalla popolazione più alta, per ogni paese del mondo
SELECT name, countrycode, population
FROM city
WHERE population >= ALL (
	SELECT population
    FROM city city2
    WHERE city.countrycode = city2.CountryCode
);