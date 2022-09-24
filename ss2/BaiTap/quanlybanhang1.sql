create database quanlybanhang1;

create table NhaCC(
MaNCC int not null auto_increment,
TenNCC varchar(50),
DiaChi varchar(50),
SDT varchar(10),
primary key(MaNCC)
);

create table VatTu(
MaVT int not null auto_increment,
TenVT varchar(50),
primary key(MaVT)
);

create table PhieuXuat(
SoPX int not null auto_increment,
NgayXuat datetime,
DGXuat double,
SLXuat int,
MaVT int,
primary key(SoPX),
foreign key(MaVT) references VatTu(MaVT)
);

create table PhieuNhap(
SoPN int not null auto_increment,
NgayNhap datetime,
DGNhap double,
SLNhap int,
MaVT int,
primary key(SoPN),
foreign key(MaVT) references VatTu(MaVT)
);

create table DonDatHang(
SoDH int not null auto_increment,
NgayDH datetime,
MaVT int,
MaNCC int,
primary key(SoDH),
foreign key(MaVT) references VatTu(MaVT),
foreign key(MaNCC) references NhaCC(MaNCC)
);

