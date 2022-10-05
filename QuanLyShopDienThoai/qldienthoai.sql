create table donhang(
Madon int auto_increment,
Ngaydat datetime,
Tinhtrang nvarchar(50),
Manguoidung int,
primary key (Madon),
foreign key (Manguoidung) references nguoidung(Manguoidung)
);

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

insert into hangsanxuat values (1, 'Sam Sung');
insert into hangsanxuat values (2, 'Apple');
insert into hangsanxuat values (3, 'Xiaomi');
insert into hangsanxuat values (4, 'Oppo');
insert into hangsanxuat values (5, 'Vivo');

insert into phanquyen values (0, 'Người dùng');
insert into phanquyen values (1, 'Admin');

insert into nguoidung values (1, 'Trần Đình Duy Nghĩa', 'nghia@gmail.com', '0977139079', '123456', 1);
insert into nguoidung values (2, 'Trần Đăng Khoa', 'khoa@gmail.com', '0765791651', '123456', 0);
insert into nguoidung values (8, n'Phạm Trần Gia Thịnh', 'thinh@gmail.com', '0147852963', '123456', 0);
ALTER TABLE nguoidung
MODIFY COLUMN Manguoidung int auto_increment ;
ALTER TABLE nguoidung
MODIFY COLUMN Hoten nvarchar(50) ;
select * from nguoidung;


ALTER TABLE sanpham
MODIFY COLUMN Anhbia varchar(1000);
insert into sanpham values (1, 'iPhone 14 Pro Max', 33000000, 10, 'iPhone 14 Pro Max', 1, 128, 8, 'https://images.fpt.shop/unsafe/fit-in/400x400/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Mediums/2022/9/12/637985700630020572_ip-14-pro-max-tim.png', 2, 2);
insert into sanpham values (2, 'iPhone 11', 13000000, 10, 'iPhone 11', 1, 128, 8, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2019/9/11/637037652463173144_11-xanh.png', 2, 2);
insert into sanpham values (3, 'iPhone 13 Mini', 18000000, 10, 'iPhone 13 Mini', 1, 128, 8, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/9/15/637673199792405469_iphone-13-mini-hong-1.jpg', 2, 2);
insert into sanpham values (4, 'iPhone 13 Pro Max', 29000000, 10, 'iPhone 13 Pro Max', 1, 128, 8, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2021/9/15/637673217826201634_iphone-13-pro-max-xanh-1.jpg', 2, 2);

insert into sanpham values (5, 'Samsung Galaxy Note 9', 4500000, 10, 'Samsung Galaxy Note 9', 2, 512, 6, 'https://shopdidong.vn/profiles/shopdidongvn/uploads/attach/1632221160_note99.jpg', 1, 1);
insert into sanpham values (6, 'Samsung Galaxy Note 20 Ultra', 4200000, 10, 'Samsung Galaxy Note 20 Ultra', 2, 256, 8, 'https://didongrenhat.com/wp-content/uploads/2022/06/black_final-768x768.jpg', 1, 1);
insert into sanpham values (7, 'Samsung Galaxy A73 5G', 11000000, 10, 'Galaxy A73 5G', 2, 128, 8, 'https://images.samsung.com/is/image/samsung/p6pim/vn/sm-a736blggxxv/gallery/vn-galaxy-a73-5g-a736-sm-a736blggxxv-531863812?$1300_1038_PNG$', 1, 1);
insert into sanpham values (8, 'Samsung Galaxy Z Flip4', 23000000, 10, 'Samsung Galaxy Z Flip4', 2, 128, 8, 'https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcTTVGjP8W1mdFgCmdLY7ML6mkIrI4grz_1b7d2q1I85OEXGCiYl40AFleRY55BBrUiyeXIApzFf84U&usqp=CAc', 1, 1);

insert into sanpham values (9, 'OPPO Reno8 Z 5G', 10500000, 10, 'OPPO Reno8 Z 5G', 2, 256, 8, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/8/5/637952922019455368_oppo-reno8-z-vang-2.jpg', 4, 1);
insert into sanpham values (10, 'OPPO Reno6 Z 5G', 9000000, 10, 'OPPO Reno6 Z 5G', 2, 128, 8, 'https://cdn.hoanghamobile.com/i/productlist/dsp/Uploads/2021/07/23/image-removebg-preview-3.png', 4, 1);
insert into sanpham values (11, 'OPPO Reno7 Z', 7000000, 10, 'OPPO Reno7', 2, 128, 8, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/4/12/637853832932007647_oppo-reno7-4g-den-1.jpg', 4, 1);

insert into sanpham values (12, 'Vivo Y22s', 6000000, 10, 'Vivo Y22s', 2, 128, 8, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/8/15/637961779017076277_vivo-y22s-xanh-1.jpg', 5, 1);
insert into sanpham values (13, 'Vivo Y16', 5000000, 10, 'Vivo Y16', 2, 128, 4, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/8/29/637973623420693075_vivo-y16-vang-2.jpg', 5, 1);
insert into sanpham values (14, 'Vivo Y02s', 4000000, 10, 'Vivo Y02s', 2, 32, 3, 'https://images.fpt.shop/unsafe/fit-in/38x38/filters:quality(90):fill(white)/fptshop.com.vn/Uploads/Originals/2022/7/22/637940794897386586_vivo-y02s-3gb-32gb-xanh-2.jpg', 5, 1);

