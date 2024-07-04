package UserPages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FrontEndPageUser extends BasePage {

    @FindBy(xpath = "//*[@title='iPhone']")
    @CacheLookup
    private WebElement addToCartIPhoneButton;

    @FindBy(xpath = "//*[@class='caret']")
    @CacheLookup
    private WebElement myAccountButton;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[2]/ul/li[1]/a")
    @CacheLookup
    private WebElement registerButton;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[2]/ul//li[2]/a")
    @CacheLookup
    private WebElement loginButtonUser;

    @FindBy(id = "input-email")
    @CacheLookup
    private WebElement userLoginWithEmail;

    @FindBy(id = "input-password")
    @CacheLookup
    private WebElement userLoginPassword;

    @FindBy(xpath = "//*[@value='Login']")
    @CacheLookup
    private WebElement userProfileLoginButton;

    @FindBy(xpath = "//*[@id='content']/h2[1]")
    @CacheLookup
    private WebElement loginSuccessfulMessage;

    @FindBy(xpath = "//*[@id='account-login']/div[1]")
    @CacheLookup
    private WebElement loginFailedMessage;

    public FrontEndPageUser(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToUserFrontEndPage() {
        goPage("https://shop.pragmatic.bg/");
    }

    public void clickIPhoneOrder() {
        addToCartIPhoneButton.click();
    }

    public void clickOnMyAccountButton() {
        myAccountButton.click();
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public void clickOnLoginButtonForUser() {
        loginButtonUser.click();
    }

    public void writeIntoUserEmailLoginField(String email) {
        userLoginWithEmail.sendKeys(email);
    }

    public void writeIntoUserPasswordForLogin(String password) {
        userLoginPassword.sendKeys(password);
    }

    public void clickOnLoginButtonUser() {
        userProfileLoginButton.click();
    }

    public String getLoginSuccessfulMessage() {
        return loginSuccessfulMessage.getText();
    }

    public String getLoginFailedMessage() {
        return loginFailedMessage.getText();
    }

    public void assertForSuccessLogin() {
        Assert.assertEquals(getLoginSuccessfulMessage(), "My Account", "The login should be successful!");
    }

    public void assertForFailedLogin() {
        String actualMessage = getLoginFailedMessage().trim();
        if (actualMessage.equals("Warning: No match for E-Mail Address and/or Password.") ||
                actualMessage.equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Unexpected error message: " + actualMessage);
        }
    }
}

