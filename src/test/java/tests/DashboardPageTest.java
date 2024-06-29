package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {

    @Test
    public void changesInAdminProfile() {
        app.loginPage().goToLoginPage();
        app.loginPage().login("admin", "parola123!");
        app.dashboardPage().clickOnUserProfile();
        app.dashboardPage().clickOnYourProfile();
        app.dashboardPage().typeIntoUsernameInput("Admin123");
        app.dashboardPage().typeIntoUserFirstNameInput("Milen Milen");
//       app.dashboardPage().changeUserImage("C:\\Simona\\download.jpg");
        app.dashboardPage().typeIntoConfirmPassword("parola123!");
        app.dashboardPage().clickOnSaveButton();
    }
}
