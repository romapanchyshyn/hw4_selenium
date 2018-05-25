package com.epam.lab.pageobjects.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthorizationPasswordPage {
    @FindBy(css = "input[type = 'password']")
    private WebElement passwordField;
    @FindBy(id = "passwordNext")
    private WebElement submitPasswordButton;
    private WebDriver driver;
    private WebDriverWait wait;

    public AuthorizationPasswordPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 7);
        this.driver = driver;
    }

    public AuthorizationPasswordPage setPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
        return this;
    }

    public void clickSubmitButton() {
        submitPasswordButton.click();
    }
}
