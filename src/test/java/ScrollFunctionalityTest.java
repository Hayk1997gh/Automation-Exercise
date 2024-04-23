import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LoggedOutHomePage;
import setup.BaseTest;
import util.Helper;

public class ScrollFunctionalityTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    LoggedOutHomePage loggedOutHomePage;

    @Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void searchProductTest() {
        loggedOutHomePage = new LoggedOutHomePage().open(LoggedOutHomePage.class);

        Helper.scrollToElement(loggedOutHomePage.getFooter().getFooterElement());

        softAssert.assertEquals(
                loggedOutHomePage.getFooter().getSubscriptionTitle().getText(),
                "SUBSCRIPTION",
                String.format(
                        "Element text is %s instead of %s",
                        loggedOutHomePage.getFooter().getSubscriptionTitle().getText(),
                        "SUBSCRIPTION"
                )
        );

        loggedOutHomePage.getFooter().clickScrollUpIcon();

        softAssert.assertEquals(
                loggedOutHomePage.getAutomationExerciseDescription().getText(),
                "Full-Fledged practice website for Automation Engineers",
                String.format(
                        "Element text is %s instead of %s",
                        loggedOutHomePage.getAutomationExerciseDescription().getText(),
                        "Full-Fledged practice website for Automation Engineers"
                )
        );
        softAssert.assertAll();
    }
}
