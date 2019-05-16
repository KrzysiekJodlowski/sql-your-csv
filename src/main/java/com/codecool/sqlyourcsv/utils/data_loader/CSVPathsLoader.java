package com.codecool.sqlyourcsv.utils.data_loader;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CSVPathsLoader {

    private final String RESOURCES_FOLDER = "/home/krzysiek/Advanced/4rd_week/fp/sql-your-csv/src/main/resources/csv";
    private final String ACCESS_ERROR_MESSAGE = "Access denied!";
    private final String IO_ERROR_MESSAGE = "I/O operation failed!";
    private final String EMPTY_RESOURCES_MESSAGE = "No CSV files!";
    private List<String> resourceFilePaths;

    public CSVPathsLoader() {
        this.resourceFilePaths = new ArrayList<>();
        this.loadFilePathsFromResources();
        this.checkIfResourceFilePathsEmpty();
    }

    private void loadFilePathsFromResources() {
        try (Stream<Path> paths = Files.walk(Paths.get(this.RESOURCES_FOLDER))) {
            paths.filter(Files::isRegularFile)
                    .map(Path::toString)
                    .collect(Collectors.toCollection(() -> this.resourceFilePaths));
        } catch (SecurityException se) {
            this.addAndPrintMessage(this.resourceFilePaths, this.ACCESS_ERROR_MESSAGE);
            se.printStackTrace();
        } catch (IOException e) {
            this.addAndPrintMessage(this.resourceFilePaths, this.IO_ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void addAndPrintMessage(List<String> filePaths, String message) {
        filePaths.add(message);
        System.out.println(message);
    }

    private void checkIfResourceFilePathsEmpty() {
        if (this.resourceFilePaths.isEmpty()) {
            this.resourceFilePaths.add(this.EMPTY_RESOURCES_MESSAGE);
        }
    }

    public Stream<String> getResourceFilePaths() {
        return this.resourceFilePaths.stream();
    }
}
