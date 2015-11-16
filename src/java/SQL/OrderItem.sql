create table orderitems (
   orderId integer not null,
   productId varchar(255) not null,
   quantity double not null,
   constraint pk_orderitems primary key (orderId, productId),
   constraint fk_orderitems_orders foreign key (orderId) references orders(orderId),
   constraint fk_orderitems_products foreign key (productId) references products(productId)
);