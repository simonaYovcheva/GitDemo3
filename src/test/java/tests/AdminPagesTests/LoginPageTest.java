package tests.AdminPagesTests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {

    private BaseTest baseTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setup();
    }
    @Test
    public void testSuccessfulLogin() {
        baseTest.app.loginPage().goToLoginPage();
        baseTest.app.loginPage().writeIntoUsernameInputField("admin");
        baseTest.app.loginPage().writeIntoPasswordInputField("parola123!");
        baseTest.app.loginPage().clickLoginButton();
        baseTest.app.dashboardPage().verifyLogoutButtonIsPresent();
    }

    @Test
    public void anotherLoginTest() {
        baseTest.app.loginPage().goToLoginPage();
        baseTest.app.loginPage().login("admin1", "parola123!");
        baseTest.app.dashboardPage().verifyLogoutButtonIsPresent();
    }

    @Test
    public void testUnsuccessfulLogin(){
        baseTest.app.loginPage().goToLoginPage();
        baseTest.app.loginPage().login("a", "parola123!");
        Assert.assertTrue(baseTest.app.loginPage().isLoginErrorMessageDisplayed(), "Error message is not displayed for invalid login");
    }
}
