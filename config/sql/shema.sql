--create expense table

CREATE TABLE expenses (id int, user_id int, occur_date date, expense_type varchar(30), amount int, description varchar(255));

--create user table

CREATE TABLE users (id int, user_name varchar(50), password varchar(50), email varchar(100), nickname varchar(50), phone_number int);