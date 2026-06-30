\c robots

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id                 SERIAL PRIMARY KEY,
    model_name  VARCHAR(30)  NOT NULL,
    mark            SMALLINT      NOT NULL,
    height           NUMERIC       NOT NULL,
    weight           NUMERIC       NOT NULL,
    status            VARCHAR(15) NOT NULL,
    origin             VARCHAR(30) NOT NULL,
    launch            DATE            NOT NULL,
    kaiju_kill         SMALLINT      NOT NULL
);

\ir 'populate.sql'
\ir 'queries.sql'


