package com.softserve.firsttask.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class HeaderPart {

    protected WebDriver driver;

    private WebElement logo;
    private WebElement home;
    private WebElement adressToLatLong;
    private WebElement latLongToAddress;
    private WebElement latLongToDms;
    private WebElement dmsToDecimalDegrees;
    private WebElement latestPlaces;
    private WebElement countryList;
    private WebElement addPlace;
    private WebElement latLongToUtm;

    protected HeaderPart(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        logo = driver.findElement(By.className("logo"));
        home = driver.findElement(By.cssSelector(".col-10 li:nth-child(1)"));
        adressToLatLong = driver.findElement(By.cssSelector(".col-10 li:nth-child(2)"));
        latLongToAddress = driver.findElement(By.cssSelector(".col-10 li:nth-child(3)"));
        latLongToDms = driver.findElement(By.cssSelector(".col-10 li:nth-child(4)"));
        dmsToDecimalDegrees = driver.findElement(By.cssSelector(".col-10 li:nth-child(5)"));
        latestPlaces = driver.findElement(By.cssSelector(".col-10 li:nth-child(6)"));
        countryList = driver.findElement(By.cssSelector(".col-10 li:nth-child(7)"));
        addPlace = driver.findElement(By.cssSelector(".col-10 li:nth-child(8)"));
        latLongToUtm = driver.findElement(By.cssSelector(".col-10 li:nth-child(9)"));
    }

    // Page object

    // logo

    public WebElement getLogo() {
        return logo;
    }

    public void clickLogo() {
        getLogo().click();
    }

    // home

    public WebElement getHome() {
        return home;
    }

    public String getHomeText() {
        return getHome().getText();
    }

    public void clickHome() {
        getHome().click();
    }

    // adressToLatLong

    public WebElement getAdressToLatLong() {
        return adressToLatLong;
    }

    public String getAdressToLatLongText() {
        return getAdressToLatLong().getText();
    }

    public void clickAdressToLatLong() {
        getAdressToLatLong().click();
    }


    //latLongToAddress

    public WebElement getLatLongToAddress() {
        return latLongToAddress;
    }

    public String getLatLongToAddressText() {
        return getLatLongToAddress().getText();
    }

    public void clickLatLongToAddress() {
        getLatLongToAddress().click();
    }

    // latLongToDms

    public WebElement getLatLongToDms() {
        return latLongToDms;
    }

    public String getLatLongToDmsText() {
        return getLatLongToDms().getText();
    }

    public void clickLatLongToDms() {
        getLatLongToDms().click();
    }

    // dmsToDecimalDegrees

    public WebElement getDmsToDecimalDegrees() {
        return dmsToDecimalDegrees;
    }

    public String getDmsToDecimalDegreesText() {
        return getDmsToDecimalDegrees().getText();
    }

    public void clickDmsToDecimalDegrees() {
        getDmsToDecimalDegrees().click();
    }

    // latestPlaces

    public WebElement getLatestPlaces() {
        return latestPlaces;
    }

    public String getLatestPlacesText() {
        return getLatestPlaces().getText();
    }

    public void clicklatestPlaces() {
        getLatestPlaces().click();
    }

    // addPlace

    public WebElement getAddPlace() {
        return addPlace;
    }

    public String getAddPlaceText() {
        return getAddPlace().getText();
    }

    public void clickAddPlace() {
        getAddPlace().click();
    }

    // countryList

    public WebElement getCountryList() {
        return countryList;
    }

    public String getCountryListText() {
        return getCountryList().getText();
    }

    public void clickCountryList() {
        getCountryList().click();
    }

    // latLongToUtm

    public WebElement getLatLongToUtm() {
        return latLongToUtm;
    }

    public String getLatLongToUtmText() {
        return getLatLongToUtm().getText();
    }

    public void clickLatLongToUtm() {
        getLatLongToUtm().click();
    }

    // Functional

    public HomePage gotoHomePage() {
        clickHome();
        return new HomePage(driver);
    }

    // Business Logic

}
