package page;

import java.util.ArrayList;
import java.util.List;

import constant.LoggedInHomePageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.DriverFactory;

public class LoggedInHomePage extends BasePage<LoggedInHomePage> {

    @FindBy(xpath = LoggedInHomePageConstants.FEATURED_ITEMS_PRICES_LOCATOR)
    List<WebElement> featuredItemsPrices;

    @FindBy(xpath = LoggedInHomePageConstants.FEATURED_ITEMS_DESCRIPTIONS_LOCATOR)
    List<WebElement> featuredItemsDescriptions;

    @FindBy(xpath = LoggedInHomePageConstants.FEATURED_ITEMS_ADD_TO_CARD_BUTTONS_LOCATOR)
    List<WebElement> featuredItemsAddToCardButtons;

    @FindBy(xpath = LoggedInHomePageConstants.CONTINUE_SHOPPING_BUTTON_LOCATOR)
    WebElement continueShoppingButton;

    private final Header header;

    LoggedInHomePage() {
        super(DriverFactory.getDriver());
        header = new Header(DriverFactory.getDriver());
    }

    public Header getHeader() {
        return header;
    }

    //    Items 'prices', 'descriptions' and 'Add to card' buttons could be mapped as one unit in 'Item' class
    public List<String> getFeaturedItemsPrices(int itemsCount) {
        itemsCount = Math.min(itemsCount, featuredItemsAddToCardButtons.size());
        List<String> itemsPrices = new ArrayList<>();
        for (int i = 0; i < itemsCount; i++) {
            itemsPrices.add(featuredItemsPrices.get(i).getText());
        }
        return itemsPrices;
    }

    //    Items 'prices', 'descriptions' and 'Add to card' buttons could be mapped as one unit in 'Item' class
    public List<String> getFeaturedItemsDescriptions(int itemsCount) {
        List<String> itemsDescriptions = new ArrayList<>();
        for (int i = 0; i < itemsCount; i++) {
            itemsDescriptions.add(featuredItemsDescriptions.get(i).getText());
        }
        return itemsDescriptions;
    }

    void clickContinueShoppingButton() {
        clickButton(continueShoppingButton);
    }

    //    Items 'prices', 'descriptions' and 'Add to card' buttons could be mapped as one unit in 'Item' class
    public void clickFeaturedItemsAddToCardButtons(int itemsCount) {
        itemsCount = Math.min(itemsCount, featuredItemsAddToCardButtons.size());
        for (int i = 0; i < itemsCount; i++) {
            clickButton(featuredItemsAddToCardButtons.get(i));
            clickContinueShoppingButton();
        }
    }
}
