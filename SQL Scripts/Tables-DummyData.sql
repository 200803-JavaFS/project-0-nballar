--CREATE DATABASE project0;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS accounts;

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	user_name VARCHAR(30),
	pass_word VARCHAR(30),
	user_type VARCHAR(30),
	first_name VARCHAR(30),
	last_name VARCHAR(30),
	birth_date INTEGER,
	email VARCHAR(60)
);

CREATE TABLE accounts (
	account_id SERIAL PRIMARY KEY,
	user_id_fk INTEGER REFERENCES users(user_id),
	account_type VARCHAR(30),
	account_balance NUMERIC(7,2),
	is_approved VARCHAR(10)
);

ALTER TABLE accounts
	RENAME COLUMN is_approved TO status;

INSERT INTO users (user_name, pass_word, user_type, first_name, last_name, birth_date, email)
	VALUES ('the_eddie', 'edlovescat', 'Customer', 'Edward', 'Ballar', 0131, 'rawwpork@gmail.com'),
	('7teenlover', 'verynice', 'Customer', 'Leslie', 'Raganit', 0710, '7teenlover@gmail.com'),
	('catcrbn', 'catlovesed', 'Employee', 'Cat', 'Carbonell', 0301, 'iloveyou3000@gmail.com'),
	('opnami', 'iloveberries', 'Admin', 'Nancy', 'Ballar', 1014, 'opnami@gmail.com');
	
INSERT INTO accounts (user_id_fk, account_type, account_balance, status)
	VALUES (1, 'Savings', 10000.00, 'Approved'),
	(1, 'Checking', 5000.00, 'Pending'),
	(2, 'Savings', 5000.00, 'Approved'),
	(2, 'Checking', 2500.00, 'Pending');
