package com.truecaller;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Children {
    private Set<TreeNode> siblings;
    public Children() {
        this.siblings = new HashSet<>();
    }

    public boolean add(String newItem) {
        if(siblings.contains(new TreeNode(newItem))){ // check if item contains in a set
            return true;
        }
        //For children
        for(TreeNode sibling : siblings ) {
            if(newItem.startsWith(sibling.getItem())) {
                return sibling.setItem(newItem);
            }
        }
        //For siblings
        TreeNode treeNode = new TreeNode(newItem);
        siblings.add(treeNode);
        return true;
    }

    public String getLongestString(String input, String item) {
        for(TreeNode sibling : siblings){
            if(sibling.getLongestString(input) != null) {
                return sibling.getLongestString(input);
            }
        }
        return item;
    }
}
