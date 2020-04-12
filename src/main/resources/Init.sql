INSERT INTO client(lastname, firstname, password, postal_address, postal_code, city, email, phone_number, birthdate, created_at, updated_at) VALUES 
('Pietrzak', 'Aurelien', '$2a$10$ISB3/qQmucSyFbt8KBHO8.lE76qfJ9QCC0aB5Jyorpd2WVaMByxEa', '6 place de l hopital general', '59300', 'Valenciennes', 'pietrzak.aurelien@gmail.com', '0606060606', '1997-04-03', NOW(), NOW()),
('Godbille', 'Melissa', '$2a$10$ISB3/qQmucSyFbt8KBHO8.lE76qfJ9QCC0aB5Jyorpd2WVaMByxEa', '3B rue d Artres', '59300', 'Famars', 'godbille.melissa@gmail.com', '0607070707', '1999-03-03', NOW(), NOW()),
('Hollertt', 'Marceau', '$2a$10$ISB3/qQmucSyFbt8KBHO8.lE76qfJ9QCC0aB5Jyorpd2WVaMByxEa', '3B rue d Artres', '59300', 'Famars', 'hollertt.marceau@gmail.com', '0628762847', '1997-10-30', NOW(), NOW()),
('Hollertt', 'Olivier', '$2a$10$ISB3/qQmucSyFbt8KBHO8.lE76qfJ9QCC0aB5Jyorpd2WVaMByxEa', '9 rue verte vallee', '59360', 'Ors', 'hollertt.olivier@gmail.com', '0629202920', '1974-06-14', NOW(), NOW());

INSERT INTO compte(balance, client_id, created_at, updated_at) VALUES
(2554.43, 1, NOW(), NOW()),
(100.23, 2, NOW(), NOW()),
(32.32, 3, NOW(), NOW()),
(109304.43, 4, NOW(), NOW());

INSERT INTO operation(from_account_id, to_account_id, amount, details, created_at) VALUES
(3, 1, 234.12, 'Anniversaire', NOW()),
(4, 1, 288.19, 'Anniversaire', NOW()),
(2, 1, 100, 'Anniversaire', NOW()),
(3, 1, 234.12, 'Noël', NOW()),
(2, 1, 11111.12, 'Travail', NOW()),
(3, 1, 1234.12, 'Travail', NOW()),
(4, 1, 234.12, 'Anniversaire', NOW()),
(3, 1,111.23, 'Anniversaire', NOW()),
(1, 2, 1234.12, 'Travail', NOW()),
(1, 3, 234.12, 'Anniversaire', NOW()),
(1, 4,111.23, 'Anniversaire', NOW());







