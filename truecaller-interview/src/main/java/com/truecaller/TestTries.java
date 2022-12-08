package com.truecaller;

import java.util.List;

public class TestTries {
    private static final String FILE = "C:\\Users\\eyuel\\Documents\\project\\java\\IdeaProjects\\truecaller-interview\\src\\main\\java\\input.txt";
    private static String input = "CFWqpA12";

    public static void main(String[] args) {
        ReadFile readFile = new ReadFile();
        List<String> namesFromfile = readFile.readFromFile(FILE);

        Trie tries = new Trie();
        for (String str : namesFromfile) {
            tries.insert(str);
        }

        System.out.println(tries.getMatchingPrefix(input.toLowerCase()));
    }
}
