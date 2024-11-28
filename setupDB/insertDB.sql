INSERT INTO NhaXuatBan (MaNXB, TenNXB, Diachi, Sodienthoai, Email, Trangthai) VALUES
('NXB_1', 'Nhà Xuất Bản Kim Đồng', 'Hà Nội', '0123456789', 'info@nxbkimdong.vn', '1'),
('NXB_2', 'Nhà Xuất Bản Trẻ', 'TP Hồ Chí Minh', '0987654321', 'info@nxbtre.vn', '1'),
('NXB_3', 'Nhà Xuất Bản Hội Nhà Văn', 'Đà Nẵng', '0112233445', 'info@nhavanh.vn', '1');

INSERT INTO TacGia (MaTG, Hovaten, ButDanh, GioiTinh, QuocTich, Trangthai) VALUES
('TG_1', 'Nguyễn Văn A', 'A.N', 'Nam', 'Việt Nam', '1'),
('TG_2', 'Trần Thị B', 'B.T', 'Nữ', 'Việt Nam', '1'),
('TG_3', 'Lê Văn C', 'C.L', 'Nam', 'Việt Nam', '1');

INSERT INTO SanPham (MaSP, TenSP, SoTrang, NgonNgu, GiaBia, AnhBia, Soluong, GiaNhap, MaTG, Trangthai) VALUES
('SP_1', 'Sách Giáo Khoa Toán 12', 200, 'Tiếng Việt', 150000, NULL, 50, 100000, 'TG_1', '1'),
('SP_2', 'Sách Lịch Sử Việt Nam', 250, 'Tiếng Việt', 200000, NULL, 30, 150000, 'TG_2', '1'),
('SP_3', 'Tiếng Anh Thông Dụng', 300, 'Tiếng Anh', 180000, NULL, 20, 120000, 'TG_3', '1');

INSERT INTO TheLoai (MaTL, TenTL, Trangthai) VALUES
('TL_1', 'Giáo Khoa', '1'),
('TL_2', 'Học Tập', '1'),
('TL_3', 'Tiếng Anh', '1');

INSERT INTO LoaiKhuyenMai (MaloaiKM, TenloaiKM, Phantramgiam, Trangthai) VALUES
('LKM_1', 'Giảm Giá Theo %', 10, 1),
('LKM_2', 'Mua Nhiều Tặng Nhiều', 0, 1),
('LKM_3', 'Khuyến Mãi Dưới 50%', 15, 1);

INSERT INTO KhuyenMai (MaKM, TenKM, NgayBatDau, NgayKetThuc, MaloaiKM, Trangthai, PhanTramGiam) VALUES
('KM_1', 'Giảm Giá 10%', '2024-10-01', '2024-10-31', 'LKM_1', '1', 10),
('KM_2', 'Mua 2 Tặng 1', '2024-10-05', '2024-10-20', 'LKM_2', '1', 10),
('KM_3', 'Giảm Giá 15% cho sách tiếng Anh', '2024-10-10', '2024-10-15', 'LKM_1', '1', 15);

INSERT INTO TaiKhoan (MaTK, TenTK, MatkhauTK, Trangthai) VALUES
('TK_1', 'quanly', '123456', '1'),
('TK_2', 'nhapkho', 'abcdef', '1'),
('TK_3', 'banhang', 'ghijkl', '1');

INSERT INTO VaiTro (MaVT, TenVT) VALUES
('VT_1', 'Quản Lý'),
('VT_2', 'Nhập Kho'),
('VT_3', 'Bán Hàng');

INSERT INTO NhanVien (MaNV, Hovaten, NgaySinh, GioiTinh, Sodienthoai, Email, DiaChi, MaTK, MaVT, Trangthai) VALUES
('NV_1', 'Nguyễn Văn D', '1990-01-01', 'Nam', '0123456789', 'nv1@example.com', 'Hà Nội', 'TK_1', 'VT_1', '1'),
('NV_2', 'Trần Thị E', '1992-05-15', 'Nữ', '0987654321', 'nv2@example.com', 'TP Hồ Chí Minh', 'TK_2', 'VT_2', '1'),
('NV_3', 'Lê Văn F', '1995-07-20', 'Nam', '0112233445', 'nv3@example.com', 'Đà Nẵng', 'TK_3', 'VT_3', '1');

INSERT INTO HoaDon (MaHD, Ngaylaphoadon, ThanhTien, Trangthai, MaTK) VALUES
('HD_1', '2024-10-10', 150000, 1, 'TK_1'),
('HD_2', '2024-10-11', 200000, 1, 'TK_2'),
('HD_3', '2024-10-12', 300000, 1, 'TK_3');

INSERT INTO PhieuNhap (MaPN, NgayNhap, Thanhtien, Trangthai, MaTK, MaNXB) VALUES
('PN_1', '2024-10-01', 1000000, 1, 'TK_1', 'NXB_1'),
('PN_2', '2024-10-05', 1500000, 1, 'TK_2', 'NXB_2'),
('PN_3', '2024-10-10', 2000000, 1, 'TK_3', 'NXB_3');

INSERT INTO ChiTietHD (MaHD, Soluong, DonGia, MaSP) VALUES
('HD_1', 2, 150000, 'SP_1'),
('HD_1', 1, 200000, 'SP_2'),
('HD_2', 1, 200000, 'SP_2'),
('HD_3', 3, 180000, 'SP_3');

INSERT INTO ChiTietKM (MaKM, MaSP) VALUES
('KM_1', 'SP_1'),
('KM_1', 'SP_2'),
('KM_2', 'SP_3');

INSERT INTO ChiTietPN (Soluongnhap, DonGia, MaSP, MaPN) VALUES
(10, 100000, 'SP_1', 'PN_1'),
(10, 100000, 'SP_1', 'PN_2'),
(5, 150000, 'SP_2', 'PN_2'),
(15, 120000, 'SP_3', 'PN_3');

INSERT INTO SachTheLoai (MaSP, MaTL) VALUES
('SP_1', 'TL_1'),
('SP_2', 'TL_1'),
('SP_2', 'TL_2'),
('SP_3', 'TL_3');
