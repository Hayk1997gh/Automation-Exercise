package page;

import constant.FooterConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Footer extends BasePage<Footer> {

    @FindBy(xpath = FooterConstants.FOOTER_LOCATOR)
    WebElement footer;

    @FindBy(xpath = FooterConstants.SUBSCRIPTION_TITLE_LOCATOR)
    WebElement subscriptionTitle;

    @FindBy(xpath = FooterConstants.SCROLL_UP_ICON_LOCATOR)
    WebElement scrollUpIcon;

    Footer(final WebDriver driver) {
        super(driver);
    }

    public WebElement getFooterElement() {
        return footer;
    }

    public void clickScrollUpIcon() {
        clickButton(scrollUpIcon);
    }

    public WebElement getSubscriptionTitle() {
        return waitForElementToBeDisplayed(subscriptionTitle);
    }
}
