INSERT INTO product (id, username, product_name, min_amt, max_amt
	, rate, use_date, created_time, creator_id, modified_time
	, modifier_id, record_state)
VALUES (uuid(), 'Administrator', '¼üÊóÈÚ', '10', '100000'
	, '4.0', '365', now(), 'MASK', now()
	, 'MASK', '0');

INSERT INTO credit(id, username, star, bad_record, created_time
	, creator_id, modified_time, modifier_id, record_state)
VALUES (uuid(), 'Administrator', '5', '0', now(), 'MASK', now()
	, 'MASK', '0');