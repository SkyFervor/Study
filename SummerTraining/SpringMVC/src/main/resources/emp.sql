drop database if exists emp;
create database emp;
use emp;

create table t_dept(
	id int(3) primary key auto_increment,
	dname varchar(255) not null
);

create table t_emp(
	id int(11) primary key auto_increment,
	ename varchar(255) not null,
	salary decimal not null,
	age int(3) not null,
	dept_id int(3)
);

insert into t_dept(id,dname) values(1,'项目部');
insert into t_dept(id,dname) values(2,'咨询部');
insert into t_dept(id,dname) values(3,'行政部');
insert into t_dept(id,dname) values(4,'院校合作部');
insert into t_dept(id,dname) values(5,'财务部');

insert into t_emp(id,ename,salary,age,dept_id) values(1,'张三',1000,20,1);
insert into t_emp(id,ename,salary,age,dept_id) values(2,'李四',2000,21,2);