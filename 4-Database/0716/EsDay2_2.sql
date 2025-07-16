USE world;

-- lista nazioni, con percentuale della lingua più parlata
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country, countrylanguage
WHERE country.Code = countrylanguage.countrycode
AND percentage >= ALL (
	SELECT countrylanguage.Percentage
	FROM countrylanguage
	WHERE country.Code = countrylanguage.countrycode
)
ORDER BY name ASC;