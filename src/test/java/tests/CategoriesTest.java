package tests;

import base.BaseTest;
import components.LeftNavigationMenu;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoriesPage;

public class CategoriesTest extends BaseTest {

    @Test
    public void goToCategories() {
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        app.loginPage().goToLoginPage();
        app.loginPage().login("admin", "parola123!");

        categoriesPage.goToCatalog();
        categoriesPage.goToCategories();
        categoriesPage.setNewCategoriesButton();
        categoriesPage.setCategoryNameFieldInput("New Category");
        categoriesPage.setMetaTagTitle("New Category Meta Tag");
        categoriesPage.clickOnSaveButton();
        categoriesPage.isSuccessMessageDisplayed();

    }
}
