package com.codecool.sqlyourcsv.utils;

import com.codecool.sqlyourcsv.model.FileData;

import java.util.Map;
import java.util.stream.Stream;

public interface DataLoader {

    void loadDataFromResources();
    Map<String, FileData> getData();
}
