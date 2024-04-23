package setup;

import static setup.DriverFactory.getDriver;

import org.testng.annotations.AfterClass;

public class BaseTest {
    @AfterClass
    public static void tearDown() {
        getDriver().quit();
    }
}
