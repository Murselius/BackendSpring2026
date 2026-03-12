DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS category;

CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL
);

INSERT INTO category (name)
VALUES
('war novel'),
('satire');

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(150) NOT NULL,
    publication_year INT,
    isbn VARCHAR(150) NOT NULL,
	price VARCHAR(10) NOT NULL,
	category_id BIGINT REFERENCES category(id)
);

INSERT INTO book (title, author, publication_year, isbn, price, category_id)
VALUES
('A Farewell to Arms', 'Ernest Hemingway','1929', '1232323-21', '44.95', 1),
('Animal Farm', 'George Orwell', 1945, '2212343-5', '39.95', 2);

CREATE TABLE app_user (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(100) NOT NULL,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);

INSERT INTO app_user (username, password, role)
VALUES
('user', '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER'),
('admin', '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 'ADMIN');
