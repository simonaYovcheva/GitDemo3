package core;

import UserPages.AddToCartProductPage;
import UserPages.FrontEndPageUser;
import UserPages.NewRegistrationPage;
import org.openqa.selenium.WebDriver;
import pages.AdminPages.DashboardPage;
import pages.AdminPages.LoginPage;
import pages.AdminPages.OrderPageAdmin;

public class App {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private OrderPageAdmin orderPageAdmin;

    private FrontEndPageUser frontEndPageUser;
    private AddToCartProductPage addToCartProductPage;
    private NewRegistrationPage newRegistrationPage;

    public App(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage(driver);
        }
        return dashboardPage;
    }
    public OrderPageAdmin orderPageAdmin() {
        if (orderPageAdmin == null) {
            orderPageAdmin = new OrderPageAdmin(driver);
        }
        return orderPageAdmin;
    }

    public AddToCartProductPage addToCartProductPage() {
        if (addToCartProductPage == null) {
            addToCartProductPage = new AddToCartProductPage(driver);
        }
        return addToCartProductPage;
    }
    public FrontEndPageUser frontEndPageUser() {
        if (frontEndPageUser == null) {
            frontEndPageUser = new FrontEndPageUser(driver);
        }
        return frontEndPageUser;
    }

    public NewRegistrationPage newRegistrationPage() {
        if (newRegistrationPage == null) {
            newRegistrationPage = new NewRegistrationPage(driver);
        }
        return newRegistrationPage;
    }
}
