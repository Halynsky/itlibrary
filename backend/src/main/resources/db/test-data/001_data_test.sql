DELETE FROM spring_session;

INSERT INTO users (email, password, first_name, last_name, role, is_activated) VALUES ('taras@gmail.com', '$2a$10$.bofveeGYtjkyumcNh8MlOvBxyHpSxefy1hMZ1canNygE4U1doqoe', 'Taras', 'Halynskyi', 'USER', true);
INSERT INTO users (email, password, first_name, last_name, role, is_activated) VALUES ('ivan@gmail.com', '$2a$10$.bofveeGYtjkyumcNh8MlOvBxyHpSxefy1hMZ1canNygE4U1doqoe', 'Ivan', 'Melnyk', 'USER', true);
INSERT INTO users (email, password, first_name, last_name, role, is_activated) VALUES ('petro@gmail.com', '$2a$10$.bofveeGYtjkyumcNh8MlOvBxyHpSxefy1hMZ1canNygE4U1doqoe', 'Petro', 'Koval', 'USER', true);

INSERT INTO author (email, first_name, last_name, country) VALUES ('robermartinxxx123@gmail.com', 'Robert', 'Martin', 'USA');
INSERT INTO author (email, first_name, last_name, country) VALUES ('barbaraliskov123@gmail.com', 'Barbara', 'Liskov', 'Canada');

INSERT INTO publisher (name, founded) VALUES ('Software Books Inc', '1990-11-30');
INSERT INTO publisher (name, founded) VALUES ('Easy Dev Learn', '2005-02-09');

INSERT INTO book (title, publisher_id) VALUES ('Java rush course', 1);
INSERT INTO book (title, publisher_id) VALUES ('Spring in action', 2);

INSERT INTO book_author (book_id, author_id) VALUES (1, 2);
INSERT INTO book_author (book_id, author_id) VALUES (2, 1);
INSERT INTO book_author (book_id, author_id) VALUES (2, 2);