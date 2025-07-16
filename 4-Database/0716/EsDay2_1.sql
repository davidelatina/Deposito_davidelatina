USE world;

-- lingue parlate per nazione, con percentuale di utilizzo
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country, countrylanguage
WHERE country.Code = countrylanguage.countrycode
ORDER BY name ASC, Percentage DESC;