create database QuanLyDiemThi;

create table HocSinh(
MaHS varchar(20),
TenHS varchar(50),
NgaySinh datetime,
Lop varchar(20),
GT varchar(20),
primary key (MaHS)
);

create table MonHoc(
MaMH varchar(20),
TenMH varchar(50),
primary key (MaMH)
);

create table BangDiem(
MaHS varchar(20),
MaMH varchar(20),
DiemThi int,
NgayKT datetime,
primary key(MaHS, MaMH),
foreign key(MaHS) references HocSinh(MaHS),
foreign key(MaMH) references MonHoc(MaMH)
);

create table GiaoVien(
MaGV varchar(20),
TenGV varchar(20),
SDT varchar(10),
primary key (MaGV)
);

alter table MonHoc add MaGV varchar(20);

alter table MonHoc add constraint FK_MaGV foreign key(MaGV) references GiaoVien(MaGV);
