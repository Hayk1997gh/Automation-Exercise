package page;

import static setup.DriverFactory.getDriver;

import constant.LoggedOutHomePageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedOutHomePage extends BasePage<LoggedOutHomePage> {

    @FindBy(xpath = LoggedOutHomePageConstants.AUTOMATION_EXERCISE_DESC_TITLE_LOCATOR)
    WebElement automationExerciseDescription;

    private final Header header;
    private final Footer footer;

    public LoggedOutHomePage() {
        super(getDriver());
        header = new Header(getDriver());
        footer = new Footer(getDriver());
    }

    public WebElement getAutomationExerciseDescription() {
        return waitForElementToBeDisplayed(automationExerciseDescription);
    }

    public Header getHeader() {
        return this.header;
    }

    public Footer getFooter() {
        return this.footer;
    }
}
