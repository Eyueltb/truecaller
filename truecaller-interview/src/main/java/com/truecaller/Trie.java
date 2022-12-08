package com.truecaller;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.IntStream;

/**
 * To represent a prefix tree.
 * It stores strings characters, with root node represented by " " string
 * and all the descendants of a node have a common prefix
 */
public class Trie {

    private TrieNode root = new TrieNode((char) 0); //The root node is associated with empty string.

    /**
     *  Insert a word into the trie
     *
     * 1. Initialize: cur = root
     * 2. for each char c in target string S:
     * 3.      if cur does not have a child c:
     * 4.          cur.children[c] = new Trie node
     * 5.      cur = cur.children[c]
     * 6. cur is the node which represents the string S
     *
     */

    public void insert(String element) {
        AtomicReference<TrieNode> curr = new AtomicReference<>(root);

        IntStream.range(0, element.length()).forEach(i-> {
            HashMap<Character, TrieNode> child = curr.get().getChildren();
            char ch = element.charAt(i);
            if (child.containsKey(ch)) //If there is already a child
                curr.set(child.get(ch));
            else { // create a child
                TrieNode temp = new TrieNode(ch);
                child.put(ch, temp);
                curr.set(temp);
            }
        });
        curr.get().setEnd(true); //Set isEnd true for last character.
    }
    /**
     * 1. Initialize: cur = root
     * 2. for each char c in target string S:
     * 3.   if cur does not have a child c:
     * 4.     search fails
     * 5.   cur = cur.children[c]
     * 6. search successes
     */

    public String getMatchingPrefix(String input) {

        AtomicReference<String> result = new AtomicReference<>("");
        AtomicReference<TrieNode> curr = new AtomicReference<>(root);
        AtomicInteger prevMatch = new AtomicInteger();

        IntStream.range(0, input.length()).forEach(i-> {
            char ch = input.charAt(i);
            HashMap<Character, TrieNode> child = curr.get().getChildren(); //Current Trie node to traverse down

            // Check if there is a Trie edge for the current character, update result and
            if (child.containsKey(ch)) {
                result.updateAndGet(v -> v + ch); //update result
                curr.set(child.get(ch)); //Update curr to move down in Trie

                if (curr.get().isEnd()) //End of a word => update prevMatch
                    prevMatch.set(i + 1);
            }
            else
                return;
        });
        //Return previous matching prefix if the last processed character did not match end of a word.
        if (!curr.get().isEnd())
            return result.get().substring(0, prevMatch.get());

        else return result.get();
    }
}
