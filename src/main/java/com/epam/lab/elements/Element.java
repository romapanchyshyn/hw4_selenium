package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public class Element implements IElement {
    protected WebElement webElement;

    public Element(WebElement webElement) {
        this.webElement = webElement;
    }

}
