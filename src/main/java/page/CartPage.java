package page;

import constant.CartPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

public class CartPage extends BasePage<CartPage> {

    @FindBy(xpath = CartPageConstants.PROCEED_TO_CHECKOUT_BUTTON_LOCATOR)
    WebElement proceedToCheckoutButton;

    CartPage() {
        super(DriverFactory.getDriver());
    }

    public CheckoutPage clickProceedToCheckoutButton() {
        clickButton(proceedToCheckoutButton);
        return new CheckoutPage();
    }
}
