package com.epam.lab.pageobjects;

import com.epam.lab.decorator.MyFieldDecorator;
import com.epam.lab.webdriver.Driver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

public class PageObject {

    public PageObject() {
        PageFactory.initElements(
                new MyFieldDecorator(
                        new DefaultElementLocatorFactory(Driver.getWebDriver())
                ), this);
    }

}
