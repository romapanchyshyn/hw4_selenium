package com.epam.lab.pageobjects.github;

import com.epam.lab.pageobjects.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends PageObject{
    @FindBy(name = "q")
    private WebElement searchField;

//    public NavigationBar(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }

    public void setSerchQuery(String query) {
        searchField.clear();
        searchField.sendKeys(query, Keys.ENTER);
    }
}
