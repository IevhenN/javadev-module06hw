CREATE TYPE level_worker as ENUM ('Trainee','Junior','Middle','Senior');

CREATE SEQUENCE IF NOT EXISTS seq_worker_id
    START WITH 1
    INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS seq_client_id
    START WITH 1
    INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS seq_project_id
    START WITH 1
    INCREMENT BY 50;

CREATE TABLE IF NOT EXISTS worker
(
    id       BIGINT DEFAULT nextval('seq_worker_id'),
    name     VARCHAR(1000) NOT NULL CHECK ( LENGTH(name) >= 2 AND LENGTH(name) <= 1000),
    birthday DATE CHECK (birthday > '1900-01-01'),
    level    level_worker  NOT NULL,
    salary   INT CHECK ( salary >= 100 AND salary <= 100000),
    CONSTRAINT pk_worker_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS client
(
    id   BIGINT DEFAULT nextval('seq_client_id'),
    name VARCHAR(1000) NOT NULL CHECK ( LENGTH(name) >= 2 AND LENGTH(name) <= 1000),
    CONSTRAINT pk_client_id PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS project
(
    id          BIGINT DEFAULT nextval('seq_project_id'),
    client_id   BIGINT,
    start_date  DATE,
    finish_date DATE,
    CONSTRAINT pk_project_id PRIMARY KEY (id),
    CONSTRAINT fk_customer_id FOREIGN KEY (client_id) REFERENCES client (id)
);

CREATE TABLE IF NOT EXISTS project_worker
(
    project_id BIGINT,
    worker_id  BIGINT,
    CONSTRAINT pk_project_worker_id PRIMARY KEY (project_id, worker_id),
    CONSTRAINT fk_project_id FOREIGN KEY (project_id) REFERENCES project (id),
    CONSTRAINT fk_worker_id FOREIGN KEY (worker_id) REFERENCES worker (id)
)
