INSERT INTO worker (name, birthday, level, salary)
VALUES ('John Doe', '1990-05-15', 'Senior', 6000),
       ('Jane Smith', '1995-09-20', 'Middle', 4500),
       ('Michael Johnson', '1992-07-10', 'Junior', 2500),
       ('Emily Brown', '1993-03-25', 'Trainee', 800),
       ('Christopher Davis', '1994-11-08', 'Senior', 5500),
       ('Jessica Martinez', '1991-12-30', 'Middle', 4200),
       ('David Anderson', '1989-08-17', 'Junior', 2800),
       ('Jennifer Taylor', '1996-02-12', 'Trainee', 900),
       ('James Thomas', '1997-06-05', 'Senior', 5800),
       ('Mary Hernandez', '1998-04-18', 'Middle', 4300);

INSERT INTO client (name)
VALUES ('OOO Roga i kopita'),
       ('SP Funtik'),
       ('AO VKRST'),
       ('SPD Nesterenko'),
       ('OOO AgroBudHol');

INSERT INTO project (client_id, start_date, finish_date)
VALUES (1, '2023-01-01', '2023-03-15'),
       (51, '2023-02-15', '2023-05-20'),
       (101, '2023-03-20', '2023-07-10'),
       (151, '2023-04-10', '2023-08-25'),
       (201, '2023-05-05', '2023-09-30'),
       (1, '2023-06-01', '2023-10-15'),
       (51, '2023-07-15', '2023-11-20'),
       (101, '2023-08-20', '2023-12-10'),
       (151, '2023-09-10', '2024-01-25'),
       (201, '2023-10-05', '2024-02-28');


INSERT INTO project_worker (project_id, worker_id)
VALUES (1, 1),
       (51, 51),
       (51, 101),
       (51, 251),
       (51, 351),
       (51, 401),
       (101, 101),
       (151, 151),
       (151, 251),
       (151, 301),
       (151, 351),
       (201, 201),
       (251, 251),
       (251, 51),
       (301, 301),
       (351, 351),
       (401, 401),
       (451, 451)
;