package core;

import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.LoginPage;

public class App {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

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
}
