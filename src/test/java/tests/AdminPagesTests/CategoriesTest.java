package tests.AdminPagesTests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPages.CategoriesPage;

public class CategoriesTest {

    private BaseTest baseTest;

    @BeforeMethod
    public void setUp() {
        baseTest = new BaseTest();
        baseTest.setup();
    }
    
    @Test
    public void goToCategories() {
        CategoriesPage categoriesPage = new CategoriesPage(baseTest.driver);
        baseTest.app.loginPage().goToLoginPage();
        baseTest.app.loginPage().login("admin", "parola123!");

        categoriesPage.goToCatalog();
        categoriesPage.goToCategories();
        categoriesPage.setNewCategoriesButton();
        categoriesPage.setCategoryNameFieldInput("New Category");
        categoriesPage.setMetaTagTitle("New Category Meta Tag");
        categoriesPage.clickOnSaveButton();
        categoriesPage.isSuccessMessageDisplayed();

    }
}
