package UserPages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontEndPageUser extends BasePage {
//    private WebDriver driver;
    @FindBy(xpath = "//*[@title='iPhone']")
    @CacheLookup
    private WebElement addToCartIPhoneButton;

    @FindBy(xpath = "//*[@class='caret']")
    @CacheLookup
    private WebElement myAccountButton;

    @FindBy(xpath = "//*[@id='top-links']/ul/li[2]/ul/li[1]/a")
    @CacheLookup
    private WebElement registerButton;

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
    public void clickOnMyAccountButton(){
        myAccountButton.click();
    }

    public void clickOnRegisterButton(){
        registerButton.click();
    }
}
