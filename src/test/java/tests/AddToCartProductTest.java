package tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AddToCartProductTest extends BaseTest {
    @Test
    public void newUserOrderTest() {
        app.frontEndPageUser().goToUserFrontEndPage();
        app.frontEndPageUser().clickIPhoneOrder();
        app.addToCartProductPage().changeQuantityOfTheProduct("2");
        app.addToCartProductPage().clickAddToCartButton();
        app.addToCartProductPage().clickCartTotalButton();
        app.addToCartProductPage().clickCheckoutButtonDropDownMenu();
        app.addToCartProductPage().clickRadioButtonGuestCheckout();
        app.addToCartProductPage().clickContinueButtonNewCustomerOrder();
        app.addToCartProductPage().typeIntoFirstNameInputField("Simona");
        app.addToCartProductPage().typeIntoLastNameInputField("Iordanova");
        app.addToCartProductPage().randomEmail();
        app.addToCartProductPage().typeIntoTelephoneInputField("0888888888");
        app.addToCartProductPage().typeIntoAddress1InputField("Iskar");
        app.addToCartProductPage().typeIntoCityInputField("Sofia");
        app.addToCartProductPage().typeIntoPostCodeInputField("1010");
        app.addToCartProductPage().setCountryFromDropDownSelectMenu("33");
        app.addToCartProductPage().selectRegionAndCityFromDropDownMenu("498");
        app.addToCartProductPage().clickContinueButtonBillingDetails();
        app.addToCartProductPage().clickContinueButtonDeliveryMethod();
        app.addToCartProductPage().clickTermsAndConditionsButton();
        app.addToCartProductPage().clickContinueButtonPaymentMethod();
        app.addToCartProductPage().clickConfirmOrderButton();
        app.addToCartProductPage().assertContentHeading();

    }
}
