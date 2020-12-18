use [CapstoneProject];

INSERT INTO bai_xe
 (id_bai_xe,ten_bai_xe,dia_chi,dien_tich)
 VALUES
 (001,N'Eco Bách Khoa',N'1 Hai Bà Trưng Hà Nội',300),
 (002,N'Eco Meo',N'1 Hoàng Thái Hà Nội',300),
 (003,N'Eco Thai',N'12 Thái Thịnh Hà Nội',300)
 ;

INSERT INTO xe
 (id_xe, pin, loai_xe, bien_so_xe, id_bai_xe, tien_coc, trang_thai)
 VALUES
 (001,null,N'Xe đạp thường','000001',001,500000,1),
 (002,50,N'Xe đạp điện','121001',002,450000,0),
 (005,90,N'Xe đạp điện','123346',001,600000,0),
(009,null,N'Xe đạp thường','109856',002,430000,1),
(007,75,N'Xe đạp điện','112456',001,630000,0),
(011,86,N'Xe đạp điện','112246',003,450000,0);

--INSERT INTO xe_dap_dien
-- (id,pin,loaiXe, bienSoXe, id_bai_xe, tienCoc, trangThai)
-- VALUES
-- (001,null,N'Xe đạp điện',000001,001,500000,1),
-- (002,50,N'Xe đạp điện',121001,002,450000,0),
-- (005,90,N'Xe đạp điện',123346,001,600000,0),
--(009,80,N'Xe đạp điện',109856,002,430000,1),
--(007,75,N'Xe đạp điện',112456,001,630000,0),
--(011,86,N'Xe đạp điện',112246,003,450000,0);


--
 INSERT INTO giao_dich_thue_xe
 (id_giao_dich_thue_xe,id_xe,id_nguoi_dung,so_tien,id_bai_xe_thue,id_bai_xe_tra,thoi_diem_thue,thoi_diem_tra,id_the_giao_dich,
 cach_thue)
 VALUES
 (002,002,001,10000,001,003,'2020-11-20 09:15:20','2020-11-20 15:5:20','118131_group11_2020',1),
 (003,009,002,20000,001,002,'2020-11-30 13:32:20','2020-11-30 17:15:20','118131_group11_2020',1);
--
-- INSERT INTO GiaoDichThueXe
-- (id,idXe,idNguoiDung,idBaiXeThue,thoiDiemThue,tongThoiGianDung,idTheGiaoDich,cachThue)
-- VALUES
-- (001,001,001,001,'20201020 12:32:10',15,'118131_group11_2020',1);