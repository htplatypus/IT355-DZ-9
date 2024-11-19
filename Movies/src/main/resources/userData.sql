USE movies;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS authorities;

CREATE TABLE users (
                       username VARCHAR(50) NOT NULL PRIMARY KEY,
                       password VARCHAR(500) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                             username VARCHAR(50) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

CREATE UNIQUE INDEX idx_username ON authorities (username);

INSERT INTO USERS (USERNAME, PASSWORD, ENABLED) VALUES ('user',
                                                        '$2a$10$G3LuzFPpb9gZSnlTCflnqeM4iwCcmXe3JckbIzcyUf7turg0E3HkW', 1);
INSERT INTO AUTHORITIES (USERNAME, AUTHORITY) VALUES('user', 'ROLE_USER');