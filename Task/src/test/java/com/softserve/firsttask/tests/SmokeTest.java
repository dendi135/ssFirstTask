package com.softserve.firsttask.tests;

import com.softserve.firsttask.data.PlacesRepository;
import com.softserve.firsttask.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SmokeTest extends TestRunner {

    @Test
    public void smokeTest() {
        HomePage homePage  = loadApplication();
        String expectedTitle = "Get Latitude and Longitude";
        Assert.assertEquals(homePage.getTitleWordsText(), expectedTitle);
    }

    @Test
    public void pageObjectFunctionalTest() {
        HomePage homePage = loadApplication()
                .findByPlaceName("Kyiv");
        String expectedLat = "50.447731";
        Assert.assertEquals(homePage.getGrayBoxComponent().getLatitudeValue(), expectedLat);
    }

    @Test
    public void externalReaderTest() {
        String expectedName = "Ivano-Frankivsk";
        Assert.assertEquals(PlacesRepository.fromExcel().get(2).getName(), expectedName);
    }

}
