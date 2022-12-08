package com.truecaller;

import lombok.Data;

import java.util.Objects;

@Data
public class TreeNode {
    private String item; // Actual prefix eg-tru
    private Children children;

    public TreeNode() {
        this.item = null;
        this.children = null;
    }
    public TreeNode(String item) {
        this.item = item;
        this.children = null;
    }

    public boolean setItem(String newItem) {
        if(this.children == null){
            this.children = new Children();
        }
        if (this.item == null) {
            this.item = newItem;
            return true;
        } else if (newItem.startsWith(this.item) && !newItem.equals(this.item)){
            return children.add(newItem);
        } else if(newItem.equals(this.item)){
            return true;
        }
        else {
            return false;
        }
    }

    public String getLongestString(String input) {
        //check if it matches the current root   if(input.startsWith(item)) children.search(item)
        // if yes check in children
        // if no return the current node
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;
        TreeNode that = (TreeNode) o;
        return getItem().equals(that.getItem());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItem());
    }
}
