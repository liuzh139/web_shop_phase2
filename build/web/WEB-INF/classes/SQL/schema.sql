CREATE TABLE products (
productID INTEGER NOT NULL,
NAME VARCHAR NOT NULL,
description varchar2 not null,
category varchar2 not null,
price number not null,
stock number not null,
CONSTRAINT PK_products PRIMARY KEY(productID)
);

create table customers (
username varchar2 not null,
name varchar2 not null,
address varchar2 not null,
cardDetails varchar2 not null,
password varchar2 not null,
--
constraint pk_customer primary key(username)
);


create table orders (
   orderId integer generated by default as identity (start with 1000) not null,
   date timestamp not null,
   customer varchar(255) not null,
   constraint pk_orders primary key (orderId),
   constraint fk_orders_customers foreign key (customer) references customers(username)
);


create table orderitems (
   orderId integer not null,
   productId varchar(255) not null,
   quantity double not null,
   constraint pk_orderitems primary key (orderId, productId),
   constraint fk_orderitems_orders foreign key (orderId) references orders(orderId),
   constraint fk_orderitems_products foreign key (productId) references products(productId)
);


insert into customers values ('jimbob','Jimbob Jenkins','123 Redneck Road', 'Visa 1233-23423-3242-32342', 'jimbob');
insert into customers values ('homer','Homer Simpson','742 Evergreen Terrace', 'Visa 4234-2364-8323-2342', 'doh');

insert into products values('1', 'Golden Retriver', 'Smart and thole, very friendly with kids.', 'Dog', 1800, 10);
insert into products values('2', 'Bichon Frise', 'As cute as your Tiddy Bear.', 'Companion Dog', 1500, 10);
insert into products values('3', 'English Cocker Spaniel', 'Very colourful widget.', 'widgets',  123.35, 10);
insert into products values('4', 'Dodgy doohicky', 'This doohicky has no guarantees.  It might work, or it might not.', 'doohickies', 12.43, 10);
insert into products values('5', 'Tartan Flange', 'A flange that wears a kilt.', 'flanges', 23.43, 10);
insert into products values('6', 'Polkadot Dohicky', 'A spotted dohicky.', 'doohickies', 43.23, 10);