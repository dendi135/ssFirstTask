package com.softserve.firsttask.tests;

import com.softserve.firsttask.data.PlacesRepository;
import com.softserve.firsttask.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends TestRunner {

    @DataProvider(name = "textProvider")
    public Object[][] correctData() {
        return new Object[][]{
                {"Get Latitude and Longitude"}
        };
    }

    @Test(dataProvider = "textProvider")
    public void smokeTest(String expectedTitle) {
        HomePage homePage  = loadApplication();
        Assert.assertEquals(homePage.getTitleWordsText(), expectedTitle);
    }

    @Test
    public void pageObjectFunctionalTest() {
        HomePage homePage = loadApplication()
                .findByPlaceName("Kyiv");
    }

    @Test
    public void externalReaderTest() {
        System.out.printf(PlacesRepository.fromExcel("places.xlsx").get(2).getName());
    }

}
