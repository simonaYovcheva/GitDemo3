package tests;

import base.BaseTest;
import components.LeftNavigationMenu;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CategoriesTest extends BaseTest {

    @Test
    public void goToCategories(){
        LeftNavigationMenu navigationMenu= new LeftNavigationMenu();
        app.loginPage().goToLoginPage();
        app.loginPage().login("admin", "parola123!");
        navigationMenu.goToCatalog();
        navigationMenu.goToCategories();


    }
}
