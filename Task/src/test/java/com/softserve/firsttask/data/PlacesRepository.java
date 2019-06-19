package com.softserve.firsttask.data;

import java.util.List;

import com.softserve.firsttask.tools.ExcelReader;

public final class PlacesRepository {

    private static final String FILE_NAME = "places.xlsx";

   private PlacesRepository() {
   }

    public static List<City> fromExcel(String filename) {
        return City.getByLists(new ExcelReader(filename).getAllCells());
    }

    public static List<City> fromExcel() {
        return fromExcel(FILE_NAME);
    }
}