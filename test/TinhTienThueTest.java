
import controller.DieuKhienTraXe;
import entity.LoaiXe;
import entity.Xe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TinhTienThueTest {
    private DieuKhienTraXe dieuKhienTraXe;
    @BeforeEach
    void setUp() throws Exception {
        dieuKhienTraXe = new DieuKhienTraXe();
    }
    @ParameterizedTest
    @CsvSource({
            "2020-12-15 12:12:00,2020-12-15 12:22:00,15000", //<30
            "2020-12-15 12:12:00,2020-12-15 12:42:00,15000", //=30
            "2020-12-15 12:12:00,2020-12-15 12:50:00,19500", // 30 < && < 45
            "2020-12-15 12:00:00,2020-12-15 13:00:00,28500"  //=60
    })

    public void test(String arg1,String arg2, int expected) {
        LoaiXe loaiXe = new LoaiXe();
        loaiXe.setGia30pDau(15000);
        loaiXe.setGiaMoi15p(4500);
        Xe xe = new Xe();
        xe.setLoaiXe(loaiXe);
        int isValid = dieuKhienTraXe.tinhTienThue(arg1,arg2,xe);
        assertEquals(expected, isValid);
    }

}
