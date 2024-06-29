package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage extends BasePage {

    @FindBy(id = "input-username")
    private WebElement usernameInputField;

    @FindBy(id = "input-password")
    private WebElement passwordInputField;

    @FindBy(className = "btn-primary")
    private WebElement loginButton;

    private static final String URL = "https://shop.pragmatic.bg/admin";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToLoginPage() {
        goPage(URL);
    }

    public void writeIntoUsernameInputField(String username) {
        typeInWebElement(usernameInputField, username);
    }

    public void writeIntoPasswordInputField(String password) {
        typeInWebElement(passwordInputField, password);
    }

    public void clickLoginButton() {
        clickOnWebElement(loginButton);
    }

    public void login(String username, String password) {
        writeIntoUsernameInputField(username);
        writeIntoPasswordInputField(password);
        clickLoginButton();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
    }
}
