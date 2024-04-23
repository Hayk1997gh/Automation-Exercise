package page;

import constant.PaymentPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

public class PaymentPage extends BasePage<PaymentPage> {

    @FindBy(xpath = PaymentPageConstants.NAME_ON_CARD_FIELD_LOCATOR)
    WebElement nameOnCardField;

    @FindBy(xpath = PaymentPageConstants.CARD_NUMBER_FIELD_LOCATOR)
    WebElement cardNumberField;

    @FindBy(xpath = PaymentPageConstants.CVC_FIELD_LOCATOR)
    WebElement cvcField;

    @FindBy(xpath = PaymentPageConstants.EXPIRATION_MONTH_FIELD_LOCATOR)
    WebElement expirationMonthField;

    @FindBy(xpath = PaymentPageConstants.EXPIRATION_YEAR_FIELD_LOCATOR)
    WebElement expirationYearField;

    @FindBy(xpath = PaymentPageConstants.PAY_AND_CONFIRM_ORDER_BUTTON_LOCATOR)
    WebElement payAndConfirmOrderButton;

    @FindBy(xpath = PaymentPageConstants.CONGRATULATIONS_DESC_LOCATOR)
    WebElement congratsDesc;

    private final Header header;

    PaymentPage() {
        super(DriverFactory.getDriver());
        header = new Header(DriverFactory.getDriver());
    }

    public Header getHeader() {
        return header;
    }

    public void enterPaymentDetails(
            final String nameOnCard,
            final String cardNumber,
            final String cvc,
            final String expirationMonth,
            final String expirationYear
    ) {
        fillTheField(nameOnCardField, nameOnCard);
        fillTheField(cardNumberField, cardNumber);
        fillTheField(cvcField, cvc);
        fillTheField(expirationMonthField, expirationMonth);
        fillTheField(expirationYearField, expirationYear);
    }

    public void clickPayAndConfirmOrderButtonButton() {
        clickButton(payAndConfirmOrderButton);
    }

    public WebElement getCongratsDesc() {
        return waitForElementToBeDisplayed(congratsDesc);
    }
}
