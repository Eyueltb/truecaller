package com.truecaller;

import java.util.List;

public class Main {
    private static final String FILE = "C:\\Users\\eyuel\\Documents\\project\\java\\IdeaProjects\\truecaller\\src\\main\\java\\com\\truecaller\\input.txt";
    public static void main(String[] args) {
        ReadingFile readFile = new ReadingFile();
        List<String> namesFromfile = readFile.readFromFile(FILE);
        System.out.println(namesFromfile.size());
        Tree tree = new Tree();
        for (String nameFromFile : namesFromfile){
            tree.add(nameFromFile);
        }

    }
}
