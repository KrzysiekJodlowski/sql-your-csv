package com.codecool.sqlyourcsv.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CSVLoader implements DataLoader {

    private final CSVPathsLoader csvPathsLoader;
    private Map<String, ArrayList<ArrayList<String>>> data;

    @Autowired
    public CSVLoader(CSVPathsLoader csvPathsLoader) {
        this.csvPathsLoader = csvPathsLoader;
        this.loadDataFromResources();
    }

    @Override
    public void loadDataFromResources() {
        Map<String, ArrayList<ArrayList<String>>> data = new HashMap<>();
    }

    @Override
    public List<String> getResourceNames() {
        return this.csvPathsLoader.getResourceNames();
    }

    @Override
    public Map<String, ArrayList<ArrayList<String>>> getData() {
        return this.data;
    }
}
