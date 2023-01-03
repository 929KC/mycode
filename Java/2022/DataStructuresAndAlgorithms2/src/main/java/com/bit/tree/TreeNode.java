package com.bit.tree;

public class TreeNode {
    public int data;
    public TreeNode left;//左孩子的引用
    public TreeNode right;//右孩子的引用
    public char val;
    public TreeNode(int  data) {
        this.data = data;
    }
    public TreeNode(char val) {
        this.val = val;
    }
}
