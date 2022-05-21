DROP TABLE IF EXISTS cows;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE cows
(
    id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    number         VARCHAR   NOT NULL,
    birth          TIMESTAMP NOT NULL,
    is_alive       BOOL      NOT NULL,
    death          TIMESTAMP,
    section        INTEGER   NOT NULL,
    lactation      INTEGER   NOT NULL,
    is_milking     BOOLEAN   NOT NULL,
    is_inseminated BOOLEAN   NOT NULL
);
CREATE UNIQUE INDEX cows_unique_index ON cows (number);