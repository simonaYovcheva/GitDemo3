package tests.AdminPagesTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

//

    @Test
    public void testSuccessfulLogin() {
        app.loginPage().goToLoginPage();
        app.loginPage().writeIntoUsernameInputField("admin");
        app.loginPage().writeIntoPasswordInputField("parola123!");
        app.loginPage().clickLoginButton();
        app.dashboardPage().verifyLogoutButtonIsPresent();
    }

    @Test
    public void anotherLoginTest() {
        app.loginPage().goToLoginPage();
        app.loginPage().login("admin1", "parola123!");
        app.dashboardPage().verifyLogoutButtonIsPresent();
    }

    @Test
    public void testUnsuccessfulLogin(){
        app.loginPage().goToLoginPage();
        app.loginPage().login("a", "parola123!");
        Assert.assertTrue(app.loginPage().isLoginErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }
}
