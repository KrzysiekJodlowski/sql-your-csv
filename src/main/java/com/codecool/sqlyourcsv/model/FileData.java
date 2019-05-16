package com.codecool.sqlyourcsv.model;

import java.util.ArrayList;
import java.util.List;

public class FileData {

    private String fileName;
    private List<String> dataHeaders;
    private List<List<String>> dataRows;

    public FileData(String fileName) {
        this.fileName = fileName;
        this.dataHeaders = new ArrayList<>();
        this.dataRows = new ArrayList<>();
    }

    public void addHeader(String header) {
        this.dataHeaders.add(header);
    }

    public List<String> getDataHeaders() {
        return this.dataHeaders;
    }

    public void addDataRow(List<String> dataRow) {
        this.dataRows.add(dataRow);
    }

    public List<List<String>> getDataRows() {
        return this.dataRows;
    }
}
