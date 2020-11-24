DROP TABLE IF EXISTS developers CASCADE;
DROP TABLE IF EXISTS projects CASCADE;
DROP TABLE IF EXISTS developers_projects CASCADE;
DROP TABLE IF EXISTS customers CASCADE;
DROP TABLE IF EXISTS customers_projects CASCADE;
DROP TABLE IF EXISTS companies CASCADE;
DROP TABLE IF EXISTS companies_projects CASCADE;
DROP TABLE IF EXISTS skills CASCADE;
DROP TABLE IF EXISTS languages CASCADE;
DROP TABLE IF EXISTS developers_skills CASCADE;
DROP TYPE IF EXISTS gender CASCADE;
DROP TYPE IF EXISTS level CASCADE;
DROP TYPE IF EXISTS programing_language CASCADE;

CREATE TYPE gender AS ENUM ('male', 'female', 'not_mentioned');
CREATE TYPE level AS ENUM ('Junior', 'Middle', 'Senior');
CREATE TYPE programing_language AS ENUM ('Java', 'C++', 'C#', 'JS');

CREATE TABLE developers(
                           id int GENERATED ALWAYS AS IDENTITY,
                           name varchar(50),
                           age int,
                           salary int,
                           gender gender,
                           PRIMARY KEY (id)
);
CREATE TABLE projects(
                         id int GENERATED ALWAYS AS IDENTITY,
                         name varchar(50),
                         latest_release_date int,
                         cost int,
                         PRIMARY KEY (id)
);
CREATE TABLE developers_projects(
                                    project_id int,
                                    developer_id int,
                                    CONSTRAINT fk_developer
                                        FOREIGN KEY (developer_id)
                                            REFERENCES developers(id),
                                    CONSTRAINT fk_project
                                        FOREIGN KEY (project_id)
                                            REFERENCES projects(id)
);
CREATE TABLE customers(
                          id int GENERATED ALWAYS AS IDENTITY,
                          name varchar(50),
                          age int,
                          PRIMARY KEY (id)
);
CREATE TABLE customers_projects(
                                   project_id int,
                                   customer_id int,
                                   CONSTRAINT fk_customer
                                       FOREIGN KEY (customer_id)
                                           REFERENCES customers(id),
                                   CONSTRAINT fk_project
                                       FOREIGN KEY (project_id)
                                           REFERENCES projects(id)
);
CREATE TABLE companies(
                          id int GENERATED ALWAYS AS IDENTITY,
                          name varchar(50),
                          establishment_year int,
                          PRIMARY KEY (id)
);
CREATE TABLE companies_projects(
                                   project_id int,
                                   company_id int,
                                   CONSTRAINT fk_customer
                                       FOREIGN KEY (company_id)
                                           REFERENCES companies(id),
                                   CONSTRAINT fk_project
                                       FOREIGN KEY (project_id)
                                           REFERENCES projects(id)
);
CREATE TABLE languages(
                          id int GENERATED ALWAYS AS IDENTITY,
                          name programing_language,
                          PRIMARY KEY (id)
);
CREATE TABLE skills(
                       id int GENERATED ALWAYS AS IDENTITY,
                       level level,
                       PRIMARY KEY (id)
);
CREATE TABLE developers_skills(
                                  developer_id int,
                                  skill_id int,
                                  language_id int,
                                  CONSTRAINT fk_developer
                                      FOREIGN KEY (developer_id)
                                          REFERENCES developers(id),
                                  CONSTRAINT fk_skill
                                      FOREIGN KEY (skill_id)
                                          REFERENCES skills(id),
                                  CONSTRAINT fk_language
                                      FOREIGN KEY (skill_id)
                                          REFERENCES skills(id)
);