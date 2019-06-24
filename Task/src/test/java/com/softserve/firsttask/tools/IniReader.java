package com.softserve.firsttask.tools;

import org.ini4j.Wini;

import java.io.File;
import java.io.IOException;

public class IniReader {

    private String filePath;

    public IniReader(String filePath) {
        this.filePath = filePath;
    }

    public String getValueAsString(String section, String value) {
        Wini ini = null;
        try {
            ini = new Wini(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ini.get(section, value, String.class);
    }

    public int getValueAsInt(String section, String value) {
        Wini ini = null;
        try {
            ini = new Wini(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ini.get(section, value, int.class);
    }

    public double getValueAsDouble(String section, String value) {
        Wini ini = null;
        try {
            ini = new Wini(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ini.get(section, value, double.class);
    }

}
