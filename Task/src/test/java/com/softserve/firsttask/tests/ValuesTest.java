package com.softserve.firsttask.tests;

import com.softserve.firsttask.data.City;
import com.softserve.firsttask.data.PlacesRepository;
import com.softserve.firsttask.pages.SearchPlaceComponent;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class ValuesTest extends TestRunner {

    @DataProvider(name = "valuesProvider")
    public Iterator<Object[]> correctData() {
        Set<Object[]> list = new LinkedHashSet<>();
        for(City city : PlacesRepository.fromExcel()) {
            list.add((new Object[] {city.getName(), city.getLatitude(), city.getLongtitude()}));
        }
        return list.iterator();
    }

    @Test(dataProvider = "valuesProvider")
    public void checkValues(Object[] cityData) {
        SearchPlaceComponent searchPlaceComponent = loadApplication()
                .findByPlaceName(cityData[0].toString())
                .getGrayBoxComponent();
        Assert.assertEquals(searchPlaceComponent.getLatitudeValue(), cityData[1].toString());
        Assert.assertEquals(searchPlaceComponent.getLongitudeValue(), cityData[2].toString());
    }

}
