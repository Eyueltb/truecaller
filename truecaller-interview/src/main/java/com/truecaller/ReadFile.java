package com.truecaller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * To read file, map to lowercase, sort and store in a list
 */
public class ReadFile {

    public List<String> readFromFile(String fileName) {
        List<String> sortedFiles = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            sortedFiles = stream.distinct().map(String::toLowerCase).sorted().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sortedFiles;
    }
}
