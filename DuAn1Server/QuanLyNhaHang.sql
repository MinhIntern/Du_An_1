CREATE DATABASE QLyNhaHang;	
GO

USE QLyNhaHang;
GO

-- TẠO TABLE
							--- Bảng Nhân Viên
CREATE TABLE NhanVien (
  ID NVARCHAR(20) PRIMARY KEY,
  Ten NVARCHAR(100),
  Ngaysinh DATE,
  Gioitinh NVARCHAR(10),
  Diachi NVARCHAR(200),
  Sdt NVARCHAR(12),
  Email NVARCHAR(100),
  ChucVu NVARCHAR(20),
  Luong DECIMAL(15, 2),
  NgayTao DATE,
  NgayKetThuc DATE
);
							--- Bảng Account
CREATE TABLE Account (
	ID INT IDENTITY(1,1) PRIMARY KEY,
    IDNhanVien NVARCHAR(20) NOT NULL,
    Username NVARCHAR(50),
    Passwords NVARCHAR(50),
	CONSTRAINT FK_Account_NhanVien FOREIGN KEY (IDNhanVien)
    REFERENCES NhanVien(ID)
);

							--- Bảng lich su hoạt động
CREATE TABLE LichSuHoatDong (
  ID INT IDENTITY(1,1) NOT NULL,
  IDAccount INT NOT NULL,
  HoatDong NVARCHAR(200),
  Thoigian DATE,
  PRIMARY KEY (ID),
  CONSTRAINT FK_LichSuHoatDong_Account FOREIGN KEY (IDAccount)
	REFERENCES Account(ID)
);
							---Bảng lịch sử đăng nhập
CREATE TABLE LichSuDangNhap(
	ID INT IDENTITY(1,1) NOT NULL,
	IDAccount INT NOT NULL,
	TimeLogin DATE ,
	TimeLogout DATE,
	PRIMARY KEY (ID),
	CONSTRAINT FK_LichSuDangNhap_Account FOREIGN KEY (IDAccount)
	REFERENCES Account(ID)
);
							--- Bảng Khách Hàng
CREATE TABLE KhachHang(
	ID NVARCHAR(20) NOT NULL,
	TEN NVARCHAR(100),
	SDT NVARCHAR(12),
	Ngaytao DATE,
	LastActive DATE,
	IDNguoiTao INT  NOT NULL,
	PRIMARY KEY (ID),
	CONSTRAINT FK_KhachHang_Account FOREIGN KEY (IDNguoiTao)
	REFERENCES Account(ID)
);
							--- Bảng Nhà Cung Cấp
CREATE TABLE NhaCungCap(
	ID NVARCHAR(20) NOT NULL,
	Ten NVARCHAR(100),
	DiaChi NVARCHAR(200),
	GhiChu NVARCHAR(200),
	Email NVARCHAR(50),
	Ngaytao DATE,
	NgayKetThuc DATE
	PRIMARY KEY (ID),
);
							--- Bảng Nhập Hàng
CREATE TABLE NhapHang(
	ID NVARCHAR(20) NOT NULL,
	IDNhaCungCap NVARCHAR(20) NOT NULL,
	TongTien Decimal(15,2),
	NguoiGIaoHang NVARCHAR(50),
	GhiChu NVARCHAR(200),
	NgayTao DATE,
	IDNguoiNhan INT NOT NULL,
	PRIMARY KEY (ID),
	CONSTRAINT FK_NhapHang_NhaCungCap FOREIGN KEY (IDNhaCungCap)
	REFERENCES NhaCungCap(ID),
	CONSTRAINT FK_NhapHang_Account FOREIGN KEY (IDNguoiNhan)
	REFERENCES Account(ID)
);
							--- Bảng Loại sản phẩm
CREATE TABLE LoaiSP(
	ID NVARCHAR(20) NOT NULL,
	TEN NVARCHAR(100),
	NgayTao DATE,
	NgayKetThuc DATE,
	PRIMARY KEY (ID),
);
							--- Bảng Sản Phẩm
CREATE TABLE SanPham(
	ID NVARCHAR(20) NOT NULL,
	Ten NVARCHAR(100),
	Mota NVARCHAR(100),
	Donvitinh NVARCHAR(20),
	Dongia Decimal(15,2),
	Soluong INT,
	Ngaytao DATE,
	Ngayketthuc DATE,
	IDloai NVARCHAR(20) NOT NULL
	PRIMARY KEY (ID),
	CONSTRAINT FK_SanPham_LoaiSP FOREIGN KEY (IDloai)
	REFERENCES LoaiSP(ID)
);
							--- Bảng Hoá Đơn
CREATE TABLE HoaDon(
	ID NVARCHAR(20) NOT NULL,
	TongTien Decimal(15,2),
	Ngaytao DATE,
	IDNguoiTao INT NOT NULL,
	IDKhachHang NVARCHAR(20),
	PRIMARY KEY (ID),
	CONSTRAINT FK_HoaDon_Account FOREIGN KEY (IDNguoiTao)
	REFERENCES Account(ID),
	CONSTRAINT FK_HoaDon_KhachHang FOREIGN KEY (IDKhachHang)
	REFERENCES KhachHang(ID)
);
							--- Hoá Đơn chi tiết
CREATE TABLE HoaDonCT(
	IDHoaDon NVARCHAR(20) NOT NULL,
	IDSanPham NVARCHAR(20),
	Soluong INT,
	IDKhuyenMai NVARCHAR(20),
	PRIMARY KEY (IDHoaDon,IDSanPham),
	CONSTRAINT FK_HoaDonCT_HoaDon FOREIGN KEY (IDHoaDon)
	REFERENCES HoaDon(ID),
	CONSTRAINT FK_HoaDonCT_SanPham FOREIGN KEY (IDSanPham)
	REFERENCES SanPham(ID)
);
							--- Loại Nguyên Liệu
CREATE TABLE LoaiNguyenLieu(
	ID NVARCHAR(20) NOT NULL,
	TEN NVARCHAR(100),
	NgayTao DATE,
	NgayKetThuc DATE,
	PRIMARY KEY (ID),
);
							--- Nguyên Liệu
CREATE TABLE NguyenLieu(
	ID NVARCHAR(20) NOT NULL,
	TEN NVARCHAR(100),
	Dongia Decimal(15,2),
	NgayTao DATE,
	NgayKetThuc DATE,
	DVT NVARCHAR(20),
	IDLoai NVARCHAR(20) NOT NULL,
	PRIMARY KEY (ID),
	CONSTRAINT FK_NguyenLieu_LoaiNguyenLieu FOREIGN KEY (IDLoai)
	REFERENCES LoaiNguyenLieu(ID)
);
							--- Nhà cung cấp chi tiết
CREATE TABLE NhaCungCapCT(
	IDNhaCungCap NVARCHAR(20) NOT NULL,
	IDNguyenLieu NVARCHAR(20) NOT NULL,
	GhiChu NVARCHAR(200),
	Ngaytao DATE,
	PRIMARY KEY (IDNhaCungCap,IDNguyenLieu),
	CONSTRAINT FK_NhaCungCapCT_NhaCungCap FOREIGN KEY (IDNhaCungCap)
	REFERENCES NhaCungCap(ID),
	CONSTRAINT FK_NhaCungCapCT_NguyenLieu FOREIGN KEY (IDNguyenLieu)
	REFERENCES NguyenLieu(ID)
);
							--- Nhập hàng chi tiết
CREATE TABLE NhapHangCT(
	IDNhapHang NVARCHAR(20) NOT NULL,
	IDNguyenLieu NVARCHAR(20) NOT NULL,
	SoLuong Decimal(15,2),
	PRIMARY KEY (IDNhapHang,IDNguyenLieu),
	CONSTRAINT FK_NhapHangCT_NhapHang FOREIGN KEY (IDNhapHang)
	REFERENCES NhapHang(ID),
	CONSTRAINT FK_NhapHangCT_NguyenLieu FOREIGN KEY (IDNguyenLieu)
	REFERENCES NguyenLieu(ID)
);
							--- Công thức
CREATE TABLE CongThuc( 
	IDSanPham NVARCHAR(20) NOT NULL,
	IDNguyenLieu NVARCHAR(20) NOT NULL,
	SoLuong Decimal(15,2),
	PRIMARY KEY (IDSanPham,IDNguyenLieu),
	CONSTRAINT FK_CongThuc_SanPham FOREIGN KEY (IDSanPham)
	REFERENCES SanPham(ID),
	CONSTRAINT FK_CongThuc_NguyenLieu FOREIGN KEY (IDNguyenLieu)
	REFERENCES NguyenLieu(ID)
);

								--- đổ dữ liệu bảng Account ---

INSERT INTO  Account VALUES
('NV001',N'user','1234'),
('NV002',N'user','1234'),
('NV003',N'user','1234'),
('NV004',N'user','1234'),
('NV005',N'user','1234'),
('NV006',N'admin','1234');

select * from Account

								---- Dữ Liệu bảng loại sản phâm ---
INSERT INTO LoaiSP VALUES
('LSP001', 'Đồ Ăn', '2023-06-01', NULL),
('LSP002', 'Đồ uống', '2023-06-02', NULL),
('LSP003', 'Đồ Thêm', '2023-06-03', NULL),
('LSP004', 'Đồ Tráng Miệng', '2023-06-04', NULL);



								--- Dữ liệu bảng sản phẩm ---
INSERT INTO SanPham VALUES
('SP001', N'PIZZA', N'PIZZA Siêu Ngon', 'Phần', 100.00, 50, '2023-06-01', '2023-06-30', 'LSP001'),
('SP002', N'BEEFSTEAK', N'Bò kobe', 'Phần', 50.00, 100, '2023-06-02', '2023-06-29', 'LSP002'),
('SP003', N'Mì bò xào', N'Mì + 300g Bò', 'Phần', 200.00, 25, '2023-06-03', '2023-06-28', 'LSP001'),
('SP004', N'Mì xào hải sản', N'Mì + 300g hải sản', 'Phần', 500.00, 10, '2023-06-04', '2023-06-27', 'LSP001'),
('SP005', N'Bia Tiger Lon', N'Bia', 'Thùng', 150.00, 30, '2023-06-05', '2023-06-26', 'LSP002'),
('SP006', N'Cơm Niêu', N'Cơm niêu + cá kho ', 'Hộp', 75.00, 20, '2023-06-06', '2023-06-25', 'LSP001'),
('SP007', N'SALAD trộn', N'rau trộn', 'Cái', 180.00, 15, '2023-06-07', '2023-06-24', 'LSP003'),
('SP008', N'Rượu Vang', N'Rượu vang nhập khẩu chất lượng cao', 'Chai', 600.00, 5, '2023-06-08', '2023-06-23', 'LSP002'),
('SP009', N'Cơm Lam ống lứa', N'Cơm lam đến từ tây băc', 'Phần', 250.00, 12, '2023-06-09', '2023-06-22', 'LSP001'),
('SP010', N'Kem', N'Kem Vali siêu phẩm', 'Phần', 80.00, 8, '2023-06-10', '2023-06-21', 'LSP004');


										--- Bảng Nhân Viên
INSERT INTO NhanVien (ID, Ten, Ngaysinh, Gioitinh, Diachi, Sdt, Email, ChucVu, Luong, NgayTao, NgayKetThuc)
VALUES
('NV001', N'Lê Quang Thiên', '1990-01-01', N'Nam', N'Quận 1', '0123456789', 'nva@gmail.com', N'Nhân viên', 10000000.00, '2023-06-01', NULL),
('NV002', N'Huỳnh Hoàng Sang', '1992-02-02', N'Nam', N'Quận 2', '0123456788', 'ttb@gmail.com', N'Nhân viên', 9000000.00, '2023-06-02', NULL),
('NV003', N'Chiến Thuật', '1994-03-03', N'Nam', N'Quận 3', '0123456787', 'lvc@gmail.com', N'Nhân viên', 8000000.00, '2023-06-03', NULL),
('NV004', N'Huỳnh Thanh Thuận', '1996-04-04', N'Nữ', N'Quận 4', '0123456786', 'ptd@gmail.com', N'Nhân viên', 7000000.00, '2023-06-04', NULL),
('NV005', N'Đoàn Văn Hậu', '1998-05-05', N'Nam', N'Quận 6', '0123456785', 'hve@gmail.com', N'Nhân viên', 6000000.00, '2023-06-05', NULL),
('NV006', N'Nguyễn Lê Lợi', '2000-06-06', N'Nữ', N'Quận 7', '0123456784', 'ntf@gmail.com', N'Nhân viên', 5000000.00, '2023-06-06', NULL),
('NV007', N'Nguyễn Đức Thuận', '2002-07-07', N'Nam', N'Quận 5', '0123456783', 'tvg@gmail.com', N'Nhân viên', 4000000.00, '2023-06-07', NULL),
('NV008', N'Mai Thị Hằng', '2004-08-08', N'Nữ', N'Quân 8', '0123456782', 'lth@gmail.com', N'Nhân viên', 3000000.00, '2023-06-08', NULL),
('NV009', N'Trần Bá Hợp', '2006-09-09', N'Nam', N'Quận  9', '0123456781', 'pvi@gmail.com', N'Nhân viên', 2000000.00, '2023-06-09', NULL),
('NV010', N'Nguyễn Xuân Sanh', '2008-10-10', N'Nữ', N'Quận 10', '0123456780', 'htk@gmail.com', N'Nhân viên', 1000000.00, '2023-06-10', NULL);			s				
select * from NhanVien