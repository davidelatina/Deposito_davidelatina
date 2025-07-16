USE world;

-- lista paesi con almeno una città con popolazione di almeno 5 milioni
SELECT Name
FROM country
WHERE EXISTS (
    SELECT name
    FROM city
    WHERE city.CountryCode = country.Code
    AND city.Population > 5000000
);