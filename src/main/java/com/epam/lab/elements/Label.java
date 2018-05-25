package com.epam.lab.elements;

import org.openqa.selenium.WebElement;

public class Label extends Element{
    public Label(WebElement webElement) {
        super(webElement);
    }

    public String getId(){
        return webElement.getAttribute("id");
    }

    public boolean isLableEmpty(){
        return (webElement.getText().trim().equals(""));
    }

    public String getText(){
        return webElement.getText();
    }
}
