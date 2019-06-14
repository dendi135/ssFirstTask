package com.softserve.firsttask.data;

import java.util.List;

import com.softserve.firsttask.tools.ExcelReader;

public final class UserRepository {

   private UserRepository() {
   }

   public static City getKyiv() {
      return new City("Kyiv", "50.450100", "30.523400");
   }

   public static City getLviv() {
      return new City("Lviv", "49.839683", "24.029717");
   }

    public static City getIvanoFrankivsk() {
        return new City("Ivano-Frankivsk", "48.922633", "24.711117");
    }

//

    public static List<City> fromExcel(String filename) {
        return City.getByLists(new ExcelReader(filename).getAllCells());
    }

    public static List<City> fromExcel() {
        return fromExcel("places.csv");
    }
}