USE world;

SELECT CountryCode, COUNT(*) AS NumeroLingue
FROM countrylanguage
WHERE IsOfficial = 'T'
GROUP BY CountryCode
-- condizione riferita al gruppo
HAVING COUNT(*) > 1
ORDER BY NumeroLingue DESC;

-- anche con join
SELECT country.name, COUNT(*) AS NumeroLingue
FROM country
JOIN countrylanguage
	ON country.Code = countrylanguage.CountryCode
WHERE countrylanguage.IsOfficial = 'T'
GROUP BY country.name
HAVING COUNT(*) > 1
ORDER BY NumeroLingue DESC;