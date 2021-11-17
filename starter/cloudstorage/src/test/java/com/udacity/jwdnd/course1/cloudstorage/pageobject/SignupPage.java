package com.udacity.jwdnd.course1.cloudstorage.pageobject;

import com.udacity.jwdnd.course1.cloudstorage.testutils.JavascriptEvents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

    public static final String urlPath = "/signup";

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(css = "button[type=submit]")
    private WebElement submitButton;

    @FindBy(css = ".alert-dark a")
    private WebElement successMessageRedirectLink;

    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;

    private final WebDriver driver;

    public SignupPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        driver = webDriver;
    }

    public void fillFirstName(String value) {
        firstName.sendKeys(value);
    }

    public void fillLastName(String value) {
        lastName.sendKeys(value);
    }

    public void fillUsername(String value) {
        username.sendKeys(value);
    }

    public void fillPwd(String value) {
        password.sendKeys(value);
    }

    public void submitSignupForm() {
        submitButton.click();
        JavascriptEvents.waitForReadyState(driver);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}