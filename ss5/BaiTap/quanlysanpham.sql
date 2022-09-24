create database sanpham;

create table sanpham(
id int auto_increment,
MaSanPham varchar(10),
TenSanPham varchar(50),
GiaSanPham double,
SoLuongSanPham int,
MoTaSanPham varchar(50),
TrangThaiSanPham varchar(50),
primary key(id)
);

insert into sanpham values(1, 'SP001', 'Heniken', 300000, 10, 'bia', 'còn hàng');
insert into sanpham values(2, 'SP002', 'Larue', 250000, 15, 'bia', 'còn hàng');
insert into sanpham values(3, 'SP003', 'Cocacola', 200000, 5, 'nước ngọt', 'còn hàng');

create unique index index_MaSanPham on sanpham(MaSanPham);
EXPLAIN SELECT * FROM sanpham WHERE MaSanPham = 'SP001';
ALTER TABLE sanpham ADD INDEX sanpham(TenSanPham, GiaSanPham);
EXPLAIN SELECT * FROM sanpham WHERE MaSanPham = 'SP001';

create view sanpham_view as
select MaSanPham, TenSanPham, GiaSanPham, SoLuongSanPham, MoTaSanPham, TrangThaiSanPham
from sanpham;
select * from sanpham_view;

create or replace view sanpham_view as
select MaSanPham, TenSanPham, GiaSanPham, SoLuongSanPham, MoTaSanPham, TrangThaiSanPham
from sanpham
where MoTaSanPham = 'bia';

drop view sanpham_view;

delimiter //
CREATE PROCEDURE sanpham_procedure()
BEGIN
  SELECT * FROM sanpham;
END //
delimiter ;
call sanpham_procedure();

delimiter //
CREATE PROCEDURE themsanpham_procedure(id int, MaSanPham varchar(10), TenSanPham varchar(50), GiaSanPham double, SoLuongSanPham int, MoTaSanPham varchar(50), TrangThaiSanPham varchar(50))
BEGIN
  insert into sanpham values(id , MaSanPham, TenSanPham, GiaSanPham, SoLuongSanPham, MoTaSanPham, TrangThaiSanPham);
END //
delimiter ;
call themsanpham_procedure(4, 'SP004', 'Sting', 200000, 8, 'nước ngọt', 'còn hàng');

delimiter //
CREATE PROCEDURE xoasanpham_procedure(id_xoa int)
BEGIN
  delete from sanpham where id = id_xoa;
END //
delimiter ;
drop procedure xoasanpham_procedure;
SET SQL_SAFE_UPDATES = 0;
call xoasanpham_procedure(3);
select * from sanpham;

delimiter //
CREATE PROCEDURE capnhatsanpham_procedure(id_capnhat int, MaSanPham varchar(10), TenSanPham varchar(50), GiaSanPham double, SoLuongSanPham int, MoTaSanPham varchar(50), TrangThaiSanPham varchar(50))
BEGIN
  update sanpham set MaSanPham = MaSanPham, TenSanPham = TenSanPham, GiaSanPham = GiaSanPham, SoLuongSanPham = SoLuongSanPham, MoTaSanPham = MoTaSanPham, TrangThaiSanPham = TrangThaiSanPham where id = id_capnhat;
END //
delimiter ;
call capnhatsanpham_procedure(3,'SP003','Cocacola', 200000, 20, 'nước ngọt', 'còn hàng');