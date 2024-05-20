SELECT 'YOUNGEST' as type,
       name,
       birthday
FROM worker
WHERE birthday = (SELECT MAX(birthday) FROM worker)
UNION
SELECT 'OLDEST',
       name,
       birthday
FROM worker
WHERE birthday = (SELECT MIN(birthday) FROM worker)
