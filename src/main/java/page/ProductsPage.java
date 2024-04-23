package page;

import java.util.List;

import constant.ProductsPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

public class ProductsPage extends BasePage<ProductsPage> {

    @FindBy(xpath = ProductsPageConstants.SEARCH_PRODUCT_FIELD_LOCATOR)
    WebElement searchProductField;

    @FindBy(xpath = ProductsPageConstants.SEARCH_BUTTON_LOCATOR)
    WebElement searchButton;

    @FindBy(xpath = ProductsPageConstants.SEARCHED_PRODUCTS_TITLE_LOCATOR)
    WebElement searchedProductsTitle;

    @FindBy(xpath = ProductsPageConstants.SEARCHED_PRODUCTS_TITLES_LOCATOR)
    List<WebElement> searchedProducts;

    ProductsPage() {
        super(DriverFactory.getDriver());
    }

    public void fillSearchProductField(String product) {
        fillTheField(searchProductField, product);
    }

    public void clickSearchButton() {
        clickButton(searchButton);
    }

    public WebElement getSearchedProductsTitle() {
        return waitForElementToBeDisplayed(searchedProductsTitle);
    }

    public List<WebElement> getSearchedProducts() {
        return searchedProducts;
    }
}
