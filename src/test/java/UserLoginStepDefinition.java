
import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class UserLoginStepDefinition {

    private final BaseTest baseTest = new BaseTest();

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        baseTest.setup(); // Manually call setup
        baseTest.app.frontEndPageUser().goToUserFrontEndPage();
        baseTest.app.frontEndPageUser().clickOnMyAccountButton();
        baseTest.app.frontEndPageUser().clickOnLoginButtonForUser();
    }

    @When("the user enters {string} and {string}")
    public void theUserEntersAnd(String email, String password) {
        baseTest.app.frontEndPageUser().writeIntoUserEmailLoginField(email);
        baseTest.app.frontEndPageUser().writeIntoUserPasswordForLogin(password);
        baseTest.app.frontEndPageUser().clickOnLoginButtonUser();
    }

    @Then("the login should be {string}")
    public void theLoginShouldBe(String expectedMessage) {
        if (expectedMessage.equals("My Account")) {
            Assert.assertEquals(baseTest.app.frontEndPageUser().getLoginSuccessfulMessage(), expectedMessage, "The login should be successful!");
        } else {
            String actualMessage = baseTest.app.frontEndPageUser().getLoginFailedMessage();
            if (actualMessage.equals("Warning: No match for E-Mail Address and/or Password.") ||
                    actualMessage.equals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.")) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Unexpected error message: " + actualMessage);
            }
        }
    }
}
