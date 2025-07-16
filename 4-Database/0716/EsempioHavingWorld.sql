USE world;

SELECT country.name, COUNT(city.id) AS NumeroCitta
FROM country
JOIN city
	ON country.Code = city.CountryCode
GROUP BY country.name
HAVING COUNT(*) > 100
ORDER BY NumeroCitta DESC;