create table customers (
username varchar2 not null,
name varchar2 not null,
address varchar2 not null,
cardDetails varchar2 not null,
password varchar2 not null,
--
constraint pk_customer primary key(username)
);