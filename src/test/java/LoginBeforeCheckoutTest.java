import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.AccountCreatedPage;
import page.AccountDeletedPage;
import page.CartPage;
import page.CheckoutPage;
import page.LoggedInHomePage;
import page.LoggedOutHomePage;
import page.LoginSignupPage;
import page.PaymentPage;
import page.SignupPage;
import setup.BaseTest;

public class LoginBeforeCheckoutTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    LoggedOutHomePage loggedOutHomePage;
    LoggedInHomePage loggedInHomePage;
    LoginSignupPage loginSignUpPage;
    SignupPage signupPage;
    AccountCreatedPage accountCreatedPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PaymentPage paymentPage;
    AccountDeletedPage accountDeletedPage;

    List<String> expectedAddress = List.of(
            "Mr. Tester Automation",
            "ABC Corporation",
            "123 Main Street",
            "Apartment 456",
            "Los Angeles California 90001",
            "United States",
            "+1 555-123-4567"
    );

    @BeforeClass(description = "Register User")
    public void registerUser() {
        loggedOutHomePage = new LoggedOutHomePage().open(LoggedOutHomePage.class);

        loginSignUpPage = loggedOutHomePage.getHeader().clickLoginSignUpButton();

        loginSignUpPage.fillNameField("Tester");
        loginSignUpPage.fillEmailField("Tester@yopmail.com");

        signupPage = loginSignUpPage.clickSignupButton();

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

        loggedInHomePage = accountCreatedPage.clickContinueButton();

        loggedInHomePage.getHeader().clickLogoutButton();
    }


    @Test(description = "Test Case 16: Place Order: Login before Checkout")
    public void registerUserTest() {
        loginSignUpPage = loggedOutHomePage.getHeader().clickLoginSignUpButton();

        loginSignUpPage.fillLoginEmailField("Tester@yopmail.com");
        loginSignUpPage.fillLoginPasswordField("Tester123");

        loggedInHomePage = loginSignUpPage.clickLoginButton();

        softAssert.assertEquals(
                loggedInHomePage.getHeader().getLoggedInAsTitle().getText(),
                "Logged in as Tester",
                String.format(
                        "Element text is %s instead of %s",
                        loggedInHomePage.getHeader().getLoggedInAsTitle().getText(),
                        "Logged in as Tester"
                )
        );

        List<String> itemsPrices = loggedInHomePage.getFeaturedItemsPrices(3);
        List<String> itemsDescriptions = loggedInHomePage.getFeaturedItemsDescriptions(3);

        loggedInHomePage.clickFeaturedItemsAddToCardButtons(3);

        cartPage = loggedInHomePage.getHeader().clickCartButton();

        Assert.assertTrue(cartPage.getCurrentUrl().endsWith("/view_cart"));

        checkoutPage = cartPage.clickProceedToCheckoutButton();

        List<String> actualDeliveryAddress = checkoutPage.getDeliveryAddressItems();
        List<String> actualBillingAddress = checkoutPage.getBillingAddressItems();

        softAssert.assertEquals(actualDeliveryAddress, expectedAddress);
        softAssert.assertEquals(actualBillingAddress, expectedAddress);

        softAssert.assertEquals(itemsDescriptions, checkoutPage.getReviewYourOrderDescriptions());
        softAssert.assertEquals(itemsPrices, checkoutPage.getReviewYourOrderPrices());

        checkoutPage.fillCommentField("Adding products");

        paymentPage = checkoutPage.clickPlaceOrderButton();

        paymentPage.enterPaymentDetails("John Doe", "4242 4242 4242 4242", "123", "08", "2025");

        paymentPage.clickPayAndConfirmOrderButtonButton();

        softAssert.assertEquals(
                paymentPage.getCongratsDesc().getText(),
                "Congratulations! Your order has been confirmed!",
                String.format(
                        "Element text is %s instead of %s",
                        paymentPage.getCongratsDesc().getText(),
                        "Congratulations! Your order has been confirmed!"
                )
        );

        accountDeletedPage = paymentPage.getHeader().clickDeleteAccountButton();

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
