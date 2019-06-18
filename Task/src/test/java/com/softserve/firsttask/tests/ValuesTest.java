package com.softserve.firsttask.tests;

import com.softserve.firsttask.data.UserRepository;
import com.softserve.firsttask.pages.GrayBoxComponent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValuesTest extends TestRunner {

    @DataProvider(name = "valuesProvider")
    public Object[][] correctData() {
        return new Object[][]{
                {UserRepository.fromExcel().get(0).getName(),
                        UserRepository.fromExcel().get(0).getLatitude(),
                        UserRepository.fromExcel().get(0).getLongtitude()},
                {UserRepository.fromExcel().get(1).getName(),
                        UserRepository.fromExcel().get(1).getLatitude(),
                        UserRepository.fromExcel().get(1).getLongtitude()},
                {UserRepository.fromExcel().get(2).getName(),
                        UserRepository.fromExcel().get(2).getLatitude(),
                        UserRepository.fromExcel().get(2).getLongtitude()}
        };
    }

    @Test(dataProvider = "valuesProvider")
    public void checkValues(String expectedName, String expectedLat, String expectedLong) {
        GrayBoxComponent grayBoxComponent = loadApplication()
                .findByPlaceName(expectedName)
                .getGrayBoxComponent();
        Assert.assertEquals(grayBoxComponent.getLatitudeValue(), expectedLat);
        Assert.assertEquals(grayBoxComponent.getLongitudeValue(), expectedLong);
    }

}
