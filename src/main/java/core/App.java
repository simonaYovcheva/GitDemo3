package core;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;
import pages.OrderPageAdmin;

public class App {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private OrderPageAdmin orderPageAdmin;

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
}
