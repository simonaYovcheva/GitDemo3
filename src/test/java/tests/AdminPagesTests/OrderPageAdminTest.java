package tests.AdminPagesTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPages.OrderPageAdmin;

public class OrderPageAdminTest {

    private BaseTest baseTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setup();
    }
    
    @Test
    public void searchOrderById() {
        baseTest.app.loginPage().goToLoginPage();
        baseTest.app.loginPage().login("admin", "parola123!");
        baseTest.app.orderPageAdmin().goToSales();
        baseTest.app.orderPageAdmin().goToOrderMenu();
        String orderId = "1111";
        baseTest.app.orderPageAdmin().typeIntoOrderIDField(orderId);
        baseTest.app.orderPageAdmin().clickOnButtonFilterButton();
        OrderPageAdmin orderPageAdmin = new OrderPageAdmin(baseTest.driver);
        String actualOrderIdText = orderPageAdmin.orderIdText();
        Assert.assertEquals(actualOrderIdText, orderId, "The searched order ID doesn't match the expected ID.");

    }
}
