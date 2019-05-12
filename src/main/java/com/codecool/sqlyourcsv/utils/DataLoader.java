package com.codecool.sqlyourcsv.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface DataLoader {

    void loadDataFromResources();
    List<String> getResourceNames();
    Map<String, List<List<String>>> getData();
}
