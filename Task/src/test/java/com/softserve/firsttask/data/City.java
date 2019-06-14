package com.softserve.firsttask.data;

import java.util.ArrayList;
import java.util.List;

public class City {
    
    private String name;
    private String latitude;
    private String longtitude;

    public City(String name, String latitude, String longtitude) {
        this.name = name;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    //

    public static City getByList(List<String> row) {
        return new City(row.get(0), row.get(1), row.get(2));
    }
    
    public static List<City> getByLists(List<List<String>> rows) {
        List<City> result = new ArrayList<>();
        if (!rows.get(0).get(3).contains("@")) {
            rows.remove(0);
        }
        for (List<String> currentRow : rows) {
            result.add(getByList(currentRow));
        }
        return result;
    }

}