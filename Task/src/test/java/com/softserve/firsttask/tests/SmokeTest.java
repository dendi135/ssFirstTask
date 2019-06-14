package com.softserve.firsttask.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends TestRunner {

    @Test
    public void smokeTest() {
        WebElement actualTitle = driver.findElement(By.cssSelector("h1"));
        String expectedTitle = "Get Latitude and Longitude";
        Assert.assertEquals(actualTitle.getText(), expectedTitle);
    }

}
