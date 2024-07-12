package tests.UserPagesTests;

import UserPages.FrontEndPageUser;
import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTestUserLogin {

    private BaseTest baseTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setup();
    }

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
        baseTest.app.frontEndPageUser().goToUserFrontEndPage();
        baseTest.app.frontEndPageUser().clickOnMyAccountButton();
        baseTest.app.frontEndPageUser().clickOnLoginButtonForUser();
        baseTest.app.frontEndPageUser().writeIntoUserEmailLoginField(email);
        baseTest.app.frontEndPageUser().writeIntoUserPasswordForLogin(password);
        baseTest.app.frontEndPageUser().clickOnLoginButtonUser();

        FrontEndPageUser frontEndPageUser = new FrontEndPageUser(baseTest.driver);

        if (expectedMessage.equals("My Account")) {
            frontEndPageUser.assertForSuccessLogin();
        } else {
            frontEndPageUser.assertForFailedLogin();
        }
    }
}

