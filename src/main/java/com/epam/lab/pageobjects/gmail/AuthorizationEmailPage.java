package com.epam.lab.pageobjects.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AuthorizationEmailPage{
    @FindBy(css = "input[type = 'email']")
    private WebElement emailField;
    @FindBy(id = "identifierNext")
    private WebElement submitEmailButton;


    public AuthorizationEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public AuthorizationEmailPage setEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }


    public void clickSubmitButton() {
        submitEmailButton.click();
    }

}
