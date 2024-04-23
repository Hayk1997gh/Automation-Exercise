package constant;

public class CheckoutPageConstants {
    public static final String DELIVERY_ADDRESS_ITEMS_LOCATOR = "//ul[@id='address_delivery']/li[position() > 1]";
    public static final String BILLING_ADDRESS_ITEMS_LOCATOR = "//ul[@id='address_invoice']/li[position() > 1]";
    public static final String REVIEW_YOUR_ORDER_DESCRIPTIONS_LOCATOR = "//td[@class='cart_description']/h4";
    public static final String REVIEW_YOUR_ORDER_PRICES_LOCATOR = "//td[@class='cart_price']";
    public static final String COMMENT_FIELD_LOCATOR = "//div[@id='ordermsg']/textarea";
    public static final String PLACE_ORDER_BUTTON = "//a[@href='/payment']";
}
