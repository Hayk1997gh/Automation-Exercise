package page;

import constant.AccountCreatedPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatedPage extends AccountBasePage {

    @FindBy(xpath = AccountCreatedPageConstants.ACCOUNT_CREATED_TITLE_LOCATOR)
    WebElement accountCreatedTitle;

    public WebElement getAccountCreatedTitle() {
        return waitForElementToBeDisplayed(accountCreatedTitle);
    }
}
