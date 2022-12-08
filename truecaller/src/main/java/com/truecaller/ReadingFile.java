package com.truecaller;
import com.google.common.collect.Ordering;
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
public class ReadingFile {

    public List<String> readFromFile(String fileName) {
        List<String> files = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            files = stream.map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
       return files;
    }
}
