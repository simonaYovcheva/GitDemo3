package tests.AdminPagesTests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardPageTest {

    private BaseTest baseTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setup();
    }
    @Test
    public void changesInAdminProfile() {
        baseTest.app.loginPage().goToLoginPage();
        baseTest.app.loginPage().login("admin", "parola123!");
        baseTest.app.dashboardPage().clickOnUserProfile();
        baseTest.app.dashboardPage().clickOnYourProfile();
        baseTest.app.dashboardPage().typeIntoUsernameInput("Admin123");
        baseTest.app.dashboardPage().typeIntoUserFirstNameInput("Milen Milen");
//       baseTest.app.dashboardPage().changeUserImage("C:\\Simona\\download.jpg");
        baseTest.app.dashboardPage().typeIntoConfirmPassword("parola123!");
        baseTest.app.dashboardPage().clickOnSaveButton();
    }
}
