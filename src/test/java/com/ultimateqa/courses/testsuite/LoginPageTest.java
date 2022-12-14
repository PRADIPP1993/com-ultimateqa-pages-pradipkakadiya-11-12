package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class LoginPageTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage ;


    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnSignInLink();
        Assert.assertEquals(loginPage.getWelcomeText(),"Welcome Back!","Welcome Text not found/ Not navigated to SignIn Page");
    }

    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessage() {
        homePage.clickOnSignInLink();
        loginPage.enterEmail("praidp123@gmail.com");
        loginPage.enterPassword("test123");
        loginPage.clickOnSignInButton();
        Assert.assertEquals(loginPage.getErrorMessage(),"Invalid email or password.","Error message not found");
    }

}
