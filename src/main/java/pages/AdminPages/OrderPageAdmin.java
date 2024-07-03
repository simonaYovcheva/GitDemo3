package pages.AdminPages;

import components.LeftNavigationMenu;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPageAdmin extends LeftNavigationMenu {
    private WebDriver driver;

    public OrderPageAdmin(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "menu-sale")
    @CacheLookup
    private WebElement salesButton;

    @FindBy(xpath = "//*[@id='collapse4']/li[1]")
    @CacheLookup
    private WebElement ordersButton;

    @FindBy(id = "input-order-id")
    @CacheLookup
    private WebElement orderIdField;


    @FindBy(id = "button-filter")
    @CacheLookup
    private WebElement buttonFilterButton;

    @FindBy(xpath = "//*[@id='form-order']/div/table/tbody/tr/td[2]")
    @CacheLookup
    private WebElement inputIdAfterSearch;

    public void typeIntoOrderIDField(String idNumber){
        orderIdField.sendKeys(idNumber);
    }
    public void clickOnButtonFilterButton(){
        buttonFilterButton.click();
    }



    public void goToSales() {
        salesButton.click();
    }
    public void goToOrderMenu() {
        ordersButton.click();
    }

    public String orderIdText(){
        return inputIdAfterSearch.getText();
    }
}
