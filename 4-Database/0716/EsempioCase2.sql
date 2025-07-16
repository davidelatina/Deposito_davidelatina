SELECT name as citta, population,
CASE
	WHEN population > 5000000 THEN 'Megalopoli'
    WHEN population > 1000000 THEN 'Grande città'
    WHEN population > 500000 THEN 'Media città'
    ELSE 'Piccola città'
END
AS category
FROM city
ORDER BY 
CASE
	WHEN population < 1000000 THEN population 
    ELSE NULL
END ASC,
CASE
	WHEN population >= 1000000 THEN population 
    ELSE NULL
END DESC;