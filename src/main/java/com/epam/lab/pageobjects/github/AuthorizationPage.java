package com.epam.lab.pageobjects.github;

import com.epam.lab.pageobjects.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage extends PageObject {
    @FindBy(id = "login_field")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(name = "commit")
    private WebElement submitButton;

//    public AuthorizationPage(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }

    public AuthorizationPage setLogin(String email) {
        loginField.sendKeys(email);
        return this;
    }

    public AuthorizationPage setPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmmitButton() {
        submitButton.click();
    }

}
