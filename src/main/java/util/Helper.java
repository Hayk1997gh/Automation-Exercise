package util;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.DriverFactory;

public class Helper {

    public static void scrollToElement(final WebElement element) {
        new Actions(DriverFactory.getDriver())
                .scrollToElement(element)
                .perform();
    }

    public static void closeCurrentTabAndSwitchToMain() {
        WebDriver driver = DriverFactory.getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(0));
    }
}
