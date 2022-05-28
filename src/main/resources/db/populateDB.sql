DELETE FROM cows;
DELETE FROM users;
DELETE FROM farms;
DELETE FROM calving;
DELETE FROM vaccines;
DELETE FROM vaccinations;
DELETE FROM insemination;

ALTER SEQUENCE global_seq RESTART WITH 1;

INSERT INTO farms(name, email, address, owner)
VALUES ('Pelykh Farm', 'vspelykh@gmail.com', 'No name str. 19, Dnipro', 'V.S. Pelykh');

INSERT INTO users(farm_id, name, number, email, role, password)
VALUES (1, 'V.S. Pelykh', '+380993215577', 'vspelykh@gmail.com', 'OWNER', 'password');

INSERT INTO cows (number, birth, is_alive, death, section, lactation, is_milking, is_inseminated, farm_id)
VALUES ('9246', '2018-01-30 10:00:00', true, null, 9, 2, true, true, 1),
       ('2890', '2019-12-11 12:00:00', true, null, 9, 3, true, true, 1),
       ('1990', '2015-01-10 4:00:00', true, null, 9, 6, true, true, 1),
       ('1234', '01.01.2020 19:19', true, null, 12, 3, true, true, 1),
       ('9391', '05.01.2020 12:11', true, null, 12, 3, true, true, 1),
       ('3333', '07.01.2020 10:10', true, null, 12, 3, true, true, 1);

INSERT INTO calving (user_id, cow_id, date, comment)
values ('2', 3, '2022-04-06 10:00:00', 'without problems');

INSERT INTO vaccines (id, name, company) VALUES (7, 'test vaccine', 'UVT');

INSERT INTO vaccinations (user_id, cow_id, date, vaccine_id, comment)
VALUES ('2', 3, '2022-01-30 10:00:00', 7, 'success');

INSERT INTO insemination (user_id, cow_id, date, comment)
VALUES ('2', 3, '2021-01-30 10:00:00', 'success');