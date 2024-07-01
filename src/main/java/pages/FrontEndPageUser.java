package pages;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndPageUser extends BasePage {
    private WebDriver driver;
    @FindBy(xpath = "//*[@title='iPhone']")
    @CacheLookup
    private WebElement addToCartIPhoneButton;

    public FrontEndPageUser(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void goToUserFrontEndPage(){
        goPage("https://shop.pragmatic.bg/");
    }

    public void clickIPhoneOrder() {
        addToCartIPhoneButton.click();
    }
}
