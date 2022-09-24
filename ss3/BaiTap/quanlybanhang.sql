insert into khachhang values (1, 'Minh Quan', 10);
insert into khachhang values (2, 'Ngoc Oanh', 20);
insert into khachhang values (3, 'Hong Ha', 50);

insert into donhang (MaDH, MaKH, NgayDatHang) values (1, 1, '2006-3-21');
insert into donhang (MaDH, MaKH, NgayDatHang) values (2, 2, '2006-3-23');
insert into donhang (MaDH, MaKH, NgayDatHang) values (3, 1, '2006-3-16');
select * from donhang;

insert into hang values (1, 'May Giat', 3);
insert into hang values (2, 'Tu Lanh', 5);
insert into hang values (3, 'Dieu Hoa', 7);
insert into hang values (4, 'Quat', 1);
insert into hang values (5, 'Bep Dien', 2);
insert into hang values (6, 'Nồi Cơm', 2);
select * from hang;

alter table chitietdonhang add SoLuong int;
select * from chitietdonhang;
insert into chitietdonhang values (1, 1, 3);
insert into chitietdonhang values (1, 1, 7);
insert into chitietdonhang values (1, 4, 2);
insert into chitietdonhang values (2, 1, 1);
insert into chitietdonhang values (3, 1, 8);
insert into chitietdonhang values (2, 5, 4);
insert into chitietdonhang values (2, 3, 3);

select MaDH, MaKH, NgayDatHang from donhang;

-- select khachhang.MaKH, ten, TenHang, SoLuong from khachhang, hang, chitietdonhang where hang.MaHang=chitietdonhang.MaHang and khachhang.MaKH=donhang.MaKH;
select k.MaKH, k.Ten, h.TenHang, c.SoLuong
from khachhang k join donhang d on k.MaKH=d.MaKH join chitietdonhang c on d.MaDH=c.MaDH join hang h on c.MaHang=h.MaHang; 

select khachhang.MaKH, Ten from khachhang  where khachhang.MaKH not in (select donhang.MaKH from donhang);

select d.MaDH, d.NgayDatHang, sum(h.Gia * c.SoLuong) as TongTien
from donhang d join chitietdonhang c on d.MaDH=c.MaDH join hang h on c.MaHang=h.MaHang
group by d.MaDH;

