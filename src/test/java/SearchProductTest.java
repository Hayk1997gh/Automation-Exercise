import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.LoggedOutHomePage;
import page.ProductsPage;
import setup.BaseTest;

public class SearchProductTest extends BaseTest {

    SoftAssert softAssert = new SoftAssert();
    LoggedOutHomePage loggedOutHomePage;
    ProductsPage productsPage;

    @Test(description = "Test Case 9: Search Product")
    public void searchProductTest() {
        loggedOutHomePage = new LoggedOutHomePage().open(LoggedOutHomePage.class);

        productsPage = loggedOutHomePage.getHeader().clickProductsButton();

        Assert.assertTrue(productsPage.getCurrentUrl().endsWith("/products"));

        productsPage.fillSearchProductField("shirt");
        productsPage.clickSearchButton();

        softAssert.assertEquals(
                productsPage.getSearchedProductsTitle().getText(),
                "SEARCHED PRODUCTS",
                String.format(
                        "Element text is %s instead of %s",
                        productsPage.getSearchedProductsTitle().getText(),
                        "SEARCHED PRODUCTS"
                )
        );

        softAssert.assertFalse(
                productsPage.getSearchedProducts().isEmpty(),
                "Nothing was found when searching for shirt product"
        );

        softAssert.assertAll();
    }
}
