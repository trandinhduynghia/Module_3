create table vitri(
MaViTri int auto_increment,
TenViTri varchar(50),
primary key (MaViTri)
);

create table trinhdo(
MaTrinhDo int auto_increment,
TenTrinhDo varchar(50),
primary key (MaTrinhDo)
);

create table bophan(
MaBoPhan int auto_increment,
TenBoPhan varchar(50),
primary key (MaBoPhan)
);

create table nhanvien(
MaNV int auto_increment,
usersHoTen varchar(50),
NgaySinh date,
SoCMND varchar(50),
Luong double,
SoDT varchar(50),
Email varchar(50),
DiaChi varchar(50),
MaViTri int,
MaTrinhDo int,
MaBoPhan int,
primary key (MaNV),
foreign key (MaViTri) references vitri(MaViTri),
foreign key (MaTrinhDo) references trinhdo(MaTrinhDo),
foreign key (MaBoPhan) references bophan(MaBoPhan)
);

create table loaikhach(
MaLoaiKhach int auto_increment,
TenLoaiKhach varchar(50),
primary key (MaLoaiKhach)
);

create table khachhang(
MaKH int auto_increment,
MaLoaiKhach int,
HoTen varchar(50),
NgaySinh date,
GioiTinh varchar(50),
SoCMND varchar(50),
SoDT varchar(50),
Email varchar(50),
DiaChi varchar(50),
primary key (MaKH),
foreign key (MaLoaiKhach) references loaikhach(MaLoaiKhach)
);

create table loaidichvu(
MaLoaiDichVu int auto_increment,
TenLoaiDichVu varchar(50),
primary key (MaLoaiDichVu)
);

create table kieuthue(
MaKieuThue int auto_increment,
TenKieuThue varchar(50),
primary key (MaKieuThue)
);

create table dichvu(
MaDichVu int auto_increment,
TenDichVu varchar(50),
DienTich double,
ChiPhiThue double,
SoNguoiToiDa int,
MaKieuThue int,
MaLoaiDichVu int,
TieuChuanPhong varchar(50),
MoTaTienNghiKhac varchar(50),
DienTichHoBơi double,
SoTang int,
primary key (MaDichVu),
foreign key (MaKieuThue) references kieuthue(MaKieuThue),
foreign key (MaLoaiDichVu) references loaidichvu(MaLoaiDichVu)
);

create table hopdong(
MaHopDong int auto_increment,
NgayLapHopDong datetime,
NgayKetThuc datetime,
TienDatCoc double,
MaNV int,
MaKH int,
MaDichVu int,
primary key (MaHopDong),
foreign key (MaNV) references nhanvien(MaNV),
foreign key (MaKH) references khachhang(MaKH),
foreign key (MaDichVu) references dichvu(MaDichVu)
);

create table dichvudikem(
MaDichVuDiKem int auto_increment,
TenDichVuDiKem varchar(50),
Gia double,
DonVi varchar(50),
TrangThai varchar(50),
primary key (MaDichVuDiKem)
);

create table hopdongchitiet(
MaHopDongChiTiet int auto_increment,
MaHopDong int,
MaDichVuDiKem int,
SoLuong int,
primary key (MaHopDongChiTiet),
foreign key (MaHopDong) references hopdong(MaHopDong),
foreign key (MaDichVuDiKem) references dichvudikem(MaDichVuDiKem)
);

insert into vitri values(1, 'Quản Lý');
insert into vitri values(2, 'Nhân Viên');

insert into trinhdo values(1, 'Trung Cấp');
insert into trinhdo values(2, 'Cao Đẳng');
insert into trinhdo values(3, 'Đại Học');
insert into trinhdo values(4, 'Sau Đại Học');

insert into bophan values(1, 'Sale-Marketing');
insert into bophan values(2, 'Hành Chính');
insert into bophan values(3, 'Phục Vụ');
insert into bophan values(4, 'Quản Lý');

insert into nhanvien values(1, 'Nguyễn Văn An', '1970-11-07', '456231786', 10000000, 0901234121, 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng', 1, 3, 1 );
insert into nhanvien values(2, 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, 0934212314, 'binhly@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2 );
insert into nhanvien values(3, 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000, 0412352315, 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2 );
insert into nhanvien values(4, 'Võ Công Toản', '1980-04-04', '123231365', 17000000, 0374443232, 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4 );
insert into nhanvien values(5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, 0902341231, 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1 );
insert into nhanvien values(6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, 0978653213, 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3 );
insert into nhanvien values(7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, 0941234553, 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2 );
insert into nhanvien values(8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, 0642123111, 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4 );
insert into nhanvien values(9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, 0245144444, 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4 );
insert into nhanvien values(10, 'Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, 0988767111, 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2 );
select * from nhanvien;

insert into loaikhach values(1, 'Diamond');
insert into loaikhach values(2, 'Platinium');
insert into loaikhach values(3, 'Gold');
insert into loaikhach values(4, 'Silver');
insert into loaikhach values(5, 'Member');

insert into khachhang values(1, 5, 'Nguyễn Thị Hào', '1970-11-07', 'nữ','643431213', '0945423362',	'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng');
insert into khachhang values(2, 3,	'Phạm Xuân Diệu',	'1992-08-08', 'nam',		'865342123',	'0954333333',	'xuandieu92@gmail.com',	'K77/22 Thái Phiên, Quảng Trị');
insert into khachhang values(3, 1,	'Trương Đình Nghệ',	'1990-02-27', 'nam',	'488645199',	'0373213122',	'nghenhan2702@gmail.com',	'K323/12 Ông Ích Khiêm, Vinh');
insert into khachhang values(4, 1,	'Dương Văn Quan',	'1981-07-08',	'nam','543432111',	'0490039241',	'duongquan@gmail.com',	'K453/12 Lê Lợi, Đà Nẵng');
insert into khachhang values(5, 4,	'Hoàng Trần Nhi Nhi',	'1995-12-09',	'nữ',	'795453345',	'0312345678',	'nhinhi123@gmail.com',	'224 Lý Thái Tổ, Gia Lai');
insert into khachhang values(6, 4,	'Tôn Nữ Mộc Châu',	'2005-12-06',	'nữ',	'732434215',	'0988888844',	'tonnuchau@gmail.com',	'37 Yên Thế, Đà Nẵng');
insert into khachhang values(7, 1,	'Nguyễn Mỹ Kim',	'1984-04-08',	'nữ',	'856453123',	'0912345698',	'kimcuong84@gmail.com',	'K123/45 Lê Lợi, Hồ Chí Minh');
insert into khachhang values(8, 3,	'Nguyễn Thị Hào',	'1999-04-08',	'nữ',	'965656433',	'0763212345',	'haohao99@gmail.com',	'55 Nguyễn Văn Linh, Kon Tum');
insert into khachhang values(9, 1,	'Trần Đại Danh',	'1994-07-01',	'nam',	'432341235',	'0643343433',	'danhhai99@gmail.com',	'24 Lý Thường Kiệt, Quảng Ngãi');
insert into khachhang values(10, 2,	'Nguyễn Tâm Đắc',	'1989-07-01',	'nam',	'344343432',	'0987654321',	'dactam@gmail.com',	'22 Ngô Quyền, Đà Nẵng');
select * from khachhang;

insert into kieuthue values(1, 'Year');
insert into kieuthue values(2, 'Month');
insert into kieuthue values(3, 'Day');
insert into kieuthue values(4, 'House');

insert into loaidichvu values(1, 'Villa');
insert into loaidichvu values(2, 'House');
insert into loaidichvu values(3, 'Room');

insert into dichvu values(1,	'Villa Beach Front',	25000,	10000000,	10,3,1,	'vip', 	'Có hồ bơi',	500,	4);
insert into dichvu (MaDichVu, TenDichVu, DienTich, ChiPhiThue, SoNguoiToiDa, MaKieuThue, MaLoaiDichVu, TieuChuanPhong, MoTaTienNghiKhac, SoTang) 
values(2,	'House Princess 01',	'14000',	'5000000',	7,2,2,	'vip',	'Có thêm bếp nướng',3);
insert into dichvu (MaDichVu, TenDichVu, DienTich, ChiPhiThue, SoNguoiToiDa, MaKieuThue, MaLoaiDichVu, TieuChuanPhong, MoTaTienNghiKhac) 
values(3,	'Room Twin 01',	5000,	1000000,	2,	4, 3, 'normal',	'Có tivi');
insert into dichvu values(4,	'Villa No Beach Front',	22000,	9000000,	8,3,1,	'normal',	'Có hồ bơi',	300,	3);
insert into dichvu (MaDichVu, TenDichVu, DienTich, ChiPhiThue, SoNguoiToiDa, MaKieuThue, MaLoaiDichVu, TieuChuanPhong, MoTaTienNghiKhac, SoTang) 
values(5,	'House Princess 02',	10000,	4000000,	5,3,2,	'normal',	'Có thêm bếp nướng',2);
insert into dichvu (MaDichVu, TenDichVu, DienTich, ChiPhiThue, SoNguoiToiDa, MaKieuThue, MaLoaiDichVu, TieuChuanPhong, MoTaTienNghiKhac) 
values(6,	'Room Twin 02',	3000,	900000,	2,4,3,	'normal',	'Có tivi');
select * from dichvu;

insert into dichvudikem values(1,	'Karaoke',	10000,	'giờ',	'tiện nghi, hiện tại');
insert into dichvudikem values(2,	'Thuê xe máy',	10000,	'chiếc',	'hỏng 1 xe');
insert into dichvudikem values(3,	'Thuê xe đạp',	20000,	'chiếc',	'tốt');
insert into dichvudikem values(4,	'Buffet buổi sáng',	15000,	'suất',	'đầy đủ đồ ăn, tráng miệng');
insert into dichvudikem values(5,	'Buffet buổi trưa',	90000,	'suất',	'đầy đủ đồ ăn, tráng miệng');
insert into dichvudikem values(6,	'Buffet buổi tối',	16000,	'suất',	'đầy đủ đồ ăn, tráng miệng');

insert into hopdong values(1,	'2020-12-08',	'2020-12-08',	0,	3,	1,	3);
insert into hopdong values(2,	'2020-07-14',	'2020-07-21',	200000,	7,	3,	1);
insert into hopdong values(3,	'2021-03-15',	'2021-03-17',	50000,	3,	4,	2);
insert into hopdong values(4,	'2021-01-14',	'2021-01-18',	100000,	7,	5,	5);
insert into hopdong values(5,	'2021-07-14',	'2021-07-15',	0,	7,	2,	6);
insert into hopdong values(6,	'2021-06-01',	'2021-06-03',	0,	7,	7,	6);
insert into hopdong values(7,	'2021-09-02',	'2021-09-05',	100000,	7,	4,	4);
insert into hopdong values(8,	'2021-06-17',	'2021-06-18',	150000,	3,	4,	1);
insert into hopdong values(9,	'2020-11-19',	'2020-11-19',	0,	3,	4,	3);
insert into hopdong values(10,	'2021-04-12',	'2021-04-14',	0,	10,	3,	5);
insert into hopdong values(11,	'2021-04-25',	'2021-04-25',	0,	2,	2,	1);
insert into hopdong values(12,	'2021-05-25',	'2021-05-27',	0,	7,	10,	1);

insert into hopdongchitiet values(1,	2,	4,	5);
insert into hopdongchitiet values(2,		2,	5, 8);
insert into hopdongchitiet values(3,		2,	6, 15);
insert into hopdongchitiet values(4,		3,	1, 1);
insert into hopdongchitiet values(5,		3,	2, 11);
insert into hopdongchitiet values(6,		1,	3, 1);
insert into hopdongchitiet values(7,		1,	2, 2);
insert into hopdongchitiet values(8,		12,	2, 2);
select * from hopdongchitiet;

-- 2
select * from nhanvien where HoTen like 'H%' or HoTen like 'T%' or HoTen like 'K%' and length(HoTen) <= 15;
-- 3
select MaKH, MaLoaiKhach, HoTen, NgaySinh, GioiTinh, SoCMND, SoDT, Email, DiaChi, (year(curdate()) - year(NgaySinh)) - (right(curdate(), 5) < right(NgaySinh, 5)) AS Tuoi 
from khachhang
where DiaChi like '%Đà Nẵng' or DiaChi like '%Quảng Trị'
having Tuoi between 18 and 50;
-- 4
select k.MaKH, k.HoTen, count(h.MaKh) as SoLanDatPhong
from khachhang k join hopdong h on k.MaKH=h.MaKH
where k.MaLoaiKhach = 1
group by k.MaKH
order by SoLanDatPhong asc;
-- 5 
select k.MaKH, k.HoTen, l.TenLoaiKhach, h.MaHopDong, d.TenDichVu, h.NgayLapHopDong, h.NgayKetThuc, sum(d.ChiPhiThue + c.SoLuong * dv.Gia) as TongTien
from khachhang k join hopdong h on k.MaKH=h.MaKH join loaikhach l on k.MaLoaiKhach=l.MaLoaiKhach join dichvu d on h.MaDichVu=d.MaDichVu join hopdongchitiet c on
h.MaHopDong=c.MaHopDong join dichvudikem dv on c.MaDichVuDiKem=dv.MaDichVuDiKem 
group by h.MaKH;
-- 6
select d.MaDichVu, d.TenDichVu, d.DienTich, d.ChiPhiThue, l.TenLoaiDichVu
from dichvu d join loaidichvu l on d.MaLoaiDichVu=l.MaLoaiDichVu
where not exists(select NgayLapHopDong from hopdong where (NgayLapHopDong between '2021-01-01' and '2021-03-31') and d.MaDichVu=hopdong.MaDichVu);
-- 7
select d.MaDichVu, d.TenDichVu, d.DienTich, d.SoNguoiToiDa, d.ChiPhiThue, l.TenLoaiDichVu
from dichvu d join loaidichvu l on d.MaLoaiDichVu=l.MaLoaiDichVu
where exists (select NgayLapHopDong from hopdong where year(NgayLapHopDong) = '2020' and hopdong.MaDichVu=d.MaDichVu)
and not exists (select NgayLapHopDong from hopdong where year(NgayLapHopDong) = '2021' and hopdong.MaDichVu=d.MaDichVu);
-- 8 
select distinct HoTen from khachhang;
-- 9
select month(h.NgayLapHopDong) as Thang, count(h.MaKH) as SoLan from hopdong h
where year(h.NgayLapHopDong) = '2021'
group by Thang
order by Thang asc;
-- 10
select h.MaHopDong, h.NgayLapHopDong, h.NgayKetThuc, h.TienDatCoc, sum(c.SoLuong) as SoLuongDichVuDiKem
from hopdong h join hopdongchitiet c on h.MaHopDong=c.MaHopDong
group by h.MaHopDong
order by h.MaHopDong asc;
-- 11 
select k.MaDichVuDiKem, k.TenDichVuDiKem 
from dichvudikem k join hopdongchitiet c on k.MaDichVuDiKem=c.MaDichVuDiKem
join hopdong h on c.MaHopDong=h.MaHopDong
join khachhang kh on h.MaKH=kh.MaKH
join loaikhach l on kh.MaLoaiKhach=l.MaLoaiKhach
where l.TenLoaiKhach = 'Diamond' and  (kh.DiaChi like '%Vinh%' or kh.DiaChi like '%Quảng Ngãi%')
group by k.MaDichVuDiKem;
-- 12 
select h.MaHopDong, n.HoTen, k.HoTen, k.SoDT, d.TenDichVu, sum(c.SoLuong) as SoLuongDichVuDiKem, h.TienDatCoc
from hopdong h 
 join nhanvien n on h.MaNV=n.MaNV
 join khachhang k on h.MaKH=k.MaKH
 join dichvu d on h.MaDichVu=d.MaDichVu
 join hopdongchitiet c on h.MaHopDong=c.MaHopDong
where not exists (select NgayLapHopDong from hopdong where NgayLapHopDong between '2021/01/01' and '2021/06/31')
and exists (select NgayLapHopDong from hopdong where NgayLapHopDong between '2020/10/01' and '2020/12/31')
group by h.MaHopDong;
-- 13
select k.MaDichVuDiKem, k.TenDichVuDiKem, sum(c.SoLuong) as SoLuongDichVuDiKem
from dichvudikem k join hopdongchitiet c on k.MaDichVuDiKem=c.MaDichVuDiKem
group by k.MaDichVuDiKem
having SoLuongDichVuDiKem >=all (select sum(c.SoLuong) from dichvudikem k join hopdongchitiet c on k.MaDichVuDiKem=c.MaDichVuDiKem group by k.MaDichVuDiKem);
-- 14
select h.MaHopDong, l.TenLoaiDichVu, k.TenDichVuDiKem, count(c.MaDichVuDiKem) as SoLanSuDung
from hopdong h join loaidichvu l on h.MaDichVu=l.MaLoaiDichVu
join hopdongchitiet c on h.MaHopDong=c.MaHopDong
join dichvudikem k on c.MaDichVuDiKem=k.MaDichVuDiKem
group by k.TenDichVuDiKem
having SoLanSuDung = 1;
-- 15
select n.MaNV, HoTen, TenTrinhDo, TenBoPhan, SoDT, DiaChi, count(h.MaNV) as SoLanLapHopDong
from nhanvien n join trinhdo t on n.MaTrinhDo=t.MaTrinhDo
join bophan b on n.MaBoPhan=b.MaBoPhan
join hopdong h on n.MaNV=h.MaNV
group by n.HoTen
having SoLanLapHopDong <= 3;
-- 16 
delete from nhanvien n
where n.MaNV not in(
select h.MaNV from hopdong h 
where  year(NgayLapHopDong) in (2019, 2020, 2021)
);
-- 17 chua
update khachhang kh
set kh.MaLoaiKhach = 1
where kh.MaKH in(
select * from (select kh.MaKH from khachhang kh 
left join loaikhach l using(MaLoaiKhach)
where l.TenLoaiKhach = 'Palatinium' as a)
);
-- 18
set foreign_key_checks = 0;
delete from khachhang kh
where kh.MaKH in (
select h.MaKH 
from hopdong h 
where year(h.NgayLapHopDong) < 2021
);
set foreign_key_checks = 1;
-- 19
update dichvudikem
set Gia = Gia * 2
where(
MaDichVuDiKem in (select * from(select MaDichVuDiKem from hopdongchitiet
group by MaDichVuDiKem
having sum(SoLuong) > 10) as a)
);
-- 20
select MaNV, HoTen, Email, SoDT, NgaySinh, DiaChi from nhanvien
union
select MaKH, HoTen, Email, SoDT, NgaySinh, DiaChi from khachhang;
-- 21
create view v_nhan_vien as(
select n.MaNV, n.HoTen, n.DiaChi, h.NgayLapHopDong 
from nhanvien n
join hopdong h on n.MaNV=h.MaNV
where n.DiaChi  like '%Hải Châu%' and h.NgayLapHopDong = '2019-12-12'
);
select * from v_nhan_vien;
-- 22 chua xong
update nhanvien 
set DiaChi = 'Liên Chiểu'
where MaNV in (select MaNV from v_nhan_vien);
-- 23
delimiter //
create procedure sp_xoa_khach_hang(MaKH int)
begin
delete from khachhang kh
where kh.MaKH=MaKH;
end //
delimiter ;
call sp_xoa_khach_hang();
-- 24
delimiter //
create procedure sp_them_moi_hop_dong(MaHopDong int, MaKH int)
begin
if MaHopDong not in (select h.MaHopDong from hopdong h) then
insert into hopdong (MaHopDong, MaKH) value (MaHopDong, MaKH);
end if;
delete from khachhang kh
where kh.MaKH=MaKH;
end //
delimiter ;
call sp_them_moi_hop_dong(15, 1);
-- 25

select * from hopdong;
select * from khachhang;
select * from nhanvien;
select * from hopdongchitiet;
select * from dichvudikem;
SET SQL_SAFE_UPDATES = 0;























