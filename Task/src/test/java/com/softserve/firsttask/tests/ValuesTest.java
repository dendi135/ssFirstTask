package com.softserve.firsttask.tests;

import com.softserve.firsttask.data.PlacesRepository;
import com.softserve.firsttask.pages.SearchPlaceComponent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValuesTest extends TestRunner {

    @DataProvider(name = "valuesProvider")
    public Object[][] correctData() {
        return new Object[][]{
                {PlacesRepository.fromExcel().get(0).getName(),
                        PlacesRepository.fromExcel().get(0).getLatitude(),
                        PlacesRepository.fromExcel().get(0).getLongtitude()},
                {PlacesRepository.fromExcel().get(1).getName(),
                        PlacesRepository.fromExcel().get(1).getLatitude(),
                        PlacesRepository.fromExcel().get(1).getLongtitude()},
                {PlacesRepository.fromExcel().get(2).getName(),
                        PlacesRepository.fromExcel().get(2).getLatitude(),
                        PlacesRepository.fromExcel().get(2).getLongtitude()}
        };
    }

    @Test(dataProvider = "valuesProvider")
    public void checkValues(String expectedName, String expectedLat, String expectedLong) {
        SearchPlaceComponent searchPlaceComponent = loadApplication()
                .findByPlaceName(expectedName)
                .getGrayBoxComponent();
        Assert.assertEquals(searchPlaceComponent.getLatitudeValue(), expectedLat);
        Assert.assertEquals(searchPlaceComponent.getLongitudeValue(), expectedLong);
    }

}
