package com.codecool.sqlyourcsv.utils;

import com.codecool.sqlyourcsv.model.FileData;

import java.util.List;
import java.util.Map;

public interface DataLoader {

    void loadDataFromResources();
    List<String> getResourceNames();
    Map<String, FileData> getData();
}
