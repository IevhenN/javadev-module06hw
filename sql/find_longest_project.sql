SELECT 'Project ' || id                                 as name,
       DATEDIFF('MONTH',start_date,finish_date) as month_count
FROM project
WHERE DATEDIFF('MONTH',start_date,finish_date) =
      (SELECT max(DATEDIFF('MONTH', start_date,finish_date)) FROM project);