USE world;

-- lista di paesi la quale popolazione è più grande di qualsiasi paese in europa
SELECT Name, Population
FROM country
WHERE Population > ANY (
    SELECT Population
    FROM country
    WHERE Continent = 'Europe'
)
ORDER BY Population ASC;