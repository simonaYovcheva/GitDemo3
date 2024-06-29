package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//*[@class='fa fa-sign-out']/ ..")
    private WebElement logoutButton;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    public void verifyLogoutButtonIsPresent() {
        verifyWebElementIsPresent(logoutButton);
    }
}
