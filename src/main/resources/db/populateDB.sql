DELETE FROM cows;

ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO cows (number, birth, is_alive, death, section, lactation, is_milking, is_inseminated)
VALUES (1 , '01.01.2020 19:19', true, null, 12, 3, true, true),
       (2 , '05.01.2020 12:11', true, null,  12, 3, true, true),
       (3 , '07.01.2020 10:10', true, null,  12, 3, true, true);