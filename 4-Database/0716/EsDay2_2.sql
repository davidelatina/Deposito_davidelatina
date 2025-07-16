USE world;

-- lista di tutte le città di un dato countrycode, di popolazione maggiore di un milione
SELECT countrycode, name, population
FROM city
WHERE countrycode = 'ITA'
AND population > 1000000;

-- Lista paesi in ordine di popolazione, con dicitura "paese grande" per estensione > 100000, e anno di indipendenza oppure "non presente"
SELECT name as citta, population,
CASE
	WHEN surfacearea > 100000 THEN 'paese grande'
    ELSE 'paese piccolo'
END
AS 'estensione paese',
IFNULL(indepyear, 'not present') AS 'anno indipendenza'
FROM country
ORDER BY population DESC;