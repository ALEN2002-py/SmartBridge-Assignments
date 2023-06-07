CREATE TABLE employee(emp_id int, emp_name varchar(255), address varchar(255),city varchar(255),postal_code varchar(255) ,country varchar(255),PRIMARY KEY (emp_id));
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (001,'Ramasundar','Karnataka,India', 'Banglore','765904','India');
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (002,'Alex','London,England', 'London','333491','England');
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (003,'Alford','New York,USA', 'HempStead','743104','USA');
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (005,'Ravi Kumar','Tamil Nadu,India', 'Chennai','567994','India');
SELECT * FROM beginner.employee;