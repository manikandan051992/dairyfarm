DROP TABLE IF EXISTS calving;
DROP TABLE IF EXISTS insemination;
DROP TABLE IF EXISTS vaccinations;
DROP TABLE IF EXISTS vaccines;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS cows;
DROP TABLE IF EXISTS users;
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
CREATE UNIQUE INDEX farm_unique_index ON farms (email);


CREATE TABLE users
(
    id       INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    farm_id  INTEGER NOT NULL,
    name     VARCHAR NOT NULL,
    number   VARCHAR NOT NULL,
    email    VARCHAR NOT NULL,
    role     VARCHAR NOT NULL,
    password VARCHAR NOT NULL,
    FOREIGN KEY (farm_id) REFERENCES farms (id) ON DELETE CASCADE
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

CREATE TABLE calving
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id    INTEGER   NOT NULL,
    cow_id     INTEGER   NOT NULL,
    date       TIMESTAMP NOT NULL,
    comment    VARCHAR   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (cow_id) REFERENCES cows (id) ON DELETE CASCADE
);

CREATE TABLE insemination
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id    INTEGER   NOT NULL,
    cow_id     INTEGER   NOT NULL,
    date       TIMESTAMP NOT NULL,
    comment    VARCHAR   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (cow_id) REFERENCES cows (id) ON DELETE CASCADE
);

CREATE TABLE vaccines
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name    VARCHAR NOT NULL,
    company VARCHAR NOT NULL
);

CREATE TABLE vaccinations
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    user_id    INTEGER   NOT NULL,
    cow_id     INTEGER   NOT NULL,
    date       TIMESTAMP NOT NULL,
    vaccine_id INTEGER   NOT NULL,
    comment    VARCHAR   NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (cow_id) REFERENCES cows (id) ON DELETE CASCADE,
    FOREIGN KEY (vaccine_id) REFERENCES vaccines (id) ON DELETE CASCADE
);