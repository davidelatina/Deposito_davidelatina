/*
CASE
	WHEN condition1 THEN result1
    WHEN condition2 THEN result2
    WHEN conditionN THEN resultN
    ELSE result
END;
*/

SELECT name as citta, population,
CASE
	WHEN population > 5000000 THEN 'Megalopoli'
    WHEN population > 1000000 THEN 'Grande città'
    WHEN population > 500000 THEN 'Media città'
    ELSE 'Piccola città'
END
AS category
FROM city
ORDER BY population DESC;