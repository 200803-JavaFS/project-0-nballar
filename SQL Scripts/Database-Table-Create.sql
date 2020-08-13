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
	email VARCHAR(60),
	phone_number INTEGER
);

CREATE TABLE accounts (
	account_id SERIAL PRIMARY KEY,
	user_id_fk INTEGER REFERENCES users(user_id),
	account_type VARCHAR(30),
	account_balance NUMERIC(7,2),
	is_approved VARCHAR(10)
);