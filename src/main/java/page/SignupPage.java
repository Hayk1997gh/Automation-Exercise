package page;

import constant.SignupPageConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import setup.DriverFactory;

public class SignupPage extends BasePage<SignupPage> {

    @FindBy(xpath = SignupPageConstants.ENTER_ACCOUNT_INFORMATION_TITLE_LOCATOR)
    WebElement enterAccountInfoTitle;

    @FindBy(xpath = SignupPageConstants.MALE_RADIO_BUTTON_LOCATOR)
    WebElement maleRadioButton;

    @FindBy(xpath = SignupPageConstants.FEMALE_RADIO_BUTTON_LOCATOR)
    WebElement femaleRadioButton;

    @FindBy(xpath = SignupPageConstants.PASSWORD_FIELD_LOCATOR)
    WebElement passwordField;

    @FindBy(xpath = SignupPageConstants.DAYS_DROPDOWN_LOCATOR)
    WebElement daysDropdown;

    @FindBy(xpath = SignupPageConstants.MONTHS_DROPDOWN_LOCATOR)
    WebElement monthsDropdown;

    @FindBy(xpath = SignupPageConstants.YEARS_DROPDOWN_LOCATOR)
    WebElement yearsDropdown;

    @FindBy(xpath = SignupPageConstants.NEWSLETTER_CHECKBOX_LOCATOR)
    WebElement newsletterCheckbox;

    @FindBy(xpath = SignupPageConstants.SPECIAL_OFFERS_CHECKBOX_LOCATOR)
    WebElement specialOffersCheckbox;

    @FindBy(xpath = SignupPageConstants.FIRST_NAME_FIELD_LOCATOR)
    WebElement firstNameField;

    @FindBy(xpath = SignupPageConstants.LAST_NAME_FIELD_LOCATOR)
    WebElement lastNameField;

    @FindBy(xpath = SignupPageConstants.COMPANY_FIELD_LOCATOR)
    WebElement companyField;

    @FindBy(xpath = SignupPageConstants.ADDRESS_FIELD_LOCATOR)
    WebElement addressField;

    @FindBy(xpath = SignupPageConstants.SECOND_ADDRESS_FIELD_LOCATOR)
    WebElement secondAddressField;

    @FindBy(xpath = SignupPageConstants.COUNTRY_DROPDOWN_LOCATOR)
    WebElement countryDropdown;

    @FindBy(xpath = SignupPageConstants.STATE_FIELD_LOCATOR)
    WebElement stateField;

    @FindBy(xpath = SignupPageConstants.CITY_FIELD_LOCATOR)
    WebElement cityField;

    @FindBy(xpath = SignupPageConstants.ZIP_CODE_FIELD_LOCATOR)
    WebElement zipCodeField;

    @FindBy(xpath = SignupPageConstants.MOBILE_NUMBER_FIELD_LOCATOR)
    WebElement mobileNumberField;

    @FindBy(xpath = SignupPageConstants.CREATE_ACCOUNT_BUTTON_LOCATOR)
    WebElement createAccountButton;

    SignupPage() {
        super(DriverFactory.getDriver());
    }

    public WebElement getEnterAccountInfoTitle() {
        return waitForElementToBeDisplayed(enterAccountInfoTitle);
    }

    private void selectGender(final String gender) {
        switch (gender.toLowerCase()) {
            case "male" -> clickButton(maleRadioButton);
            case "female" -> clickButton(femaleRadioButton);
            default -> throw new RuntimeException("Please provide valid gender!");
        }
    }

    private void fillPasswordField(final String password) {
        fillTheField(passwordField, password);
    }

    private void selectDay(final int day) {
        Select select = new Select(daysDropdown);
        select.selectByValue(String.valueOf(day));
    }

    private void selectMonth(final int month) {
        Select select = new Select(monthsDropdown);
        select.selectByValue(String.valueOf(month));
    }

    private void selectYear(final int year) {
        Select select = new Select(yearsDropdown);
        select.selectByValue(String.valueOf(year));
    }

    private void selectNewsletterCheckbox() {
        clickButton(newsletterCheckbox);
    }

    private void selectSpecialOffersCheckbox() {
        clickButton(specialOffersCheckbox);
    }

    private void fillFirstNameField(final String firstName) {
        fillTheField(firstNameField, firstName);
    }

    private void fillLastNameField(final String lastName) {
        fillTheField(lastNameField, lastName);
    }

    private void fillCompanyField(final String company) {
        fillTheField(companyField, company);
    }

    private void fillAddressField(final String address) {
        fillTheField(addressField, address);
    }

    private void fillSecondAddressField(final String secondAddress) {
        fillTheField(secondAddressField, secondAddress);
    }

    private void selectCountry(final String country) {
        Select select = new Select(countryDropdown);
        select.selectByVisibleText(country);
    }

    private void fillStateField(final String state) {
        fillTheField(stateField, state);
    }

    private void fillCityField(final String city) {
        fillTheField(cityField, city);
    }

    private void fillZipCodeField(final String zipCode) {
        fillTheField(zipCodeField, zipCode);
    }

    private void fillMobileNumberField(final String mobileNumber) {
        fillTheField(mobileNumberField, mobileNumber);
    }

    public AccountCreatedPage clickCreateAccountButton() {
        clickButton(createAccountButton);
        return new AccountCreatedPage();
    }

    public void fillAccountInformation(
            final String gender,
            final String password,
            final int day,
            final int month,
            final int year
    ) {
        selectGender(gender);
        fillPasswordField(password);
        selectDay(day);
        selectMonth(month);
        selectYear(year);
        selectNewsletterCheckbox();
        selectSpecialOffersCheckbox();
    }

    public void fillAddressInformation(final String firstName,
                                       final String lastName,
                                       final String company,
                                       final String address,
                                       final String secondAddress,
                                       final String country,
                                       final String state,
                                       final String city,
                                       final String zipCode,
                                       final String mobileNumber) {
        fillFirstNameField(firstName);
        fillLastNameField(lastName);
        fillCompanyField(company);
        fillAddressField(address);
        fillSecondAddressField(secondAddress);
        selectCountry(country);
        fillStateField(state);
        fillCityField(city);
        fillZipCodeField(zipCode);
        fillMobileNumberField(mobileNumber);
    }
}
