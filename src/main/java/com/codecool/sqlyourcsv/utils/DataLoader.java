package com.codecool.sqlyourcsv.utils;

import java.util.ArrayList;
import java.util.Map;

public interface DataLoader {

    Map<String, ArrayList<ArrayList<String>>> loadDataFromResources();
}
