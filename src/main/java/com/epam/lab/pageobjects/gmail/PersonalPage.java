package com.epam.lab.pageobjects.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class PersonalPage {

    @FindBy(css = "[jsmodel = 'nXDxbd']")
    private List<WebElement> letters;
    @FindBy(css = "div[role='checkbox']")
    private List<WebElement> lettersCheckboxes;
    @FindBy(css = "[act='10'][role='button']")
    private WebElement deleteButton;
    @FindBy(id = "link_undo")
    private WebElement undoButton;
    private WebDriver driver;
    private List<String> deletedLettersText;
    private WebDriverWait wait;

    public PersonalPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 7);
        this.driver = driver;
    }

    public void markLettersCheckbox(int number) {
        wait.until(ExpectedConditions.elementToBeClickable(lettersCheckboxes.get(1)));
        lettersCheckboxes.stream().limit(number).forEach(WebElement::click);
        deletedLettersText = letters.stream().limit(number).map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickDeleteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton));
        deleteButton.click();
    }

    public void clickUndoButton() {
        wait.until(ExpectedConditions.visibilityOf(undoButton));
        undoButton.click();
    }

    public boolean verifyLettersNotDeleted() {
        List<String> lettersText = letters.stream().map(WebElement::getText).collect(Collectors.toList());
        return lettersText.containsAll(deletedLettersText);
    }
}
