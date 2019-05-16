package com.codecool.sqlyourcsv.utils;

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

    private final String RESOURCES_FOLDER = "/main/resources/csv";
    private final String ACCESS_ERROR_MESSAGE = "Access denied!";
    private final String IO_ERROR_MESSAGE = "I/O operation failed!";
    private final String EMPTY_RESOURCES_MESSAGE = "No CSV files!";
    private List<String> resourceFilepaths;

    public CSVPathsLoader() {
        this.resourceFilepaths = new ArrayList<>();
        this.loadFilePathsFromResources();
        this.checkIfResourceFilePathsEmpty();
    }

    private void loadFilePathsFromResources() {
        try (Stream<Path> paths = Files.walk(Paths.get(this.RESOURCES_FOLDER))) {
            paths.filter(Files::isRegularFile)
                    .map(Path::toString)
                    .collect(Collectors.toCollection(() -> this.resourceFilepaths));
        } catch (SecurityException se) {
            this.addAndPrintMessage(this.resourceFilepaths, this.ACCESS_ERROR_MESSAGE);
            se.printStackTrace();
        } catch (IOException e) {
            this.addAndPrintMessage(this.resourceFilepaths, this.IO_ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void addAndPrintMessage(List<String> filePaths, String message) {
        filePaths.add(message);
        System.out.println(message);
    }

    private void checkIfResourceFilePathsEmpty() {
        if (this.resourceFilepaths.isEmpty()) {
            this.resourceFilepaths.add(this.EMPTY_RESOURCES_MESSAGE);
        }
    }

    List<String> getResourceNames() {
        return this.resourceFilepaths;
    }
}
