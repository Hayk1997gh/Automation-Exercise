package setup;

import java.io.File;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.Helper;

public class DriverFactory {
    private static WebDriver driver;
    private static final ChromeOptions options = new ChromeOptions();

    private DriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            options.addExtensions(new File("src/main/java/extension/ad_blocker.crx"));
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            Helper.closeCurrentTabAndSwitchToMain();
        }
        return driver;
    }
}
