import UserPages.FrontEndPageUser;
import base.BaseTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class UserLoginStepDefinition extends BaseTest {


    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {

        app.frontEndPageUser().goToUserFrontEndPage();
        app.frontEndPageUser().clickOnMyAccountButton();
        app.frontEndPageUser().clickOnLoginButtonForUser();
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String email, String password) {
        app.frontEndPageUser().writeIntoUserEmailLoginField(email);
        app.frontEndPageUser().writeIntoUserPasswordForLogin(password);
        app.frontEndPageUser().clickOnLoginButtonUser();
    }

    @Then("the login should be {string}")
    public void theLoginShouldBe(String expectedMessage) {
        if (expectedMessage.equals("My Account")) {
            Assert.assertEquals(app.frontEndPageUser().getLoginSuccessfulMessage(), expectedMessage, "The login should be successful!");
        } else {
            String actualMessage = app.frontEndPageUser().getLoginFailedMessage();
            if (actualMessage.equals("Warning: No match for E-Mail Address and/or Password.") ||
                    actualMessage.equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Unexpected error message: " + actualMessage);
            }
        }
    }
}
