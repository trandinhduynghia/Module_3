create table donhang(
Madon int auto_increment,
Ngaydat datetime,
Tinhtrang nvarchar(50),
Manguoidung int,
primary key (Madon),
foreign key (Manguoidung) references nguoidung(Manguoidung)
);
ALTER TABLE donhang
MODIFY COLUMN Madon int auto_increment;
ALTER TABLE donhang
ADD Manguoiban int;
select  Madon from donhang order by Madon desc limit 1;
select * from nguoidung;
select * from donhang;
select * from chitietdonhang;
create table chitietdonhang(
Madon int,
Masp int,
Soluong int,
Dongia decimal(10, 0),
foreign key (Madon) references donhang(Madon),
foreign key(Masp) references sanpham(Masp)
);

insert into hedieuhanh values (1, 'Android');
insert into hedieuhanh values (2, 'IOS');
insert into hedieuhanh values (3, 'VOS');

create table danhmuc(
Madanhmuc int auto_increment primary key,
Tendanhmuc varchar(50)
);
insert into danhmuc values (1, 'Sam Sung');
insert into danhmuc values (2, 'Apple');
insert into danhmuc values (3, 'Xiaomi');
insert into danhmuc values (4, 'Oppo');
insert into danhmuc values (5, 'Vivo');

insert into phanquyen values (0, 'Người dùng');
insert into phanquyen values (1, 'Admin');
insert into phanquyen values (2, 'Người bán');

insert into nguoidung values (1, 'Trần Đình Duy Nghĩa', 'nghia@gmail.com', '0977139079', '123456', 1);
insert into nguoidung values (2, 'Trần Đăng Khoa', 'khoa@gmail.com', '0765791651', '123456', 0);
insert into nguoidung values (8, 'Phạm Trần Gia Thịnh', 'thinh@gmail.com', '0147852963', '123456', 0);
ALTER TABLE nguoidung
MODIFY COLUMN Manguoidung int auto_increment ;
ALTER TABLE nguoidung
MODIFY COLUMN Hoten nvarchar(50) ;
ALTER TABLE nguoidung
ADD Diachi varchar(100);
select * from nguoidung;


ALTER TABLE sanpham
MODIFY COLUMN Anhbia varchar(1000);
select * from hangsanxuat;
select * from sanpham;
SET FOREIGN_KEY_CHECKS = 0; 

create table sanpham(
Masp int auto_increment primary key,
Tensp varchar(100),
Gia decimal(10, 0),
Soluong int,
Mota varchar(50),
Thesim varchar(50),
Bonho varchar(50),
Ram varchar(50),
Anhbia varchar(10000),
Madanhmuc int,
Manguoidung int,
foreign key(Madanhmuc) references danhmuc(Madanhmuc),
foreign key(Manguoidung) references nguoidung(Manguoidung)
);

SET FOREIGN_KEY_CHECKS = 0;

insert into sanpham values (1, 'iPhone 14 Pro Max', 33000000, 1, 'iPhone 14 Pro Max', '1' , '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/10/7/638007285202545738_iphone-14-dd-bh.jpg', 2,2);
insert into sanpham values (2, 'iPhone 11', 13000000, 1, 'iPhone 11', '1', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/10/26/637393169370871358_ip-11-dd.png', 2,2);
insert into sanpham values (3, 'iPhone 13 Mini', 18000000, 1, 'iPhone 13 Mini', '1', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/10/7/638007354289827488_iphone-13-mini-dd-bh.jpg', 2,2);
insert into sanpham values (4, 'iPhone 13 Pro Max', 29000000, 1, 'iPhone 13 Pro Max', '1', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/10/5/638005785995780745_iphone-13-pro-max-dd-bh.jpg', 2,2);

insert into sanpham values (5, 'Samsung Galaxy Note 9', 4500000, 1, 'Samsung Galaxy Note 9', '1', '128GB', '6G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2018/8/20/636703736253920068_note9-1o-den.png', 1,2);
insert into sanpham values (6, 'Samsung Galaxy Note 20 Ultra', 4200000, 1, 'Samsung Galaxy Note 20 Ultra', '2', '256GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2020/8/5/637322682439532348_ss-note-20-ultra-5g-gold-dd.png', 1,2);
insert into sanpham values (7, 'Samsung Galaxy A73 5G', 11000000, 1, 'Galaxy A73 5G', '2', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/11/1/638028870213975482_samsung-galaxy-a73-xanh-dd-bh.jpg', 1,2);
insert into sanpham values (8, 'Samsung Galaxy Z Flip4', 23000000, 1, 'Samsung Galaxy Z Flip4', '2', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/11/1/638028876072863954_samsung-galaxy-z-flip4-vang-dd-tragop-bh.jpg', 1,2);

insert into sanpham values (9, 'OPPO Reno8 Z 5G', 10500000, 1, 'OPPO Reno8 Z 5G', '2', '256GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/8/5/637952919732230075_oppo-reno8-z-dd.jpg', 4, 7);
insert into sanpham values (10, 'OPPO Reno6 Z 5G', 9000000, 1, 'OPPO Reno6 Z 5G', '2', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/7/8/637613342139496099_oppo-reno6z-dd.jpg', 4,7);
insert into sanpham values (11, 'OPPO Reno7 Z', 7000000, 1, 'OPPO Reno7', '2', '128GB', '8GB', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/5/4/637872590554647546_oppo-reno7-4g-dd.jpg', 4,7);

insert into sanpham values (12, 'Vivo Y22s', 6000000, 1, 'Vivo Y22s', '2', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/9/9/637983398315589960_vivo-y22s-xanh-dd.jpg', 5,7);
insert into sanpham values (13, 'Vivo Y16', 5000000, 1, 'Vivo Y16', '2', '128GB', '4G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/9/9/637983383787368693_vivo-y16-vang-dd.jpg', 5,7);
insert into sanpham values (14, 'Vivo Y02s', 4000000, 1, 'Vivo Y02s', '2', '32GB', '3G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/7/22/637940794893480185_vivo-y02s-3gb-32gb-xanh-dd.jpg', 5,7);

insert into sanpham values (15, 'Xiaomi Redmi 10 2022', 3790000, 1, 'Xiaomi Redmi 10 2022', '2', '32GB', '4G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/10/5/638005849924256638_xiaomi-redmi-10-2022-dd-bh.jpg', 3,7);
insert into sanpham values (16, 'Xiaomi Redmi Note 11 Pro', 7190000, 1, 'Xiaomi Redmi Note 11 Pro', '2', '128GB', '8G', 'https://images.fpt.shop/unsafe/fit-in/214x214/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/10/5/638005799937393515_redmi-note-11-pro-4g-dd-bh.jpg', 3,7);

create table hinhanh(
Mahinhanh int auto_increment primary key,
Hinhanh varchar (1000),
Masp int,
foreign key (Masp) references sanpham(Masp)
);

create table danhgia(
Madanhgia int auto_increment primary key,
Manguoidung int,
Masp int,
Danhgia varchar(100),
foreign key (Masp) references sanpham(Masp),
foreign key (Manguoidung) references nguoidung(Manguoidung)
);

select * from sanpham;

select * from nguoidung;
SET SQL_SAFE_UPDATES = 0;
select * from chitietdonhang where Madon like '3';
select * from chitietdonhang;
delete from chitietdonhang where Madon like '4';