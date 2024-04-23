package page;

import constant.AccountBasePageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

public abstract class AccountBasePage extends BasePage<AccountCreatedPage> {

    @FindBy(xpath = AccountBasePageConstants.CONTINUE_BUTTON_LOCATOR)
    WebElement continueButton;

    AccountBasePage() {
        super(DriverFactory.getDriver());
    }

    public LoggedInHomePage clickContinueButton() {
        clickButton(continueButton);
        return new LoggedInHomePage();
    }
}
