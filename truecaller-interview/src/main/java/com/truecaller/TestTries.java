package com.truecaller;

import java.util.List;

public class TestTries {
    private static final String FILE = "C:\\Users\\eyuel\\Documents\\project\\java\\IdeaProjects\\truecaller-interview\\src\\main\\java\\input.txt";
    private static List<String> inputs = List.of("XYvJEDjfk", "KAWJZBwA", "CFoItUS21b", "kpRI", "asdfxy", "kpRIk", "kpRIkml", "eyu");

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<String> namesFromfile = readFile.readFromFile(FILE);

        Trie tries = new Trie();
        for (String str : namesFromfile) {
            tries.insert(str);
        }
        for (String input : inputs) {
            System.out.println(input.toLowerCase() + " -> " + tries.getMatchingPrefix(input.toLowerCase()));
       }
    }
}
