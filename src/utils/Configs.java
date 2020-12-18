package utils;

import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

public class Configs {

	// api constants
	public static final String GET_BALANCE_URL = "https://ecopark-system-api.herokuapp.com/api/card/balance/118609_group1_2020";
	public static final String GET_VEHICLECODE_URL = "https://ecopark-system-api.herokuapp.com/api/get-vehicle-code/1rjdfasdfas";
	public static final String PROCESS_TRANSACTION_URL = "https://ecopark-system-api.herokuapp.com/api/card/processTransaction";
	public static final String RESET_URL = "https://ecopark-system-api.herokuapp.com/api/card/reset";

	// demo data
	public static final String GROUP_NAME = "118131_group11_2020";
	public static final String OWNER = "Group 11";
	public static final String CVV_CODE = "505";
	public static final String DATE_EXPIRED = "1125";
	public static final String POST_DATA = "{"
			+ " \"secretKey\": \"BAVDCDK5Pew=\" ,"
			+ " \"transaction\": {"
			+ " \"command\": \"pay\" ,"
			+ " \"cardCode\": \"118131_group11_2020\" ,"
			+ " \"owner\": \"Group 11\" ,"
			+ " \"cvvCode\": \"505\" ,"
			+ " \"dateExpried\": \"1125\" ,"
			+ " \"transactionContent\": \"Pei debt\" ,"
			+ " \"amount\": 50000 "
			+ "}"
			+ "}";
	public static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiIxMTg2MDlfZ3JvdXAxXzIwMjAiLCJpYXQiOjE1OTkxMTk5NDl9.y81pBkM0pVn31YDPFwMGXXkQRKW5RaPIJ5WW5r9OW-Y";

	// database Configs
	public static final String DB_NAME = "capstone_project";
	public static final String DB_USERNAME = "root";
	public static final String DB_PASSWORD = "1234";

	public static String CURRENCY = "VND";
	public static float PERCENT_VAT = 10;

	// static resource
	public static final String IMAGE_PATH = "assets/images/";
	public static final String HOME_PATH  = "/views/fxml/home.fxml";
	public static final String SPLASH_SCREEN_PATH = "/views/fxml/splash.fxml";
	public static final String MENU_PATH  = "/views/fxml/menu.fxml";
	public static final String MAVACH_PATH  = "/views/fxml/nhapMaVach.fxml";
<<<<<<< HEAD
	public static final String THUEXE_THONGTINXE_PATH  = "/views/fxml/thueXeThongTinXe.fxml";
=======
	public static final String THONG_TIN_XE_PATH  = "/views/fxml/thongTinChiTietXe.fxml";
>>>>>>> main
	public static final String TRAXE_THONGTINXE_PATH  = "/views/fxml/traxeThongTinXe.fxml";
	public static final String BAIXE_Brief_PATH  = "/views/fxml/baiXeBrief.fxml";
	public static final String THONGTIN_BAIXE_PATH  = "/views/fxml/thongTinBaiXe.fxml";
	public static final String THUEXE_CHONTHE_PATH  = "/views/fxml/chonTheThanhToan.fxml";
	public static final String THUEXE_XACNHAN_PATH  = "/views/fxml/xacNhanThanhToan.fxml";
	public static final String XE_THEO_LOAI_PATH = "/views/fxml/xeTheoLoai.fxml";
	public static final String XE_BRIEF_PATH = "/views/fxml/xeBrief.fxml";

	public static Font REGULAR_FONT = Font.font("Segoe UI", FontWeight.NORMAL, FontPosture.REGULAR, 24);

	public static String[] PROVINCES = { "Bắc Giang", "Bắc Kạn", "Cao Bằng", "Hà Giang", "Lạng Sơn", "Phú Thọ",
			"Quảng Ninh", "Thái Nguyên", "Tuyên Quang", "Yên Bái", "Điện Biên", "Hòa Bình", "Lai Châu", "Sơn La",
			"Bắc Ninh", "Hà Nam", "Hải Dương", "Hưng Yên", "Nam Định", "Ninh Bình", "Thái Bình", "Vĩnh Phúc", "Hà Nội",
			"Hải Phòng", "Hà Tĩnh", "Nghệ An", "Quảng Bình", "Quảng Trị", "Thanh Hóa", "Thừa Thiên-Huế", "Đắk Lắk",
			"Đắk Nông", "Gia Lai", "Kon Tum", "Lâm Đồng", "Bình Định", "Bình Thuận", "Khánh Hòa", "Ninh Thuận",
			"Phú Yên", "Quảng Nam", "Quảng Ngãi", "Đà Nẵng", "Bà Rịa-Vũng Tàu", "Bình Dương", "Bình Phước", "Đồng Nai",
			"Tây Ninh", "Hồ Chí Minh", "An Giang", "Bạc Liêu", "Bến Tre", "Cà Mau", "Đồng Tháp", "Hậu Giang",
			"Kiên Giang", "Long An", "Sóc Trăng", "Tiền Giang", "Trà Vinh", "Vĩnh Long", "Cần Thơ" };
}
