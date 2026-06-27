\c robots

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
        id                   SERIAL PRIMARY KEY,
       model_name     VARCHAR(30),
       mark               SMALLINT,
       height              REAL,
       weight              NUMERIC,
       status               VARCHAR(15),
       origin               VARCHAR(30),
       launch              DATE,
       kaiju_kill           SMALLINT
);

\ir 'populate.sql'
\ir 'queries.sql'


