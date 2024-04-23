import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.AccountCreatedPage;
import page.AccountDeletedPage;
import page.LoggedInHomePage;
import page.LoggedOutHomePage;
import page.LoginSignupPage;
import page.SignupPage;
import setup.BaseTest;

public class RegisterUserTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    LoggedOutHomePage loggedOutHomePage;
    LoggedInHomePage loggedInHomePage;
    LoginSignupPage loginSignUpPage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    AccountDeletedPage accountDeletedPage;

    @Test(description = "Test Case 1: Register User")
    public void registerUserTest() {
        loggedOutHomePage = new LoggedOutHomePage().open(LoggedOutHomePage.class);

        loginSignUpPage = loggedOutHomePage.getHeader().clickLoginSignUpButton();

        softAssert.assertEquals(
                loginSignUpPage.getNewUserSignUpTitle().getText(),
                "New User Signup!",
                String.format(
                        "Element text is %s instead of %s",
                        loginSignUpPage.getNewUserSignUpTitle().getText(),
                        "New User Signup!"
                )
        );

        loginSignUpPage.fillNameField("Tester");
        loginSignUpPage.fillEmailField("Tester@yopmail.com");

        signupPage = loginSignUpPage.clickSignupButton();

        softAssert.assertEquals(
                signupPage.getEnterAccountInfoTitle().getText(),
                "ENTER ACCOUNT INFORMATION",
                String.format(
                        "Element text is %s instead of %s",
                        signupPage.getEnterAccountInfoTitle().getText(),
                        "ENTER ACCOUNT INFORMATION"
                )
        );

        signupPage.fillAccountInformation("male", "Tester123", 14, 8, 1997);

        signupPage.fillAddressInformation(
                "Tester",
                "Automation",
                "ABC Corporation",
                "123 Main Street",
                "Apartment 456",
                "United States",
                "California",
                "Los Angeles",
                "90001",
                "+1 555-123-4567"
        );

        accountCreatedPage = signupPage.clickCreateAccountButton();

        softAssert.assertEquals(
                accountCreatedPage.getAccountCreatedTitle().getText(),
                "ACCOUNT CREATED!",
                String.format(
                        "Element text is %s instead of %s",
                        accountCreatedPage.getAccountCreatedTitle().getText(),
                        "ACCOUNT CREATED!"
                )
        );

        loggedInHomePage = accountCreatedPage.clickContinueButton();

        softAssert.assertEquals(
                loggedInHomePage.getHeader().getLoggedInAsTitle().getText(),
                "Logged in as Tester",
                String.format(
                        "Element text is %s instead of %s",
                        loggedInHomePage.getHeader().getLoggedInAsTitle().getText(),
                        "Logged in as Tester"
                )
        );

        accountDeletedPage = loggedInHomePage.getHeader().clickDeleteAccountButton();

        softAssert.assertEquals(
                accountDeletedPage.getAccountDeletedTitle().getText(),
                "ACCOUNT DELETED!",
                String.format(
                        "Element text is %s instead of %s",
                        accountDeletedPage.getAccountDeletedTitle().getText(),
                        "ACCOUNT DELETED!"
                )
        );

        accountDeletedPage.clickContinueButton();

        softAssert.assertAll();
    }
}
