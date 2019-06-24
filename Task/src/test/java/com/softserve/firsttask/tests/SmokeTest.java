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
        String expectedTitle = iniReader.getValueAsString("inscriptions", "ins_1");
        Assert.assertEquals(homePage.getTitleWordsText(), expectedTitle);
    }

    @Test
    public void pageObjectFunctionalTest() {
        HomePage homePage = loadApplication()
                .findByPlaceName(iniReader.getValueAsString("cities", "kyiv"));
        String expectedLat = iniReader.getValueAsString("coordinates", "coord_1");
        Assert.assertEquals(homePage.getGrayBoxComponent().getLatitudeValue(), expectedLat);
    }

    @Test
    public void externalReaderTest() {
        String expectedName = iniReader.getValueAsString("cities", "if");
        Assert.assertEquals(PlacesRepository.fromExcel().get(2).getName(), expectedName);
    }

}
