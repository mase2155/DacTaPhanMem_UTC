/*
    BanHangNoiThat — ban hang do noi that
    Server: localhost (instance mac dinh MSSQLSERVER)
    Nghiep vu chinh: tinh tien hoa don theo 3 chien luoc
        NIEM_YET        ty le giam = 0
        GIAM_PHAN_TRAM  ty le giam = 10
        KHACH_VIP       ty le giam lay dung TheVip.TyLeGiam cua khach
    Nghiep vu phu: the VIP (moi khach toi da mot the)

    Quan he
        1 - nhieu / nhieu - 1 (khoa ngoai o bang con, khong phai khoa chinh)
            DanhMuc    1 —— n SanPham          SanPham.DanhMucID
            NhaCungCap 1 —— n SanPham          SanPham.NhaCungCapID
            KhachHang  1 —— n HoaDon           HoaDon.KhachHangID
            NhanVien   1 —— n HoaDon           HoaDon.NhanVienID
            HoaDon     1 —— n ChiTietHoaDon    ChiTietHoaDon.HoaDonID
            SanPham    1 —— n ChiTietHoaDon    ChiTietHoaDon.SanPhamID
        1 - 1 (khoa ngoai DONG THOI la khoa chinh cua bang phu)
            KhachHang  1 —— 1 TheVip           TheVip.KhachHangID
            HoaDon     1 —— 1 KetQuaTinhTien   KetQuaTinhTien.HoaDonID

    Kiem tra ket qua form: SELECT * FROM dbo.vw_KiemTraTinhTien
    KHOP + DUNG = form ghi dung tien va dung chien luoc.
*/
USE master;
GO

IF DB_ID(N'BanHangNoiThat') IS NOT NULL
BEGIN
    ALTER DATABASE BanHangNoiThat SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
    DROP DATABASE BanHangNoiThat;
END
GO

CREATE DATABASE BanHangNoiThat;
GO

USE BanHangNoiThat;
GO

/* ---------- Danh muc: phia 1 cua SanPham ---------- */
CREATE TABLE dbo.DanhMuc (
    DanhMucID   INT            IDENTITY(1, 1) NOT NULL,
    TenDanhMuc  NVARCHAR(100)  NOT NULL,
    MoTa        NVARCHAR(255)  NULL,
    CONSTRAINT PK_DanhMuc PRIMARY KEY (DanhMucID),
    CONSTRAINT UQ_DanhMuc_Ten UNIQUE (TenDanhMuc)
);
GO

/* ---------- Nha cung cap: phia 1 cua SanPham ---------- */
CREATE TABLE dbo.NhaCungCap (
    NhaCungCapID    INT            IDENTITY(1, 1) NOT NULL,
    MaNCC           VARCHAR(20)    NOT NULL,
    TenNhaCungCap   NVARCHAR(150)  NOT NULL,
    SoDienThoai     VARCHAR(15)    NOT NULL,
    DiaChi          NVARCHAR(255)  NULL,
    Email           VARCHAR(100)   NULL,
    CONSTRAINT PK_NhaCungCap PRIMARY KEY (NhaCungCapID),
    CONSTRAINT UQ_NhaCungCap_Ma UNIQUE (MaNCC)
);
GO

/* ---------- San pham: nhieu - 1 toi DanhMuc va NhaCungCap ---------- */
CREATE TABLE dbo.SanPham (
    SanPhamID       INT            IDENTITY(1, 1) NOT NULL,
    MaSP            VARCHAR(20)    NOT NULL,
    TenSanPham      NVARCHAR(150)  NOT NULL,
    DanhMucID       INT            NOT NULL,
    NhaCungCapID    INT            NOT NULL,
    ChatLieu        NVARCHAR(50)   NOT NULL,
    KichThuoc       NVARCHAR(50)   NULL,
    MauSac          NVARCHAR(30)   NOT NULL,
    DonGia          DECIMAL(18, 0) NOT NULL,
    SoLuongTon      INT            NOT NULL,
    NgayNhap        DATE           NOT NULL,
    DuongDanAnh     NVARCHAR(255)  NULL,
    CONSTRAINT PK_SanPham PRIMARY KEY (SanPhamID),
    CONSTRAINT UQ_SanPham_Ma UNIQUE (MaSP),
    CONSTRAINT FK_SanPham_DanhMuc FOREIGN KEY (DanhMucID)
        REFERENCES dbo.DanhMuc (DanhMucID),
    CONSTRAINT FK_SanPham_NhaCungCap FOREIGN KEY (NhaCungCapID)
        REFERENCES dbo.NhaCungCap (NhaCungCapID),
    CONSTRAINT CK_SanPham_DonGia CHECK (DonGia > 0),
    CONSTRAINT CK_SanPham_Ton CHECK (SoLuongTon >= 0),
    CONSTRAINT CK_SanPham_NgayNhap CHECK (NgayNhap <= CAST(GETDATE() AS DATE))
);
GO

/* ---------- Khach hang: phia 1 cua HoaDon, va phia 1 cua TheVip ---------- */
CREATE TABLE dbo.KhachHang (
    KhachHangID  INT            IDENTITY(1, 1) NOT NULL,
    HoTen        NVARCHAR(100)  NOT NULL,
    SoDienThoai  VARCHAR(15)    NOT NULL,
    DiaChi       NVARCHAR(255)  NULL,
    Email        VARCHAR(100)   NULL,
    CONSTRAINT PK_KhachHang PRIMARY KEY (KhachHangID),
    CONSTRAINT UQ_KhachHang_SDT UNIQUE (SoDienThoai)
);
GO

/*
    TheVip: quan he 1 - 1 voi KhachHang.
    KhachHangID vua la khoa chinh vua la khoa ngoai.
    Mot khach toi da mot the. Mot the dung mot khach.
    TyLeGiam la nguon so cho chien luoc KHACH_VIP.
*/
CREATE TABLE dbo.TheVip (
    KhachHangID  INT            NOT NULL,
    MaThe        VARCHAR(20)    NOT NULL,
    HangThe      NVARCHAR(20)   NOT NULL,
    TyLeGiam     DECIMAL(5, 2)  NOT NULL,
    NgayCap      DATE           NOT NULL,
    NgayHetHan   DATE           NOT NULL,
    CONSTRAINT PK_TheVip PRIMARY KEY (KhachHangID),
    CONSTRAINT UQ_TheVip_MaThe UNIQUE (MaThe),
    CONSTRAINT FK_TheVip_KhachHang FOREIGN KEY (KhachHangID)
        REFERENCES dbo.KhachHang (KhachHangID),
    CONSTRAINT CK_TheVip_Hang CHECK (HangThe IN (N'BAC', N'VANG', N'KIMCUONG')),
    CONSTRAINT CK_TheVip_TyLe CHECK (TyLeGiam > 0 AND TyLeGiam <= 50),
    CONSTRAINT CK_TheVip_Ngay CHECK (NgayHetHan > NgayCap)
);
GO

/* ---------- Nhan vien: phia 1 cua HoaDon ---------- */
CREATE TABLE dbo.NhanVien (
    NhanVienID   INT            IDENTITY(1, 1) NOT NULL,
    MaNV         VARCHAR(20)    NOT NULL,
    HoTen        NVARCHAR(100)  NOT NULL,
    SoDienThoai  VARCHAR(15)    NOT NULL,
    ChucVu       NVARCHAR(50)   NOT NULL,
    CONSTRAINT PK_NhanVien PRIMARY KEY (NhanVienID),
    CONSTRAINT UQ_NhanVien_Ma UNIQUE (MaNV)
);
GO

/*
    HoaDon: nhieu - 1 toi KhachHang va NhanVien.
    ChienLuocTinhTien + TyLeGiamApDung la nghiep vu tinh tien.
    Moi dong ChiTietHoaDon phai dung cung ty le nay.
*/
CREATE TABLE dbo.HoaDon (
    HoaDonID            INT            IDENTITY(1, 1) NOT NULL,
    SoHoaDon            VARCHAR(20)    NOT NULL,
    KhachHangID         INT            NOT NULL,
    NhanVienID          INT            NOT NULL,
    NgayBan             DATE           NOT NULL,
    HinhThucThanhToan   NVARCHAR(30)   NOT NULL,
    ChienLuocTinhTien   VARCHAR(30)    NOT NULL,
    TyLeGiamApDung      DECIMAL(5, 2)  NOT NULL,
    GhiChu              NVARCHAR(255)  NULL,
    CONSTRAINT PK_HoaDon PRIMARY KEY (HoaDonID),
    CONSTRAINT UQ_HoaDon_So UNIQUE (SoHoaDon),
    CONSTRAINT FK_HoaDon_KhachHang FOREIGN KEY (KhachHangID)
        REFERENCES dbo.KhachHang (KhachHangID),
    CONSTRAINT FK_HoaDon_NhanVien FOREIGN KEY (NhanVienID)
        REFERENCES dbo.NhanVien (NhanVienID),
    CONSTRAINT CK_HoaDon_Ngay CHECK (NgayBan <= CAST(GETDATE() AS DATE)),
    CONSTRAINT CK_HoaDon_ThanhToan CHECK (
        HinhThucThanhToan IN (N'TIEN_MAT', N'CHUYEN_KHOAN', N'THE')
    ),
    CONSTRAINT CK_HoaDon_ChienLuoc CHECK (
        (ChienLuocTinhTien = 'NIEM_YET' AND TyLeGiamApDung = 0)
        OR (ChienLuocTinhTien = 'GIAM_PHAN_TRAM' AND TyLeGiamApDung = 10)
        OR (ChienLuocTinhTien = 'KHACH_VIP' AND TyLeGiamApDung > 0)
    )
);
GO

/*
    ChiTietHoaDon: nhieu - 1 toi HoaDon va nhieu - 1 toi SanPham.
    HoaDon 1 - n ChiTiet. SanPham 1 - n ChiTiet.
    Unique (HoaDonID, SanPhamID): mot san pham chi mot dong tren mot hoa don.
    ThanhTien = DonGia * SoLuong * (100 - TyLeGiam) / 100.
*/
CREATE TABLE dbo.ChiTietHoaDon (
    ChiTietID   INT            IDENTITY(1, 1) NOT NULL,
    HoaDonID    INT            NOT NULL,
    SanPhamID   INT            NOT NULL,
    SoLuong     INT            NOT NULL,
    DonGia      DECIMAL(18, 0) NOT NULL,
    TyLeGiam    DECIMAL(5, 2)  NOT NULL,
    ThanhTien   DECIMAL(18, 0) NOT NULL,
    CONSTRAINT PK_ChiTietHoaDon PRIMARY KEY (ChiTietID),
    CONSTRAINT UQ_ChiTiet_HoaDon_SanPham UNIQUE (HoaDonID, SanPhamID),
    CONSTRAINT FK_ChiTiet_HoaDon FOREIGN KEY (HoaDonID)
        REFERENCES dbo.HoaDon (HoaDonID) ON DELETE CASCADE,
    CONSTRAINT FK_ChiTiet_SanPham FOREIGN KEY (SanPhamID)
        REFERENCES dbo.SanPham (SanPhamID),
    CONSTRAINT CK_ChiTiet_SoLuong CHECK (SoLuong > 0),
    CONSTRAINT CK_ChiTiet_DonGia CHECK (DonGia > 0),
    CONSTRAINT CK_ChiTiet_TyLe CHECK (TyLeGiam >= 0 AND TyLeGiam <= 50),
    CONSTRAINT CK_ChiTiet_ThanhTien CHECK (
        ThanhTien = ROUND(DonGia * SoLuong * (100 - TyLeGiam) / 100, 0)
    )
);
GO

/*
    KetQuaTinhTien: quan he 1 - 1 voi HoaDon.
    HoaDonID vua la khoa chinh vua la khoa ngoai.
    Day la bang de doi chieu ket qua form nhap hoa don.
*/
CREATE TABLE dbo.KetQuaTinhTien (
    HoaDonID          INT            NOT NULL,
    TongTienHang      DECIMAL(18, 0) NOT NULL,
    TongTienGiam      DECIMAL(18, 0) NOT NULL,
    ThanhTien         DECIMAL(18, 0) NOT NULL,
    SoTienKhachDua    DECIMAL(18, 0) NOT NULL,
    TienThua          DECIMAL(18, 0) NOT NULL,
    CONSTRAINT PK_KetQuaTinhTien PRIMARY KEY (HoaDonID),
    CONSTRAINT FK_KetQuaTinhTien_HoaDon FOREIGN KEY (HoaDonID)
        REFERENCES dbo.HoaDon (HoaDonID) ON DELETE CASCADE,
    CONSTRAINT CK_KetQua_Tong CHECK (TongTienHang >= 0),
    CONSTRAINT CK_KetQua_Giam CHECK (TongTienGiam >= 0 AND TongTienGiam <= TongTienHang),
    CONSTRAINT CK_KetQua_Thanh CHECK (ThanhTien = TongTienHang - TongTienGiam),
    CONSTRAINT CK_KetQua_KhachDua CHECK (SoTienKhachDua >= ThanhTien),
    CONSTRAINT CK_KetQua_Thua CHECK (TienThua = SoTienKhachDua - ThanhTien)
);
GO

/* ---------- 5 ban ghi moi bang. Khoa ngoai tro toi ban ghi da co. ---------- */

INSERT INTO dbo.DanhMuc (TenDanhMuc, MoTa) VALUES
    (N'Sofa',            N'Ghế sofa phòng khách'),
    (N'Bàn ghế',         N'Bàn ăn và ghế ăn'),
    (N'Giường',          N'Giường ngủ'),
    (N'Tủ',              N'Tủ quần áo, tủ bếp'),
    (N'Đèn trang trí',   N'Đèn đứng, đèn thả');
GO

INSERT INTO dbo.NhaCungCap (MaNCC, TenNhaCungCap, SoDienThoai, DiaChi, Email) VALUES
    ('NCC-HP', N'Nội thất Hòa Phát',  '02431001001', N'Hà Nội',     'hop@hoaphat.vn'),
    ('NCC-DT', N'Gỗ Đức Thành',       '02831001002', N'Bình Dương', 'sales@ducthanh.vn'),
    ('NCC-MA', N'Sofa Minh Anh',      '02431001003', N'Hà Nội',     'cskh@minhanh.vn'),
    ('NCC-IT', N'Da thật Italia',     '02831001004', N'TP HCM',     NULL),
    ('NCC-PC', N'Đèn Phong Cách',     '02363100105', N'Đà Nẵng',    'hello@phongcach.vn');
GO

INSERT INTO dbo.SanPham
    (MaSP, TenSanPham, DanhMucID, NhaCungCapID, ChatLieu, KichThuoc, MauSac, DonGia, SoLuongTon, NgayNhap, DuongDanAnh)
VALUES
    ('SF-001', N'Sofa da 3 chỗ',      1, 3, N'Da thật',         N'220x90x85 cm',   N'Nâu',      15000000, 8,  '20261001', NULL),
    ('SF-002', N'Sofa vải góc chữ L', 1, 3, N'Vải',             N'260x160x85 cm',  N'Xám',      12000000, 5,  '20261005', NULL),
    ('BA-001', N'Bàn ăn gỗ sồi 6 ghế', 2, 2, N'Gỗ sồi',          N'180x90x75 cm',   N'Nâu nhạt',  8500000, 6,  '20261008', NULL),
    ('GI-001', N'Giường ngủ 1m8',      3, 2, N'Gỗ óc chó',       N'200x180x110 cm', N'Nâu đậm',  18000000, 4,  '20261012', NULL),
    ('TU-001', N'Tủ áo 4 cánh',        4, 1, N'Gỗ công nghiệp',  N'180x200x60 cm',  N'Trắng',     7200000, 10, '20261015', NULL);
GO

INSERT INTO dbo.KhachHang (HoTen, SoDienThoai, DiaChi, Email) VALUES
    (N'Nguyễn Văn An',  '0903123456', N'Cầu Giấy, Hà Nội',    'an.nguyen@mail.com'),
    (N'Trần Thị Bình',  '0918234567', N'Lê Chân, Hải Phòng',  'binh.tran@mail.com'),
    (N'Lê Văn Cường',   '0988123456', N'Hải Châu, Đà Nẵng',   NULL),
    (N'Phạm Thị Dung',  '0977123456', N'Phú Nhuận, TP HCM',   'dung.pham@mail.com'),
    (N'Hoàng Văn Em',   '0966123456', N'Thủ Đức, TP HCM',     'em.hoang@mail.com');
GO

INSERT INTO dbo.TheVip (KhachHangID, MaThe, HangThe, TyLeGiam, NgayCap, NgayHetHan) VALUES
    (1, 'VIP-AN-BAC',    N'BAC',      5.00,  '20260115', '20270115'),
    (2, 'VIP-BINH-VANG', N'VANG',     10.00, '20260201', '20270201'),
    (3, 'VIP-CUONG-KC',  N'KIMCUONG', 15.00, '20260310', '20270310'),
    (4, 'VIP-DUNG-BAC',  N'BAC',      5.00,  '20260401', '20270401'),
    (5, 'VIP-EM-VANG',   N'VANG',     10.00, '20260520', '20270520');
GO

INSERT INTO dbo.NhanVien (MaNV, HoTen, SoDienThoai, ChucVu) VALUES
    ('NV001', N'Nguyễn Thị Lan', '0901111001', N'Bán hàng'),
    ('NV002', N'Trần Văn Khoa',  '0901111002', N'Bán hàng'),
    ('NV003', N'Lê Thị Mai',     '0901111003', N'Thu ngân'),
    ('NV004', N'Phạm Văn Nam',   '0901111004', N'Quản lý'),
    ('NV005', N'Đỗ Thị Hà',      '0901111005', N'Bán hàng');
GO

INSERT INTO dbo.HoaDon
    (SoHoaDon, KhachHangID, NhanVienID, NgayBan, HinhThucThanhToan, ChienLuocTinhTien, TyLeGiamApDung, GhiChu)
VALUES
    ('HD001', 1, 1, '20261102', N'TIEN_MAT',      'NIEM_YET',       0,  NULL),
    ('HD002', 2, 2, '20261105', N'CHUYEN_KHOAN',  'GIAM_PHAN_TRAM', 10, N'Giảm 10 phần trăm theo chương trình'),
    ('HD003', 3, 1, '20261110', N'THE',           'KHACH_VIP',      15, N'Khách kim cương, giảm đúng 15% trên thẻ'),
    ('HD004', 1, 3, '20261115', N'TIEN_MAT',      'GIAM_PHAN_TRAM', 10, NULL),
    ('HD005', 5, 2, '20261118', N'CHUYEN_KHOAN',  'KHACH_VIP',      10, N'Khách vàng, giảm đúng 10% trên thẻ');
GO

INSERT INTO dbo.ChiTietHoaDon (HoaDonID, SanPhamID, SoLuong, DonGia, TyLeGiam, ThanhTien) VALUES
    (1, 3, 1,  8500000,  0,  8500000),
    (2, 4, 1, 18000000, 10, 16200000),
    (3, 5, 2,  7200000, 15, 12240000),
    (4, 2, 1, 12000000, 10, 10800000),
    (5, 1, 1, 15000000, 10, 13500000);
GO

INSERT INTO dbo.KetQuaTinhTien
    (HoaDonID, TongTienHang, TongTienGiam, ThanhTien, SoTienKhachDua, TienThua)
VALUES
    (1,  8500000,       0,  8500000,  9000000, 500000),
    (2, 18000000, 1800000, 16200000, 16200000,      0),
    (3, 14400000, 2160000, 12240000, 13000000, 760000),
    (4, 12000000, 1200000, 10800000, 11000000, 200000),
    (5, 15000000, 1500000, 13500000, 14000000, 500000);
GO

/*
    Doi chieu form.
    KetQuaKiemTra = KHOP khi tong tien hang, tien giam, thanh tien, tien thua
    khop voi tong tinh lai tu ChiTietHoaDon, va moi dong dung ty le cua hoa don.
    KiemTraChienLuoc = DUNG khi ty le khop loai chien luoc
    (KHACH_VIP phai trung TyLeGiam cua TheVip).
*/
CREATE VIEW dbo.vw_KiemTraTinhTien
AS
SELECT
    h.SoHoaDon,
    kh.HoTen AS KhachHang,
    h.ChienLuocTinhTien,
    h.TyLeGiamApDung,
    tv.TyLeGiam AS TyLeGiamTrenThe,
    k.TongTienHang AS TongTienHang_Luu,
    ct.TongTienHang_TinhLai,
    k.TongTienGiam AS TongTienGiam_Luu,
    ct.TongTienGiam_TinhLai,
    k.ThanhTien AS ThanhTien_Luu,
    ct.ThanhTien_TinhLai,
    k.SoTienKhachDua,
    k.TienThua,
    CASE
        WHEN k.TongTienHang = ct.TongTienHang_TinhLai
         AND k.TongTienGiam = ct.TongTienGiam_TinhLai
         AND k.ThanhTien = ct.ThanhTien_TinhLai
         AND ct.SoDongLechTyLe = 0
        THEN N'KHOP'
        ELSE N'LECH'
    END AS KetQuaKiemTra,
    CASE
        WHEN h.ChienLuocTinhTien = 'NIEM_YET' AND h.TyLeGiamApDung = 0 THEN N'DUNG'
        WHEN h.ChienLuocTinhTien = 'GIAM_PHAN_TRAM' AND h.TyLeGiamApDung = 10 THEN N'DUNG'
        WHEN h.ChienLuocTinhTien = 'KHACH_VIP'
         AND tv.TyLeGiam IS NOT NULL
         AND h.TyLeGiamApDung = tv.TyLeGiam THEN N'DUNG'
        ELSE N'SAI'
    END AS KiemTraChienLuoc
FROM dbo.HoaDon AS h
INNER JOIN dbo.KhachHang AS kh
    ON kh.KhachHangID = h.KhachHangID
INNER JOIN dbo.KetQuaTinhTien AS k
    ON k.HoaDonID = h.HoaDonID
LEFT JOIN dbo.TheVip AS tv
    ON tv.KhachHangID = h.KhachHangID
INNER JOIN (
    SELECT
        c.HoaDonID,
        SUM(c.DonGia * c.SoLuong) AS TongTienHang_TinhLai,
        SUM(c.DonGia * c.SoLuong - c.ThanhTien) AS TongTienGiam_TinhLai,
        SUM(c.ThanhTien) AS ThanhTien_TinhLai,
        SUM(CASE WHEN c.TyLeGiam <> hd.TyLeGiamApDung THEN 1 ELSE 0 END) AS SoDongLechTyLe
    FROM dbo.ChiTietHoaDon AS c
    INNER JOIN dbo.HoaDon AS hd
        ON hd.HoaDonID = c.HoaDonID
    GROUP BY c.HoaDonID
) AS ct
    ON ct.HoaDonID = h.HoaDonID;
GO
