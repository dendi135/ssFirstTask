package com.softserve.firsttask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends HeaderPart {

    private WebElement titleWords;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        titleWords = driver.findElement(By.cssSelector("h1"));
    }

    // Page Object

    public WebElement getTitleWords() {
        return titleWords;
    }

    public String getTitleWordsText() {
        return getTitleWords().getText();
    }

    // Functional

    // Business Logic

}
