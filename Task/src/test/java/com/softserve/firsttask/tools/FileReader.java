package com.softserve.firsttask.tools;

import java.util.List;

public abstract class FileReader implements ExternalReader {
    protected final String PATH_SEPARATOR = "/";
    protected String filename;
    protected String path;

    public FileReader(String filename) {
        this.filename = filename;
        this.path = this.getClass().getResource(PATH_SEPARATOR + filename).getPath();
    }
    
    public String getFilename() {
        return this.filename;
    }

    public String getPath() {
        return this.path;
    }

    @Override
    public List<List<String>> getAllCells() {
        return getAllCells(path);
    }
}