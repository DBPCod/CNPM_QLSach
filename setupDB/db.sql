-- create database QLSach

create table NhaXuatBan(
	MaNXB varchar(10),
	TenNXB varchar(100),
	Diachi varchar(100),
	Sodienthoai varchar(10),	
	Email varchar(100),
	Trangthai int,
	Primary key (MaNXB)
);

create table SanPham(
	MaSP Varchar(10),
	TenSP varchar(100),
	SoTrang int,
	NgonNgu varchar(50),
	GiaBia Double PRECISION,
	AnhBia BLOB,
	Soluong Int,
	GiaNhap double PRECISION,
	MaTG Varchar(10),
	Trangthai int,
	Primary key (MaSP)
);

create table TacGia(
	MaTG Varchar(10),
	Hovaten varchar(100),
	ButDanh varchar(50),
	GioiTinh varchar(10),
	QuocTich varchar(50),
	Trangthai int,
	primary key (MaTG)
);

create table TheLoai(
	MaTL Varchar(10),
	TenTL varchar(100),
	Trangthai int,
	primary key (MaTL)
);

create table KhuyenMai(
	MaKM Varchar(10),
	TenKM varchar(50),
	NgayBatDau Date,
	NgayKetThuc Date,
	MaloaiKM varchar(10),
	Trangthai int,
	PhanTramGiam int,
	primary key (MaKM)
);

create table LoaiKhuyenMai(
	MaloaiKM varchar(10),
	TenloaiKM varchar(50),
	Phantramgiam int,
	Trangthai int(11),
	
	primary key (MaloaiKM)
);

create table NhanVien(
	MaNV Varchar(10),
	Hovaten varchar(50),
	NgaySinh Date,
	GioiTinh varchar(10),
	Sodienthoai Varchar(10),
	Email varchar(100),
	DiaChi varchar(100),
	MaTK Varchar(10),
	MaVT Varchar(10),
	Trangthai int,
	primary key (MaNV)
);

create table HoaDon(
	MaHD Varchar(10),
	Ngaylaphoadon Date,
	ThanhTien DOUBLE PRECISION,
	Trangthai INT,
	MaTK Varchar(10),

	primary key(MaHD)
);

create table TaiKhoan(
	MaTK Varchar(10),
	TenTK varchar(50),
	MatkhauTK varchar(10),
	Trangthai int,
	primary key(MaTK)
);

create table PhieuNhap(
	MaPN Varchar(10),
	NgayNhap Date,
	Thanhtien DOUBLE PRECISION,
	Trangthai INT,
	MaTK Varchar(10),
	MaNXB Varchar(10),

	primary key(MaPN)
);

create table VaiTro(
	MaVT Varchar(10),
	TenVT varchar(50),

	primary key(MaVT)
);

create table ChiTietHD(
	MaHD Varchar(10),
	Soluong Int,
	DonGia DOUBLE PRECISION,
	MaSP Varchar(10),
	PRIMARY KEY(MaHD,MaSP)
);

create table ChiTietKM(
	MaKM Varchar(10),
	MaSP Varchar(10),

	PRIMARY KEY(MaKM,MaSP)

);

create table ChiTietPN(
	Soluongnhap Int,
	DonGia DOUBLE PRECISION,
	MaSP Varchar(10),
	MaPN Varchar(10),
	PRIMARY KEY(MaSP,MaPN)
	

);

create table SachTheLoai(
	MaSP Varchar(10),
	MaTL Varchar(10),

	PRIMARY KEY(MaSP,MaTL)
	
);

ALTER TABLE SanPham
ADD FOREIGN KEY (MaTG) REFERENCES TacGia(MaTG);

ALTER TABLE khuyenMai
ADD FOREIGN KEY (MaloaiKM) REFERENCES LoaiKhuyenMai(MaloaiKM);

ALTER TABLE NhanVien
ADD FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK);

ALTER TABLE NhanVien
ADD FOREIGN KEY (MaVT) REFERENCES VaiTro(MaVT);

ALTER TABLE HoaDon
ADD FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK);

ALTER TABLE PhieuNhap
ADD FOREIGN KEY (MaTK) REFERENCES TaiKhoan(MaTK);

ALTER TABLE PhieuNhap
ADD FOREIGN KEY (MaNXB) REFERENCES NhaXuatBan(MaNXB);

ALTER TABLE ChiTietHD
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE ChiTietHD
ADD FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD);

ALTER TABLE ChiTietKM
ADD FOREIGN KEY (MaKM) REFERENCES KhuyenMai(MaKM);

ALTER TABLE ChiTietKM
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE ChiTietPN
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE ChiTietPN
ADD FOREIGN KEY (MaPN) REFERENCES PhieuNhap(MaPN);

ALTER TABLE SachTheLoai
ADD FOREIGN KEY (MaSP) REFERENCES SanPham(MaSP);

ALTER TABLE SachTheLoai
ADD FOREIGN KEY (MaTL) REFERENCES TheLoai(MaTL);