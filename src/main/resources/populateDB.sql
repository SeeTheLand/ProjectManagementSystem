INSERT INTO companies(name, establishment_year)
VALUES ('Infosys', '1981'),
       ('Cognizant', '1994'),
       ('Capgemini', '1967'),
       ('Tata Consultancy Services', '1968'),
       ('SAP', '1972'),
       ('Hewlett Packard Enterprise', '2015'),
       ('Accenture', '1989'),
       ('Oracle', '1977'),
       ('IBM', '1911'),
       ('Microsoft Corporation', '1975');
INSERT INTO customers(name, age)
VALUES ('Alex Smith', '29'),
       ('Mat Brody', '52'),
       ('Jay Vortex', '30'),
       ('Koling Pray', '19'),
       ('Samy Lourense', '27'),
       ('Anthony Park', '28'),
       ('Janifer Kapri', '55'),
       ('Arnold Schwarc', '74'),
       ('Gustavo Brain', '39'),
       ('Maria Summo', '19');
INSERT INTO developers(name, age, gender)
VALUES ('Agata Brown', '29', 'female'),
       ('Stan Wawrinka', '30', 'male'),
       ('Roger Bekker', '28', 'male'),
       ('Samantha Stosur', '27', 'not mentioned');
INSERT INTO languages(name)
VALUES ('Java'),
       ('C++'),
       ('C#'),
       ('JS');
INSERT INTO skills(level)
VALUES ('Junior'),
       ('Middle'),
       ('Senior');
INSERT INTO projects(name, latest_release_date)
VALUES ('Shop Website On JS', '2021'),
       ('Very cool bank project', '2022'),
       ('New software for Tesla', '2023'),
       ('Smart Watch', '2020'),
       ('Global Security', '2025'),
       ('Game Development', '2020'),
       ('Solaris Pack', '2020'),
       ('Bluetooth Shark', '2027'),
       ('Global Investment', '2022'),
       ('Twitter Pack', '2020'),
       ('Vicious Glasses', '2026'),
       ('Mars Satellite', '2030'),
       ('Bakery Start', '2020'),
       ('Instrument Profiler', '2021'),
       ('Birthday Present', '2022');
INSERT INTO companies_projects(project_id, company_id)
VALUES (1, 1),
       (2, 1),
       (3, 2),
       (4, 3),
       (5, 4),
       (6, 4),
       (7, 4),
       (8, 5),
       (9, 6),
       (10, 7),
       (11, 8),
       (12, 8),
       (13, 9),
       (14, 10),
       (15, 10);
INSERT INTO customers_projects(project_id, customer_id)
VALUES (1, 1),
       (2, 2),
       (3, 2),
       (4, 3),
       (5, 3),
       (6, 4),
       (7, 4),
       (8, 5),
       (9, 6),
       (10, 7),
       (11, 7),
       (12, 8),
       (13, 9),
       (14, 9),
       (15, 10);
INSERT INTO developers_projects(project_id, developer_id)
VALUES (1, 1),
       (1, 4),
       (2, 2),
       (3, 2),
       (4, 2),
       (4, 3),
       (4, 4),
       (5, 3),
       (6, 4),
       (7, 4),
       (8, 1),
       (9, 2),
       (10, 2),
       (11, 2),
       (12, 1),
       (12, 3),
       (13, 3),
       (14, 2),
       (14, 4),
       (15, 4);
INSERT INTO developers_skills(developer_id, skill_id, language_id)
VALUES (1, 1, 2),
       (2, 2, 4),
       (3, 2, 3),
       (4, 3, 1);