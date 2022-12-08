package com.truecaller;
import com.google.common.collect.Ordering;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingFile {

    public List<String> readFromFile(String fileName) {
        List<String> files = new ArrayList<>();
        long startTime = System.nanoTime();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            files = stream.map(String::toLowerCase)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("Time Difference old search "+ duration +" ms");

        startTime = System.nanoTime();
        List<String> test = Ordering.from(String.CASE_INSENSITIVE_ORDER)
                .sortedCopy(files);
        endTime = System.nanoTime();
        duration = (endTime - startTime)/1000000;  //divide by 1000000 to get milliseconds.
        System.out.println("Time Difference google-api search "+ duration +" ms");
        return test;
    }
}
