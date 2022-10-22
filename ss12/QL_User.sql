create table account(
id int auto_increment,
username nvarchar(50),
password nvarchar(50),
idadmin int,
primary key (id)
);

insert into account (username, password, idadmin) values('Khoa', '123456', 0);

select * from account;
select * from account where username = 'Minh' and password = '123456';

create table category(
id int auto_increment,
name nvarchar(50),
primary key (id)
);

insert into category values (1, 'Giay ADIDAS');
insert into category values (2, 'Giay NIKE');

create table product(
id int auto_increment,
name nvarchar(50),
image nvarchar(500),
price double,
title nvarchar(50),
description nvarchar(50),
cateid int,
primary key (id),
foreign key (cateid) references category(id)
);
insert into product values (1, 'Giay ADIDIDASS 3 soc', 'https://sadesign.vn/wp-content/uploads/2021/04/chup-anh-giay-dep.jpg', 200000, 'Giay ADIDIDASS 3 soc', 'Giay ADIDIDASS 3 soc', 1);
insert into product values (2, 'Giay Nike thoi trang', 'https://cf.shopee.vn/file/b04fe791f1154e8843bdd7102d938b14', 150000, 'Giay Nike thoi trang', 'Giay Nike thoi trang', 2);

select * from product;