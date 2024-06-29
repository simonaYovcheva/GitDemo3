package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OrderPageAdmin;

public class OrderPageAdminTest extends BaseTest {

    @Test
    public void searchOrderById() {
        app.loginPage().goToLoginPage();
        app.loginPage().login("admin", "parola123!");
        app.orderPageAdmin().goToSales();
        app.orderPageAdmin().goToOrderMenu();
        String orderId = "1111";
        app.orderPageAdmin().typeIntoOrderIDField(orderId);
        app.orderPageAdmin().clickOnButtonFilterButton();
        OrderPageAdmin orderPageAdmin = new OrderPageAdmin(driver);
        String actualOrderIdText = orderPageAdmin.orderIdText();
        Assert.assertEquals(actualOrderIdText, orderId, "The searched order ID doesn't match the expected ID.");

    }
}
