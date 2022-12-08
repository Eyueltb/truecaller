package com.truecaller;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private List<TreeNode> roots = new ArrayList<>();

    public void add(String item) {
        if (roots.isEmpty()) {
            roots.add(new TreeNode(item));
            return;
        }
        for (TreeNode root : roots) {
            if (root.setItem(item)) { //already set
                return;
            }
        }
        TreeNode treeNode = new TreeNode(item);
        roots.add(treeNode);
    }

    public String search(String input) {
        for (TreeNode root : roots) {
            final String longestString = root.getLongestString(input);
            if (longestString != null) {
                return longestString;
            }
        }
        return null;
    }
}
