package tests.UserPagesTests;

import base.BaseTest;
import org.testng.annotations.Test;

public class NewRegistrationTest extends BaseTest {

    @Test
    public void makeNewRegistration(){
        app.frontEndPageUser().goToUserFrontEndPage();
        app.frontEndPageUser().clickOnMyAccountButton();
        app.frontEndPageUser().clickOnRegisterButton();
        app.newRegistrationPage().writeIntoFirstNameField("Sisi");
        app.newRegistrationPage().writeIntoLastNameField("Sisi");
        app.newRegistrationPage().writeIntoEmailField();
        app.newRegistrationPage().writeIntoTelephoneField("0123456789");
        app.newRegistrationPage().fillPasswordFields("parola123!");
        app.newRegistrationPage().checkAgreePrivacyPolicy();
        app.newRegistrationPage().clickContinueButton();
        app.newRegistrationPage().isRegistrationSuccessful();

    }
}
