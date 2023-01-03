package com.bit.tree;

public class Demo {
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTree();
        bt.inOrder(root);
        System.out.println(" ");
        bt.postOrder(root);

    }
}
