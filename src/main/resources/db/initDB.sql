DROP TABLE IF EXISTS cows;
DROP TABLE IF EXISTS farms;

DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 1;

CREATE TABLE farms
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name    VARCHAR NOT NULL,
    email   VARCHAR NOT NULL,
    address VARCHAR NOT NULL,
    owner   VARCHAR NOT NULL
);

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
    is_inseminated BOOLEAN   NOT NULL,
    farm_id        INTEGER   NOT NULL,
    FOREIGN KEY (farm_id) REFERENCES farms (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX cows_unique_index ON cows (number);