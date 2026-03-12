-- Testidata H2-kantaan (tai Postgresille)
INSERT INTO category (name)
VALUES 
('sarjakuva'),
('dekkari'),
('dokumentti');

INSERT INTO book (title, author, publication_year, isbn, price, category_id)
VALUES 
('Mökkimaailma', 'Mari Marison', 1974, '978-951-0-12345-6', 25.90, 1),
('Puutarha', 'Minni Hiiri', 1970, '978-951-0-67890-1', 18.50, 1);

INSERT INTO application_user (username, password, role)
VALUES 
('user', '$2a$10$1DTvwpXVBAxGFixHBuzVJObjTuXhIOkx5pse6KsYs8/C2ckxnGEou', 'USER'),
('admin', '$2a$10$CDZgyF4xaPMmnoRW3OVcmuf.8o2YSx8.M7CeRKq1.1PVw.t3E8uEC', 'ADMIN');