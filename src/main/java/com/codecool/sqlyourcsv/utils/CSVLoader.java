package com.codecool.sqlyourcsv.utils;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CSVLoader implements DataLoader {

    private final String resourcesFolder = "/main/resources/csv";
    private final String accessErrorMessage = "Access denied!";
    private final String IOErrorMessage = "I/O operation failed!";
    private final String emptyResourcesMessage = "No CSV files!";
    private List<String> resourceFilepaths;
    private Map<String, ArrayList<ArrayList<String>>> data;

    public CSVLoader() {
        this.resourceFilepaths = this.getAllFilePathsFromResources();
        this.checkIfResourceFilePathsEmpty();
        this.loadDataFromResources();
    }

    private List<String> getAllFilePathsFromResources() {
        List<String> filePaths = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(Paths.get(this.resourcesFolder))) {
            return paths.filter(Files::isRegularFile)
                    .map(Path::toString)
                    .collect(Collectors.toCollection(() -> filePaths));
        } catch (SecurityException se) {
            filePaths.add(this.accessErrorMessage);
            System.out.println(this.accessErrorMessage);
            se.printStackTrace();
        } catch (IOException e) {
            filePaths.add(this.IOErrorMessage);
            System.out.println(this.IOErrorMessage);
            e.printStackTrace();
        }
        return filePaths;
    }

    private void checkIfResourceFilePathsEmpty() {
        if (this.resourceFilepaths.isEmpty()) {
            this.resourceFilepaths.add(this.emptyResourcesMessage);
        }
    }

    @Override
    public void loadDataFromResources() {
        Map<String, ArrayList<ArrayList<String>>> data = new HashMap<>();
    }

    @Override
    public List<String> getResourceNames() {
        return this.resourceFilepaths;
    }

    @Override
    public Map<String, ArrayList<ArrayList<String>>> getData() {
        return this.data;
    }
}
