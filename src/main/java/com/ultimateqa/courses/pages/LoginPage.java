package com.ultimateqa.courses.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath= "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeText ;


    @CacheLookup
    @FindBy(id= "user[email]")
    WebElement emailField ;

    @CacheLookup
    @FindBy(name= "user[password]")
    WebElement passwordField ;

    @CacheLookup
    @FindBy(xpath= "//button[contains(text(),'Sign in')]")
    WebElement signInButton ;

    @CacheLookup
    @FindBy(xpath= "//li[contains(text(),'Invalid email or password.')]")
    WebElement errorMessage ;

    public String getWelcomeText() {
        Reporter.log("verify the welcome message"+ welcomeText.toString());
        String message=getTextFromElement(welcomeText);
        CustomListeners.test.log(Status.PASS,"welcome message" );
        return message;

    }

    public void enterEmail(String email) {
        Reporter.log("enter email to the email field"+email + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "enter email ");

    }

    public void enterPassword(String password) {
        Reporter.log("enter password to the password field"+password + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "enter password");
    }

    public void clickOnSignInButton() {
        Reporter.log("click to sign in button" +signInButton .toString());
        clickOnElement(signInButton);
        CustomListeners.test.log(Status.PASS, "click to sign in button ");
    }

    public String getErrorMessage() {
        Reporter.log("verify the error message"+ errorMessage.toString());
        String message=getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS,"error message" );
        return message;
    }

}
