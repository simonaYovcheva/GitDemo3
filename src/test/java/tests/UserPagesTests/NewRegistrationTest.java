package tests.UserPagesTests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewRegistrationTest {

    private BaseTest baseTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setup();
    }
    
    @Test
    public void makeNewRegistration(){
        baseTest.app.frontEndPageUser().goToUserFrontEndPage();
        baseTest.app.frontEndPageUser().clickOnMyAccountButton();
        baseTest.app.frontEndPageUser().clickOnRegisterButton();
        baseTest.app.newRegistrationPage().writeIntoFirstNameField("Sisi");
        baseTest.app.newRegistrationPage().writeIntoLastNameField("Sisi");
        baseTest.app.newRegistrationPage().writeIntoEmailField();
        baseTest.app.newRegistrationPage().writeIntoTelephoneField("0123456789");
        baseTest.app.newRegistrationPage().fillPasswordFields("parola123!");
        baseTest.app.newRegistrationPage().checkAgreePrivacyPolicy();
        baseTest.app.newRegistrationPage().clickContinueButton();
        baseTest.app.newRegistrationPage().isRegistrationSuccessful();

    }
}
