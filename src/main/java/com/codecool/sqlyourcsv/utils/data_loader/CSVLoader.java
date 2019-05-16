package com.codecool.sqlyourcsv.utils.data_loader;

import com.codecool.sqlyourcsv.model.FileData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class CSVLoader implements DataLoader {

    private final String FILE_NOT_FOUND_MESSAGE = "File %s not found!";
    private final CSVPathsLoader csvPathsLoader;
    private Map<String, FileData> data;

    @Autowired
    public CSVLoader(CSVPathsLoader csvPathsLoader) {
        this.csvPathsLoader = csvPathsLoader;
        this.loadDataFromResources();
    }

    @Override
    public void loadDataFromResources() {
        this.data = new HashMap<>();

        this.getResourceFilePaths().
                forEach(path -> this.data.put(
                        this.getFileName(path),
                        this.getFileData(path)));
    }

    private Stream<String> getResourceFilePaths() {
        return this.csvPathsLoader.getResourceFilePaths();
    }

    private String getFileName(String filePath) {
        String[] splittedPath = filePath.split("/");
        int lastNameIndex = splittedPath.length - 1;
        return splittedPath[lastNameIndex];
    }

    private FileData getFileData(String path) {
        FileData fileData = new FileData(this.getFileName(path));
        Iterator<String> lines = Objects.requireNonNull(getFileStream(path)).
                collect(Collectors.toList()).
                iterator();

        if(lines.hasNext()) {
            this.splitStream(lines.next()).forEach(fileData::addHeader);
        }
        lines.forEachRemaining(line -> fileData.addDataRow(this.splitStream(line)));
        return fileData;
    }

    private Stream<String> getFileStream(String path) {
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            return stream;
        } catch (IOException e) {
            System.out.println(String.format(this.FILE_NOT_FOUND_MESSAGE, path));
            e.printStackTrace();
        }
        return null;
    }

    private List<String> splitStream(String streamLine) {
        return Arrays.asList(streamLine.split(","));
    }

    @Override
    public Map<String, FileData> getData() {
        return this.data;
    }
}
