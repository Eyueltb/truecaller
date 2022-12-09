package com.truecaller;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MatchingLongestPrefixTest {

    private Trie trie;
    private static final String FILE = "C:\\Users\\eyuel\\Documents\\project\\java\\IdeaProjects\\truecaller\\src\\main\\java\\input.txt";
    private static List<String> inputs = List.of("XYvJEDjfk", "KAWJZBwA", "CFoItUS21b", "kpRI", "asdfxy", "kpRIk", "kpRIkml","eyu");
    ReadFile readFile = null;
    List<String> namesFromfile = null;

    @BeforeEach
    void setUp() {
        readFile = new ReadFile();
        trie = new Trie();
    }
    @Test
    void test_Longest_prefix_success(){
        //Given
        namesFromfile = readFile.readFromFile(FILE);
        //When
        for (String nameFromFile : namesFromfile){
            trie.insert(nameFromFile);
        }
        final List<String> data = inputs.stream().map(String::toLowerCase).collect(Collectors.toList());
        //Assert
        assertEquals("xyvjed", trie.getMatchingPrefix(data.get(0)));
        assertEquals("kawjzbwa", trie.getMatchingPrefix(data.get(1)));
        assertEquals("cfoitus2", trie.getMatchingPrefix(data.get(2)));
        assertEquals("kprik", trie.getMatchingPrefix(data.get(5)));
        assertNotNull(trie.getMatchingPrefix(data.get(5)));

        assertEquals(5, trie.getMatchingPrefix(data.get(5)).length());
        assertEquals(0, trie.getMatchingPrefix(data.get(7)).length());
    }


}
