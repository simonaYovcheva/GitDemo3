package pages;

import components.LeftNavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CategoriesPage extends LeftNavigationMenu {

//    public CategoriesPage(WebDriver driver) {
//        super(driver);
//    }

    @FindBy(xpath = "//*[@class='btn btn-default']")
    @CacheLookup
    private WebElement addNewCategoriesButton;


    @FindBy(id = "input-name1")
    @CacheLookup
    private WebElement categoryNameFieldInput;

    @FindBy(id = "input-meta-title1")
    @CacheLookup
    private WebElement metaTagTitleFieldInput;


    @FindBy(xpath = "//*[@id='content']/div[1]/div/div/button")
    @CacheLookup
    private WebElement saveNewCategoryButton;
    @FindBy(xpath = "//*[@class='fa fa-sign-out']/ ..")
    private WebElement logoutButton;

    public void setNewCategoriesButton() {
        addNewCategoriesButton.click();
    }

    public void setCategoryNameFieldInput(String nameOfCategory) {
        categoryNameFieldInput.sendKeys(nameOfCategory);
    }

    public void setMetaTagTitle(String nameOfMetaTahTitle) {
        metaTagTitleFieldInput.sendKeys(nameOfMetaTahTitle);
    }

    public void clickOnSaveButton() {
        saveNewCategoryButton.click();
    }
    public void verifyLogoutButtonIsPresent() {
        verifyWebElementIsPresent(logoutButton);
    }

    public void verifyWebElementIsPresent(WebElement webElement) {
        Assert.assertTrue(webElement.isDisplayed());
    }
}
