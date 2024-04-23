package page;

import constant.AccountDeletedPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDeletedPage extends AccountBasePage {

    @FindBy(xpath = AccountDeletedPageConstants.ACCOUNT_DELETED_TITLE_LOCATOR)
    WebElement accountDeletedTitle;

    public WebElement getAccountDeletedTitle() {
        return waitForElementToBeDisplayed(accountDeletedTitle);
    }
}
