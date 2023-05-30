CREATE TABLE employee(emp_id int, emp_name varchar(255), address varchar(255),city varchar(255),postal_code varchar(255) ,country varchar(255),PRIMARY KEY (emp_id));
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (001,'Ramasundar','Karnataka,India', 'Banglore','765904','India');
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (002,'Alex','London,England', 'London','333491','England');
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (003,'Alford','New York,USA', 'HempStead','743104','USA');
insert into employee(emp_id,emp_name,address,city,postal_code,country) values (005,'Ravi Kumar','Tamil Nadu,India', 'Chennai','567994','India');


CREATE TABLE salary (
  emp_id INT,
  salary_amount DECIMAL(10, 2),
  currency VARCHAR(50),
  PRIMARY KEY (emp_id),
  FOREIGN KEY (emp_id) REFERENCES employee(emp_id)
);
INSERT INTO salary (emp_id, salary_amount, currency) VALUES
  (001, 5000.00, 'USD'),
  (002, 6500.00, 'GBP'),
  (003, 7000.00, 'USD'),
  (005, 4500.00, 'EUR');
  
-- Performing the four types of joins
-- Inner Join
SELECT employee.emp_id, employee.emp_name, salary.salary_amount, salary.currency
FROM employee
INNER JOIN salary ON employee.emp_id = salary.emp_id;

-- Right Join
SELECT employee.emp_id, employee.emp_name, salary.salary_amount, salary.currency
FROM employee
RIGHT JOIN salary ON employee.emp_id = salary.emp_id;

-- Left Join
SELECT employee.emp_id, employee.emp_name, salary.salary_amount, salary.currency
FROM employee
LEFT JOIN salary ON employee.emp_id = salary.emp_id;


-- Cross Join
SELECT employee.emp_id, employee.emp_name, salary.salary_amount, salary.currency
FROM employee
CROSS JOIN salary;




