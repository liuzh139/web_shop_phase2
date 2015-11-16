insert into customers values ('jimbob','Jimbob Jenkins','123 Redneck Road', 'Visa 1233-23423-3242-32342', 'jimbob');
insert into customers values ('homer','Homer Simpson','742 Evergreen Terrace', 'Visa 4234-2364-8323-2342', 'doh');

insert into products values('1', 'Purple flange', 'A nice shiny purple coloured flange.', 'flanges', 12.3, 10);
insert into products values('2', 'Fuzzy widget', 'A widget that needs a shave.', 'widgets', 4.23, 10);
insert into products values('3', 'Technicolour Widget', 'Very colourful widget.', 'widgets',  123.35, 10);
insert into products values('4', 'Dodgy doohicky', 'This doohicky has no guarantees.  It might work, or it might not.', 'doohickies', 12.43, 10);
insert into products values('5', 'Tartan Flange', 'A flange that wears a kilt.', 'flanges', 23.43, 10);
insert into products values('6', 'Polkadot Dohicky', 'A spotted dohicky.', 'doohickies', 43.23, 10);

insert into orders values (101, '2009-10-02 17:06:48.72', 'jimbob');
insert into orders values (102, '2009-10-03 00:03:02.978', 'homer');

insert into orderitems values (101,'1',2);
insert into orderitems values (101,'2',3);
insert into orderitems values (101,'3',1);
insert into orderitems values (102,'4',3);
insert into orderitems values (102,'5',4);
insert into orderitems values (102,'6',1);
insert into orderitems values (102,'1',4);