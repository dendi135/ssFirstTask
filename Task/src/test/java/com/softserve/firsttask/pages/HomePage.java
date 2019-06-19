package com.softserve.firsttask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends HeaderPart {

    private WebElement titleWords;
    private WebElement description;
    private WebElement grayBox;

    public HomePage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        titleWords = driver.findElement(By.cssSelector("h1"));
        description = driver.findElement(By.cssSelector("main p"));
        grayBox = driver.findElement(By.cssSelector(".graybox"));
    }

    // Page Object

    // titleWords

    public WebElement getTitleWords() {
        return titleWords;
    }

    public String getTitleWordsText() {
        return getTitleWords().getText();
    }

    // description

    public WebElement getDescription() {
        return description;
    }

    public String getDescriptionText() {
        return getDescription().getText();
    }

    // grayBox

    public WebElement getGrayBox() {
        return grayBox;
    }

    public SearchPlaceComponent getGrayBoxComponent() {
        return new SearchPlaceComponent(getGrayBox());
    }

    // Functional

    public HomePage findByPlaceName(String name) {
        getGrayBoxComponent().clickPlaceName();
        getGrayBoxComponent().clearPlaceName();
        getGrayBoxComponent().setPlaceName(name);
        getGrayBoxComponent().clickFind();
        return new HomePage(driver);
    }

    // Business Logic

}
