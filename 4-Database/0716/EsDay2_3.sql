USE world;

-- lingua più parlata di una nazione, con percentuale
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country, countrylanguage
WHERE country.name = 'Italy'
AND country.Code = countrylanguage.countrycode
AND percentage >= ALL (
	SELECT countrylanguage.Percentage
	FROM countrylanguage
	WHERE country.Code = countrylanguage.countrycode
);