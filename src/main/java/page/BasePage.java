package page;

import static setup.DriverFactory.getDriver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage<T extends LoadableComponent<T>> extends LoadableComponent<T> {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private static final String BASE_URL = "https://automationexercise.com/";

    BasePage(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        PageFactory.initElements(driver, this);
    }

    public T open(final Class<T> clazz) {
        T page = PageFactory.initElements(getDriver(), clazz);
        return page.get();
    }

    void fillTheField(final WebElement element,
                      final String text) {
        waitForElementToBeDisplayed(element).sendKeys(text);
    }

    void clickButton(final WebElement element) {
        waitForElementToBeDisplayed(element).click();
    }

    public WebElement waitForElementToBeDisplayed(final WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getCurrentUrl().contains(BASE_URL));
    }

    @Override
    protected void load() {
        getDriver().get(BASE_URL);
    }
}
