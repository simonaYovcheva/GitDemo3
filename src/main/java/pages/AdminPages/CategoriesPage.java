package pages.AdminPages;

import components.LeftNavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CategoriesPage extends LeftNavigationMenu {

    public CategoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='content']/div[1]/div/div/a[1]")
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
    @CacheLookup
    private WebElement logoutButton;

    @FindBy(xpath = "//div[contains(@class, 'alert-success') and contains(., 'Success')]")
    @CacheLookup
    private WebElement successMessageElement;

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
    public String getSuccessMessageText() {
        return successMessageElement.getText();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessageElement.isDisplayed();
    }

}
