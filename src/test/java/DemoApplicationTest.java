import com.geofence.DemoApplication;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DemoApplicationTest {

    @Test
    public void test_VIN_Number() {
        assertTrue(given("04327964552"));
    }

    @Test
    public void test_Empty_VIN_Number() {
        assertFalse(given(""));
    }

    @Test
    public void test__invalid_Valid_VIN_Number() {
        assertFalse(given("1234567892"));
    }

    @Test
    public void test_in_Valid_VIN_Number() {
        assertTrue(given("0471958692"));
    }

    @Test
    public void test_Valid_VIN_Number_1() {
        assertTrue(given("0471606958"));
    }

    private Boolean given(String s) {
        DemoApplication demoApplication = new DemoApplication();

        return demoApplication.validateVINNumber(s);
    }

}
