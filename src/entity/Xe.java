package entity;

/**
 * Project Ecobike System
 * User: Nhom 11
 * Create at 9:49 AM , 12/16/2020
 */

public class Xe {

}
/**
use [CapstoneProject];

INSERT INTO Xe
 (id, loaiXe, bienSoXe, idBaiXe, tienCoc, trangThai)
 VALUES
 (001,N'Xe ??p',002121,001,100000,1),
 (002,N'Xe ??p',123003,002,150000,0),
 (005,N'Xe ??p',123456,001,200000,0),
(009,N'Xe ??p',113456,002,250000,1),
(007,N'Xe ??p',155456,001,170000,0),
(011,N'Xe ??p',123156,003,210000,0);

INSERT INTO XeDapDien
 (id,pin,loaiXe, bienSoXe, idBaiXe, tienCoc, trangThai)
 VALUES
 (001,100,N'Xe ??p ?i?n',000001,001,500000,1),
 (002,50,N'Xe ??p ?i?n',121001,002,450000,0),
 (005,90,N'Xe ??p ?i?n',123346,001,600000,0),
(009,80,N'Xe ??p ?i?n',109856,002,430000,1),
(007,75,N'Xe ??p ?i?n',112456,001,630000,0),
(011,86,N'Xe ??p ?i?n',112246,003,450000,0);

INSERT INTO BaiXe
 (id,tenBaiXe,diaChi,dienTich)
 VALUES
 (001,N'Eco Bách Khoa',N'1 Hai Bà Tr?ng Hà N?i',300),
 (002,N'Eco Meo',N'1 Hoàng Thái Hà N?i',300),
 (003,N'Eco Thai',N'12 Thái Th?nh Hà N?i',300)
 ;

 INSERT INTO GiaoDichThueXe
 (id,idXe,idNguoiDung,idBaiXeThue,idBaiXeTra,thoiDiemThue,thoiDiemTra,tongThoiGianDung,idTheGiaoDich,cachThue)
 VALUES
 (002,003,001,001,003,'20201120 09:15:20','20201120 15:5:20',15,'118131_group11_2020',1),
 (003,009,001,001,002,'20201130 13:32:20','20201130 17:15:20',15,'118131_group11_2020',1);

 INSERT INTO GiaoDichThueXe
 (id,idXe,idNguoiDung,idBaiXeThue,thoiDiemThue,tongThoiGianDung,idTheGiaoDich,cachThue)
 VALUES
 (001,001,001,001,'20201020 12:32:10',15,'118131_group11_2020',1);
*/