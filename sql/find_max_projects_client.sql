WITH pc AS (SELECT COUNT(id) project_count,
                   client_id
            FROM project
            GROUP BY client_id)

SELECT cl.name,
       pc.project_count
FROM pc
         JOIN client cl
              ON pc.client_id = cl.id
WHERE pc.project_count = (SELECT Max(pc.project_count) FROM pc)