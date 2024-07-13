package tests.UserPagesTests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartProductTest {

    private BaseTest baseTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setup();
    }

    @Test
    public void newUserOrderTest() {
        navigateToUserFrontEnd();
        placeOrderWithGuestCheckout();
    }

    private void navigateToUserFrontEnd() {
        baseTest.app.frontEndPageUser().goToUserFrontEndPage();
        baseTest.app.frontEndPageUser().clickIPhoneOrder();
    }

    private void placeOrderWithGuestCheckout() {
        baseTest.app.addToCartProductPage().changeQuantityOfTheProduct("2");
        baseTest.app.addToCartProductPage().clickAddToCartButton();
        baseTest.app.addToCartProductPage().clickCartTotalButton();
        baseTest.app.addToCartProductPage().clickCheckoutButtonDropDownMenu();
        fillGuestCheckoutDetails();
        finalizeOrder();
    }

    private void fillGuestCheckoutDetails() {
        baseTest.app.addToCartProductPage().clickRadioButtonGuestCheckout();
        baseTest.app.addToCartProductPage().clickContinueButtonNewCustomerOrder();
        baseTest.app.addToCartProductPage().typeIntoFirstNameInputField("Simona");
        baseTest.app.addToCartProductPage().typeIntoLastNameInputField("Iordanova");
        baseTest.app.addToCartProductPage().randomEmail();
        baseTest.app.addToCartProductPage().typeIntoTelephoneInputField("0888888888");
        baseTest.app.addToCartProductPage().typeIntoAddress1InputField("Iskar");
        baseTest.app.addToCartProductPage().typeIntoCityInputField("Sofia");
        baseTest.app.addToCartProductPage().typeIntoPostCodeInputField("1010");
        baseTest.app.addToCartProductPage().setCountryFromDropDownSelectMenu("33");
        baseTest.app.addToCartProductPage().selectRegionAndCityFromDropDownMenu("498");
        baseTest.app.addToCartProductPage().clickContinueButtonBillingDetails();
    }

    private void finalizeOrder() {
        baseTest.app.addToCartProductPage().clickContinueButtonDeliveryMethod();
        baseTest.app.addToCartProductPage().clickTermsAndConditionsButton();
        baseTest.app.addToCartProductPage().clickContinueButtonPaymentMethod();
        baseTest.app.addToCartProductPage().clickConfirmOrderButton();
        baseTest.app.addToCartProductPage().assertContentHeading();
    }
}
