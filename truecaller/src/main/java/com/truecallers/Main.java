package com.truecallers;

import com.truecaller.ReadingFile;

import java.util.List;

public class Main {
    private static final String FILE = "C:\\Users\\eyuel\\Documents\\project\\java\\IdeaProjects\\truecaller\\src\\main\\java\\input.txt";
    private static List<String> inputs = List.of("XYvJEDjfk", "KAWJZBwA", "CFoItUS21b", "kpRI", "asdfxy", "kpRIk", "kpRIkml","eyu");

    public static void main(String[] args) {
        ReadingFile readFile = new ReadingFile();
        List<String> namesFromfile = readFile.readFromFile(FILE);

        Trie trie =  new Trie();
        for (String nameFromFile : namesFromfile){
            trie.insert(nameFromFile);
        }

        for(String str: inputs) {
            System.out.println(str + " -> " + trie.longestPrefix(str.toLowerCase()));
        }
    }
}
