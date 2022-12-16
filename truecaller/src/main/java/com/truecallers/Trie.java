package com.truecallers;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root = new TrieNode();

    String longestPrefix(String word) {
        TrieNode curr = root;
        String s ="";
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children.get(c) == null) {
                return s;
            }
            s+=c;
            curr = curr.children.get(c);
        }
        return word;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children.get(c) == null) {
                // no children -> insert a new node if the path does not exist
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
    }
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return search(prefix);
    }
    @Data
    private class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
    }
}
