package page;

import java.util.ArrayList;
import java.util.List;

import constant.CheckoutPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

public class CheckoutPage extends BasePage<CheckoutPage> {

    @FindBy(xpath = CheckoutPageConstants.DELIVERY_ADDRESS_ITEMS_LOCATOR)
    List<WebElement> deliveryAddressItems;

    @FindBy(xpath = CheckoutPageConstants.BILLING_ADDRESS_ITEMS_LOCATOR)
    List<WebElement> billingAddressItems;

    @FindBy(xpath = CheckoutPageConstants.REVIEW_YOUR_ORDER_DESCRIPTIONS_LOCATOR)
    List<WebElement> reviewYourOrderDescriptions;

    @FindBy(xpath = CheckoutPageConstants.REVIEW_YOUR_ORDER_PRICES_LOCATOR)
    List<WebElement> reviewYourOrderPrices;

    @FindBy(xpath = CheckoutPageConstants.COMMENT_FIELD_LOCATOR)
    WebElement commentField;

    @FindBy(xpath = CheckoutPageConstants.PLACE_ORDER_BUTTON)
    WebElement placeOrderButton;

    CheckoutPage() {
        super(DriverFactory.getDriver());
    }

    public List<String> getDeliveryAddressItems() {
        List<String> deliveryAddressItemsTexts = new ArrayList<>();
        for (WebElement deliveryItemAddress : deliveryAddressItems) {
            deliveryAddressItemsTexts.add(deliveryItemAddress.getText());
        }
        return deliveryAddressItemsTexts;
    }

    public List<String> getBillingAddressItems() {
        List<String> billingAddressItemsTexts = new ArrayList<>();
        for (WebElement billingItemAddress : billingAddressItems) {
            billingAddressItemsTexts.add(billingItemAddress.getText());
        }
        return billingAddressItemsTexts;
    }

    //    Could be mapped as one 'Review Your Order' table class
    public List<String> getReviewYourOrderDescriptions() {
        List<String> reviewYourOrderDescriptionsTexts = new ArrayList<>();
        for (WebElement reviewYourOrderDescription : reviewYourOrderDescriptions) {
            reviewYourOrderDescriptionsTexts.add(reviewYourOrderDescription.getText());
        }
        return reviewYourOrderDescriptionsTexts;
    }

    //    Could be mapped as one 'Review Your Order' table class
    public List<String> getReviewYourOrderPrices() {
        List<String> reviewYourOrderPricesTexts = new ArrayList<>();
        for (WebElement reviewYourOrderPrice : reviewYourOrderPrices) {
            reviewYourOrderPricesTexts.add(reviewYourOrderPrice.getText());
        }
        return reviewYourOrderPricesTexts;
    }

    public void fillCommentField(final String comment) {
        fillTheField(commentField, comment);
    }

    public PaymentPage clickPlaceOrderButton() {
        clickButton(placeOrderButton);
        return new PaymentPage();
    }
}
