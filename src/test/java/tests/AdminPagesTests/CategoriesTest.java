package tests.AdminPagesTests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.AdminPages.CategoriesPage;

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
