package page;

import constant.LoginSignupPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

public class LoginSignupPage extends BasePage<LoginSignupPage> {

    @FindBy(xpath = LoginSignupPageConstants.LOGIN_EMAIL_FIELD_LOCATOR)
    WebElement loginEmailField;

    @FindBy(xpath = LoginSignupPageConstants.LOGIN_PASSWORD_FIELD_LOCATOR)
    WebElement loginPasswordField;

    @FindBy(xpath = LoginSignupPageConstants.LOGIN_BUTTON_LOCATOR)
    WebElement loginButton;

    @FindBy(xpath = LoginSignupPageConstants.NEW_USER_SIGNUP_TITLE_LOCATOR)
    WebElement newUserSignUpTitle;

    @FindBy(xpath = LoginSignupPageConstants.SIGNUP_NAME_FIELD_LOCATOR)
    WebElement signUpNameField;

    @FindBy(xpath = LoginSignupPageConstants.SIGNUP_EMAIL_FIELD_LOCATOR)
    WebElement signUpEmailField;

    @FindBy(xpath = LoginSignupPageConstants.SIGNUP_BUTTON_LOCATOR)
    WebElement signupButton;

    LoginSignupPage() {
        super(DriverFactory.getDriver());
    }

    public void fillLoginEmailField(final String email) {
        fillTheField(loginEmailField, email);
    }

    public void fillLoginPasswordField(final String password) {
        fillTheField(loginPasswordField, password);
    }

    public void fillNameField(final String name) {
        fillTheField(signUpNameField, name);
    }

    public void fillEmailField(final String email) {
        fillTheField(signUpEmailField, email);
    }

    public LoggedInHomePage clickLoginButton() {
        clickButton(loginButton);
        return new LoggedInHomePage();
    }

    public SignupPage clickSignupButton() {
        clickButton(signupButton);
        return new SignupPage();
    }

    public WebElement getNewUserSignUpTitle() {
        return waitForElementToBeDisplayed(newUserSignUpTitle);
    }
}
