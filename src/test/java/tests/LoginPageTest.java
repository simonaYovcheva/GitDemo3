package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

//

    @Test
    public void someTestMethod() {
        app.loginPage().goToLoginPage();
        app.loginPage().writeIntoUsernameInputField("admin");
        app.loginPage().writeIntoPasswordInputField("parola123!");
        app.loginPage().clickLoginButton();
        app.dashboardPage().verifyLogoutButtonIsPresent();
    }

    @Test
    public void anotherLoginTest() {
        app.loginPage().goToLoginPage();
        app.loginPage().login("admin", "parola123!");
        
        app.dashboardPage().verifyLogoutButtonIsPresent();

    }
}
