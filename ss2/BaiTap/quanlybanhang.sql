create database quanlybanhang;

create table KhachHang(
MaKH int not null auto_increment,
Ten varchar(50),
Tuoi int,
primary key (MaKH)
);

create table Hang(
MaHang int not null auto_increment,
TenHang varchar(50),
Gia double,
primary key(MaHang)
);

create table DonHang(
MaDH int not null auto_increment,
MaKH int,
NgayDatHang datetime,
TongGia double,
primary key(MaDH),
foreign key(MaKH) references khachhang(MaKH)
);

create table ChiTietDonHang(
MaDH int,
MaHang int,
foreign key(MaDH) references donhang(MaDH),
foreign key(MaHang) references hang(MaHang)
);
