package page;

import constant.HeaderConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BasePage<Header> {

    @FindBy(xpath = HeaderConstants.LOGIN_SIGNUP_BUTTON_LOCATOR)
    WebElement loginSignUpButton;

    @FindBy(xpath = HeaderConstants.LOGOUT_BUTTON_LOCATOR)
    WebElement logoutButton;

    @FindBy(xpath = HeaderConstants.DELETE_ACCOUNT_BUTTON_LOCATOR)
    WebElement deleteAccountButton;

    @FindBy(xpath = HeaderConstants.PRODUCTS_BUTTON_LOCATOR)
    WebElement productsButton;

    @FindBy(xpath = HeaderConstants.CART_BUTTON_LOCATOR)
    WebElement cartButton;

    @FindBy(xpath = HeaderConstants.LOGGED_IN_AS_TITLE_LOCATOR)
    WebElement loggedInAsTitle;

    Header(final WebDriver driver) {
        super(driver);
    }

    public LoginSignupPage clickLoginSignUpButton() {
        clickButton(loginSignUpButton);
        return new LoginSignupPage();
    }

    @SuppressWarnings("UnusedReturnValue")
    public LoginSignupPage clickLogoutButton() {
        clickButton(logoutButton);
        return new LoginSignupPage();
    }

    public ProductsPage clickProductsButton() {
        clickButton(productsButton);
        return new ProductsPage();
    }

    public CartPage clickCartButton() {
        clickButton(cartButton);
        return new CartPage();
    }

    public AccountDeletedPage clickDeleteAccountButton() {
        clickButton(deleteAccountButton);
        return new AccountDeletedPage();
    }

    public WebElement getLoggedInAsTitle() {
        return waitForElementToBeDisplayed(loggedInAsTitle);
    }
}
