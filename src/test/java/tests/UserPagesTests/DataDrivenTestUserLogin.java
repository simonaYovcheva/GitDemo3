package tests.UserPagesTests;

import UserPages.FrontEndPageUser;
import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestUserLogin extends BaseTest {


    @DataProvider()
    public Object[][] dataProvider() {
        String[][] testData = {
                {"Prcsf5@JzM.com", "parola123!", "My Account"},
                {"Prcsf5@JzM.com", "", "Warning: No match for E-Mail Address and/or Password."},
                {"invalid-email", "parola123!", "Warning: No match for E-Mail Address and/or Password."},
                {"", "parola123!", "Warning: No match for E-Mail Address and/or Password."},
                {"invalid-email", "invalid-password", "Warning: No match for E-Mail Address and/or Password."},
                {"", "", "Warning: No match for E-Mail Address and/or Password."},
        };
        return testData;
    }

    @Test(dataProvider = "dataProvider")
    public void testDdtForUserLogin(String email, String password, String expectedMessage){
        app.frontEndPageUser().goToUserFrontEndPage();
        app.frontEndPageUser().clickOnMyAccountButton();
        app.frontEndPageUser().clickOnLoginButtonForUser();
        app.frontEndPageUser().writeIntoUserEmailLoginField(email);
        app.frontEndPageUser().writeIntoUserPasswordForLogin(password);
        app.frontEndPageUser().clickOnLoginButtonUser();

        FrontEndPageUser frontEndPageUser = new FrontEndPageUser(driver);

        if (expectedMessage.equals("My Account")) {
            frontEndPageUser.assertForSuccessLogin();
        } else {
            frontEndPageUser.assertForFailedLogin();
        }
    }
}

