package pages;

import base.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddToCartProductPage extends BasePage {
    @FindBy(id = "input-quantity")
    @CacheLookup
    private WebElement inputQuantityChange;

    @FindBy(id = "button-cart")
    @CacheLookup
    protected WebElement addToCartButton;

    @FindBy(id = "cart-total")
    @CacheLookup
    private WebElement cartTotalButton;

    @FindBy(xpath = "//*[@class='text-right']//a[2]")
    @CacheLookup
    private WebElement checkoutButtonDropDownMenu;

    @FindBy(xpath = "//*[@value='guest']")
    @CacheLookup
    private WebElement radioButtonGuestCheckout;

    @FindBy(id = "button-account")
    @CacheLookup
    private WebElement continueButtonNewCustomerOrder;

    @FindBy(id = "input-payment-firstname")
    @CacheLookup
    private WebElement writeIntoFirstNameInputField;

    @FindBy(id = "input-payment-lastname")
    @CacheLookup
    private WebElement writeIntoLastNameInputField;

    @FindBy(id = "input-payment-email")
    @CacheLookup
    private WebElement writeIntoEmailInputField;

    @FindBy(id = "input-payment-telephone")
    @CacheLookup
    private WebElement writeIntoTelephoneInputField;

    @FindBy(id = "input-payment-address-1")
    @CacheLookup
    private WebElement writeIntoAddress1InputField;

    @FindBy(id = "input-payment-city")
    @CacheLookup
    private WebElement writeIntoCityInputField;

    @FindBy(id = "input-payment-postcode")
    @CacheLookup
    private WebElement writeIntoPostCodeInputField;

    @FindBy(id = "input-payment-country")
    @CacheLookup
    private WebElement selectDropDownMenuCountry;

    @FindBy(id = "input-payment-zone")
    @CacheLookup
    private WebElement selectDropDownMenuRegionAndState;

    @FindBy(id = "button-guest")
    @CacheLookup
    private WebElement continueButtonBillingDetails;

    @FindBy(id = "button-shipping-method")
    @CacheLookup
    private WebElement continueButtonDeliveryMethod;

    @FindBy(xpath = "//*[@name='agree']")
    @CacheLookup
    private WebElement agreeWithTermsAndConditionsButton;

    @FindBy(id = "button-payment-method")
    @CacheLookup
    private WebElement continueButtonPaymentMethod;

    @FindBy(id = "button-confirm")
    @CacheLookup
    private WebElement confirmOrderButton;

    @FindBy(xpath = "//*[@id='common-success']/div/div[1]/h1")
    @CacheLookup
    private WebElement acceptMessageForOrder;

    public AddToCartProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void changeQuantityOfTheProduct(String quantity) {
        typeInWebElement(inputQuantityChange, quantity);
    }
    public void clickAddToCartButton() {
        clickOnWebElement(addToCartButton);
    }

    public void clickCartTotalButton() {
        clickOnWebElement(cartTotalButton);
    }

    public void clickCheckoutButtonDropDownMenu() {
        clickOnWebElement(checkoutButtonDropDownMenu);
    }

    public void clickRadioButtonGuestCheckout() {
        clickOnWebElement(radioButtonGuestCheckout);
    }

    public void clickContinueButtonNewCustomerOrder() {
        clickOnWebElement(continueButtonNewCustomerOrder);
    }

    public void typeIntoFirstNameInputField(String firstName) {
        typeInWebElement(writeIntoFirstNameInputField, firstName);
    }

    public void typeIntoLastNameInputField(String lastName) {
        typeInWebElement(writeIntoLastNameInputField, lastName);
    }

    public void randomEmail() {
        String prefix = RandomStringUtils.randomAlphanumeric(6);
        String postfix = RandomStringUtils.randomAlphabetic(3);
        String randomEmail = prefix + "@" + postfix + ".com";
        typeInWebElement(writeIntoEmailInputField, randomEmail);
    }

    public void typeIntoTelephoneInputField(String telephone) {
        typeInWebElement(writeIntoTelephoneInputField, telephone);
    }

    public void typeIntoAddress1InputField(String address) {
        typeInWebElement(writeIntoAddress1InputField, address);
    }

    public void typeIntoCityInputField(String city) {
        typeInWebElement(writeIntoCityInputField, city);
    }

    public void typeIntoPostCodeInputField(String postcode) {
        typeInWebElement(writeIntoPostCodeInputField, postcode);
    }

    public void setCountryFromDropDownSelectMenu(String value) {
        Select country = new Select(selectDropDownMenuCountry);
        country.selectByValue(value);
    }

    public void selectRegionAndCityFromDropDownMenu(String value) {
        Select regionAndState = new Select(selectDropDownMenuRegionAndState);
        regionAndState.selectByValue(value);
    }

    public void clickContinueButtonBillingDetails() {
        clickOnWebElement(continueButtonBillingDetails);
    }

    public void clickContinueButtonDeliveryMethod() {
        clickOnWebElement(continueButtonDeliveryMethod);
    }
    public void clickTermsAndConditionsButton() {
        clickOnWebElement(agreeWithTermsAndConditionsButton);
//        WebElement agreeWithTermsAndConditionsButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='agree']")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", agreeWithTermsAndConditionsButton);
    }

    public void clickContinueButtonPaymentMethod() {
        clickOnWebElement(continueButtonPaymentMethod);
    }

    public void clickConfirmOrderButton() {
        clickOnWebElement(confirmOrderButton);
    }
    public void assertContentHeading() {
        String actualText = acceptMessageForOrder.getText();
        String expectedText = "Your order has been placed!";
        Assert.assertEquals(actualText, expectedText, "Texts aren`t the same!");
    }
}
