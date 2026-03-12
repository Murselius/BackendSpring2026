CREATE TABLE category (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL
);

CREATE TABLE book (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(150) NOT NULL,
    publication_year INT,
    isbn VARCHAR(150) NOT NULL,
	price VARCHAR(10) NOT NULL,
	category_id BIGINT REFERENCES category(id)
);

CREATE TABLE application_user (
    id BIGSERIAL PRIMARY KEY,
    role VARCHAR(100) NOT NULL,
    username VARCHAR(250) NOT NULL,
    password VARCHAR(250) NOT NULL
);