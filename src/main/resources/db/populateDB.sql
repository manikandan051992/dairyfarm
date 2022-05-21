DELETE FROM cows;

ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO cows (number, birth, section, is_milking)
VALUES (1 , '01.01.2020 19:19', 12, true),
       (2 , '05.01.2020 12:11', 12, true),
       (3, '01.02.2020 08:10', 12, true);