--create user table
CREATE TABLE users (id int PRIMARY KEY, user_name varchar(50) not null default '', password varchar(50) not null default '', email varchar(100) not null default '', nickname varchar(50) not null default '', phone_number int not null default 0);
--create expense table
CREATE TABLE expenses (id int PRIMARY KEY, user_id int not null default 0, occur_date date not null default CURRENT_DATE, expense_type varchar(30) not null default '', amount int not null default 0, description varchar(255) not null default '');


