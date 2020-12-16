import controller.PlaceOrderController;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateNameTest {
    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception {
        this.placeOrderController = new PlaceOrderController();
    }

    @Test
    public void test() {
//		fail("Not yet implemented");
        boolean isValid = placeOrderController.validateName("jhas");
        assertEquals(true, isValid);
    }

}
