package com.codecool.sqlyourcsv.utils.data_loader;

import com.codecool.sqlyourcsv.model.FileData;

import java.util.Map;

public interface DataLoader {

    void loadDataFromResources();
    Map<String, FileData> getData();
}
