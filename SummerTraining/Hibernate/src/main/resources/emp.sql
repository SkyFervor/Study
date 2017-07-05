drop database if exists emp;
create database emp;
use emp;

create table t_dept(
	id int(3) primary key auto_increment,
	dname varchar(64) not null
);

create table t_emp(
	id int(11) primary key auto_increment,
	account varchar(64) unique not null,
	password varchar(64) not null,
	ename varchar(64) not null,
	salary decimal not null,
	age int(3) not null,
	dept_id int(3)
);

insert into t_dept(id,dname) values(1,'项目部');
insert into t_dept(id,dname) values(2,'咨询部');
insert into t_dept(id,dname) values(3,'行政部');
insert into t_dept(id,dname) values(4,'院校合作部');
insert into t_dept(id,dname) values(5,'财务部');

insert into t_emp(id,account,password,ename,salary,age,dept_id) values(1,'111','111','张三',1000,20,1);
insert into t_emp(id,account,password,ename,salary,age,dept_id) values(2,'222','222','李四',2000,21,2);