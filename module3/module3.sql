create database module3;

create table trangthai(
MaTrangThai int auto_increment primary key,
TrangThai varchar(50)
);

create table loai(
MaLoai int auto_increment primary key,
Loai varchar(50)
);

create table matbang(
MaMatBang int auto_increment primary key,
DienTich int,
MaTrangThai int,
SoLuong int,
MaLoai int,
GhiChu varchar(50),
GiaTien int,
NgayThue date,
NgayTra date,
foreign key (MaTrangThai) references trangthai(MaTrangThai),
foreign key (MaLoai) references loai(MaLoai)
);

insert into trangthai (MaTrangThai, TrangThai) values (1, 'on');
insert into trangthai (MaTrangThai, TrangThai) values (2, 'of');

insert into loai  values (1, 'hội nghị');
insert into loai values (2, 'đám cưới');

insert into matbang values ("1", 50, 1, 5, 1,"mặt bằng hội nghị", 5000000, '2022-11-8', '2022-11-10');
insert into matbang values ("2", 100, 1, 5, 2,"mặt bằng đám cưới", 10000000, '2022-11-20', '2022-11-22');

create table sach(
MaSach int auto_increment primary key,
TenSach varchar(50),
TacGia varchar(50),
MoTa varchar(50),
SoLuong int
);

create table hocsinh(
MaHS int auto_increment primary key,
HoTen varchar(50),
Lop varchar(50)
);

create table themuonsach(
MaMuonSach int auto_increment primary key,
MaSach int,
MaHS int,
TrangThai varchar(50),
NgayMuon date,
NgayTra date,
foreign key (MaSach) references sach(MaSach),
foreign key (MaHS) references hocsinh(MaHS)
);

insert into sach values (1, 'số đỏ', 'vũ trọng phụng', 'nhân vật chính là ...', 10);
insert into sach values (2, 'truyện kiều', 'nguyễn du', 'cuộc đời ...', 15);

insert into hocsinh values (1, 'nghĩa', 'a0422i1');
insert into hocsinh values (2, 'khoa', 'a0422i1');

insert into themuonsach values (1, '1', '1', 'đang mượn', '2022-11-14', '2022-11-20');

SET FOREIGN_KEY_CHECKS = 0; 

create table hinhthucthanhtoan(
MaHinhThuc int auto_increment primary key,
TenHinhThuc varchar(50)
);

create table phongtro(
MaPhongTro int auto_increment primary key,
TenNguoiThueTro varchar(50),
Sdt varchar(50),
NgayBatDau date,
HinhThucThanhToan int,
GhiChu varchar(50),
foreign key (HinhThucThanhToan) references hinhthucthanhtoan(MaHinhThuc)
);
insert into hinhthucthanhtoan values (1, 'theo tháng');
insert into hinhthucthanhtoan values (2, 'theo quý');
insert into hinhthucthanhtoan values (3, 'theo năm');

insert into phongtro values (1, 'nghĩa', '0123456789', '2022-11-14', '1', 'có ...');

select * from phongtro where MaPhongTro like '1' and TenNguoiThueTro like 'nghia' and Sdt like '0123456789'
