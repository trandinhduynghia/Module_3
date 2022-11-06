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

create table Permision(
id int(11) primary key,
name varchar(50)
);

create table User_Permision(
permision_id int(11),
user_id int(11)
);

insert into Permision(id, name) values(1, 'add');

insert into Permision(id, name) values(2, 'edit');

insert into Permision(id, name) values(3, 'delete');

insert into Permision(id, name) values(4, 'view');

DELIMITER //
CREATE PROCEDURE select_user_store()
BEGIN
    SELECT * FROM users;
    END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE delete_user_store(IN user_id INT)
BEGIN
    DELETE 
    FROM users
    where users.id = user_id;
    END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE update_user_store(
IN user_name varchar(50),
IN user_email varchar(50),
IN user_country varchar(50),
IN user_id INT
)
BEGIN
    update users set name = user_name, email = user_email, country = user_country where users.id = user_id;
    END //
DELIMITER ;

select * from users;
select * from user_permision;