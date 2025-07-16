USE world;

-- 1 lingue parlate per nazione, con percentuale di utilizzo
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country, countrylanguage
WHERE country.Code = countrylanguage.countrycode
ORDER BY name ASC, Percentage DESC;

-- 2 lista nazioni, con percentuale della lingua più parlata
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country, countrylanguage
WHERE country.Code = countrylanguage.countrycode
AND percentage >= ALL (
	SELECT countrylanguage.Percentage
	FROM countrylanguage
	WHERE country.Code = countrylanguage.countrycode
)
ORDER BY name ASC;


-- 3 lingua più parlata di una nazione, con percentuale
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country, countrylanguage
WHERE country.name = 'Italy'
AND country.Code = countrylanguage.countrycode
AND percentage >= ALL (
	SELECT countrylanguage.Percentage
	FROM countrylanguage
	WHERE country.Code = countrylanguage.countrycode
);