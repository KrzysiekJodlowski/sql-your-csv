package com.codecool.sqlyourcsv.service;

import com.codecool.sqlyourcsv.utils.data_loader.DataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataService {

    private DataLoader dataLoader;

    @Autowired
    public DataService(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }
}
