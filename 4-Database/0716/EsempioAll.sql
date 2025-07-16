-- città del mondo con popolazione piu alta di qualsiasi città italiana
SELECT name, countrycode, population
FROM city
WHERE population > ALL (
	SELECT population
    FROM city
    WHERE countrycode = 'ITA'
);