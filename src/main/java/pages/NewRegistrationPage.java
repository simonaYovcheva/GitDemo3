package pages;

import base.BasePage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class NewRegistrationPage extends BasePage {

    @FindBy(id = "input-firstname")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(id = "input-lastname")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(id = "input-email")
    @CacheLookup
    private WebElement emailField;

    @FindBy(id = "input-telephone")
    @CacheLookup
    private WebElement telephoneInputField;

    @FindBy(id = "input-password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(id = "input-confirm")
    @CacheLookup
    private WebElement passwordConfirmField;

    @FindBy(xpath = "//*[@type='checkbox']")
    @CacheLookup
    private WebElement agreeWithPrivacyPolicyCheckBox;

    @FindBy(xpath = "//*[@value='Continue']")
    @CacheLookup
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id='content']/h1")
    @CacheLookup
    private WebElement messageForNewAccount;


    public NewRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void writeIntoFirstNameField(String firstName) {
        firstNameField.sendKeys(firstName);
    }

    public void writeIntoLastNameField(String lastName) {
        lastNameField.sendKeys(lastName);
    }

    public void writeIntoEmailField() {
        String prefix = RandomStringUtils.randomAlphanumeric(6);
        String postfix = RandomStringUtils.randomAlphabetic(3);
        String randomEmail = prefix + "@" + postfix + ".com";
        emailField.sendKeys(randomEmail);
    }

    public void writeIntoTelephoneField(String telephoneNumber) {
        telephoneInputField.sendKeys(telephoneNumber);
    }

    public void writeIntoPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public void writeIntoPasswordConfirmField(String password) {
        passwordConfirmField.sendKeys(password);
    }

    public void fillPasswordFields(String password) {
        writeIntoPasswordField(password);
        writeIntoPasswordConfirmField(password);
    }

    public void checkAgreePrivacyPolicy() {
        agreeWithPrivacyPolicyCheckBox.click();
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public void isRegistrationSuccessful() {
        String actualText = messageForNewAccount.getText();
        String expectedText = "Your Account Has Been Created!";
        Assert.assertEquals(actualText, expectedText, "Registration failed!");
    }
}
