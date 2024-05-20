SELECT 'Project' || p.id                                                    as name,
       SUM(DATEDIFF('MONTH',p.start_date,p.finish_date) * w.salary) as price
FROM project_worker pw
         LEFT JOIN project p on p.id = pw.project_id
         LEFT JOIN worker w on w.id = pw.worker_id
GROUP BY p.id
ORDER BY name
