ALTER TABLE accounts ADD COLUMN update_at TIMESTAMP;

--Function
CREATE OR REPLACE FUNCTION trigger_set_time() RETURNS TRIGGER 
AS $$
BEGIN 
	NEW.update_at = NOW();
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_time BEFORE UPDATE ON accounts FOR EACH ROW 
EXECUTE PROCEDURE trigger_set_time();

--Testing Trigger Function
UPDATE accounts SET account_balance = 7500.00 WHERE account_id = 2;
