import controller.PlaceOrderController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValidateAddressTest {
    private PlaceOrderController placeOrderController;

    @BeforeEach
    void setUp() throws Exception {
        this.placeOrderController = new PlaceOrderController();
    }

    @Test
    public void test() {
//		fail("Not yet implemented");
        boolean isValid = placeOrderController.validateAddress("so 1 nha a");
        assertEquals(true, isValid);
    }

}


