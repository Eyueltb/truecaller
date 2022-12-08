package com.truecaller;

import lombok.Data;

import java.util.HashMap;

/**
 * This class represent the Node with its value and its children(each node might have several children).
 * Represent a string(a prefix).
 */
@Data
public class TrieNode {
    private char value;
    private HashMap<Character, TrieNode> children; // to store children node
    private boolean isEnd;

    public TrieNode(char ch) {
        value = ch;
        children = new HashMap<>();
        isEnd = false;
    }
}
