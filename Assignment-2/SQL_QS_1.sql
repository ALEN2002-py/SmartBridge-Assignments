create table student(name varchar(20), reg_no varchar(9), ph_no int(10), year int(4));
insert into student(name,reg_no,ph_no,year) values ('Alen','20BCR7018','5537',2020);
insert into student(name,reg_no,ph_no,year) values ('Adarsh','20BCR7010','9466',2020);
insert into student(name,reg_no,ph_no,year) values ('Gautham','20BCE7190','2518',2020);
insert into student(name,reg_no,ph_no,year) values ('Kiran','20BCB7008','1900',2020);
select * from student;
update student set reg_no = '20BCB7007' where name = 'Kiran';
delete from student where reg_no = '20BCB7007';