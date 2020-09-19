insert into order_item values(11101,'CR','Card Reader',10);
insert into order_item values(11102,'PD','Pen Drive',10);
insert into order_item values(11103,'HD','Hard Disk',10);


insert into orders values (10001,'Amit Goyal',sysdate(),'Pune',30,11101);
insert into orders values (10002,'Akash',sysdate(),'Pune',50,11102);
insert into orders values (10003,'Sachin',sysdate(),'Pune',60,11103);
insert into orders values (10004,'Rohan',sysdate(),'Pune',20,11102);

/*
create table orders 
(id integer not null, 
customer_name varchar(255), 
order_date timestamp, 
shipping_address varchar(255), 
total integer, 
item_id integer,
primary key (id))

insert into orders values (10001,'Amit Goyal',11101,sysdate(),'Pune',30);
insert into orders values (10002,'Akash',11102,sysdate(),'Pune',50);
insert into orders values (10003,'Sachin',11103,sysdate(),'Pune',60);
insert into orders values (10004,'Rohan',11102,sysdate(),'Pune',20);



 create table order (
 id integer not null, 
 customer_name varchar(255), 
 item_id integer, 
 order_date timestamp, 
 shipping_address varchar(255), 
 total integer, primary key (id))
 */
