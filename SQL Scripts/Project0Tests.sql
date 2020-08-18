SELECT * FROM users WHERE user_id = 4;

SELECT * FROM users WHERE user_type = 'Customer';

UPDATE accounts SET status = 'Approved' WHERE account_id = 5;
UPDATE accounts SET account_balance = 7000.00 WHERE account_id = 5;

INSERT INTO accounts (user_id_fk, account_type, account_balance, status)
	VALUES (1, 'Test', 5000.00, 'Approved');