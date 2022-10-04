DELETE FROM spring_session;

INSERT INTO users (email, password, first_name, last_name, role, is_activated) VALUES ('test@gmail.com', '$2a$10$.bofveeGYtjkyumcNh8MlOvBxyHpSxefy1hMZ1canNygE4U1doqoe', 'Taras', 'Halynskyi', 'USER', true);
INSERT INTO users (email, password, first_name, last_name, role, is_activated) VALUES ('taras@gmail.com', '$2a$10$.bofveeGYtjkyumcNh8MlOvBxyHpSxefy1hMZ1canNygE4U1doqoe', 'Taras', 'Halynskyi', 'USER', true);
INSERT INTO users (email, password, first_name, last_name, role, is_activated) VALUES ('ivan@gmail.com', '$2a$10$.bofveeGYtjkyumcNh8MlOvBxyHpSxefy1hMZ1canNygE4U1doqoe', 'Ivan', 'Melnyk', 'USER', true);
INSERT INTO users (email, password, first_name, last_name, role, is_activated) VALUES ('petro@gmail.com', '$2a$10$.bofveeGYtjkyumcNh8MlOvBxyHpSxefy1hMZ1canNygE4U1doqoe', 'Petro', 'Koval', 'USER', true);

INSERT INTO author (email, first_name, last_name, country) VALUES ('robermartinxxx12345@gmail.com', 'Robert', 'Martin', 'USA');
INSERT INTO author (email, first_name, last_name, country) VALUES ('barbaraliskov12345@gmail.com', 'Barbara', 'Liskov', 'Canada');
INSERT INTO author (email, first_name, last_name, country) VALUES ('tarashalynskyi12345@gmail.com', 'Taras', 'Halynskyi', 'Ukraine');

INSERT INTO publisher (name, founded) VALUES ('Software Books Inc', '1990-11-30');
INSERT INTO publisher (name, founded) VALUES ('Easy Dev Learn', '2005-02-09');

INSERT INTO book (title, publisher_id, price, inventory_status, rating) VALUES ('Java rush course', 1, 1000, 'INSTOCK', 4.3424224);
INSERT INTO book (title, publisher_id, price, inventory_status, rating) VALUES ('Spring in action', 2, 1500, 'LOWSTOCK', 4.4566);
INSERT INTO book (title, publisher_id, price, inventory_status, rating) VALUES ('Angular for beginners', 2, 1899, 'OUTOFSTOCK', 3.4566);

INSERT INTO book_author (book_id, author_id) VALUES (1, 2);
INSERT INTO book_author (book_id, author_id) VALUES (2, 1);
INSERT INTO book_author (book_id, author_id) VALUES (2, 2);
INSERT INTO book_author (book_id, author_id) VALUES (3, 3);