USE world;

-- 1 lingue parlate per nazione, con percentuale di utilizzo
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country, countrylanguage
WHERE country.Code = countrylanguage.countrycode
ORDER BY name ASC, Percentage DESC;

-- con JOIN
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.countrycode
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

-- con JOIN
SELECT country.name, countrylanguage.language, countrylanguage.Percentage
FROM country
JOIN countrylanguage ON country.Code = countrylanguage.countrycode
WHERE percentage >= ALL (
	SELECT countrylanguage.Percentage
	FROM countrylanguage
	WHERE country.Code = countrylanguage.countrycode
);


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

-- con JOIN
SELECT paese, lingua, percentuale
FROM (
	SELECT country.name AS paese, countrylanguage.language AS lingua, countrylanguage.Percentage AS percentuale
	FROM country
	JOIN countrylanguage ON country.Code = countrylanguage.countrycode
) AS sublingue
WHERE percentuale >= ALL (
	SELECT countrylanguage.percentage
    FROM countrylanguage
    WHERE countrylanguage.CountryCode = (
		SELECT code FROM country WHERE name = sublingue.paese
	)
);

