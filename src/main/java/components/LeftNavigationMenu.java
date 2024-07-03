package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNavigationMenu {
    private WebDriver driver;

    @FindBy(xpath ="//*[@id='menu-catalog']/a")
    @CacheLookup
    private WebElement catalogButton;

    @FindBy(xpath = "//*[@id = 'collapse1']/li[1]")
    @CacheLookup
    private WebElement categoriesButton;

    @FindBy(id = "menu-sale")
    @CacheLookup
    private WebElement salesButton;

    @FindBy(xpath = "//*[@id='collapse4']/li[1]")
    @CacheLookup
    private WebElement ordersButton;

    public LeftNavigationMenu(WebDriver driver) {
        super();
        PageFactory.initElements(driver, this);
    }


    public void goToCatalog() {

        catalogButton.click();
    }

    public void goToCategories () {
        categoriesButton.click();
    }
}
