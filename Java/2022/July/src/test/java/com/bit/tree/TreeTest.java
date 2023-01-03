package com.bit.tree;

import org.junit.Test;
/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-12 20:03
 */

public class TreeTest {
    @Test
    public void BinaryTreeTest() {
        BinaryTree bt = new BinaryTree();
        BinaryTree.TreeNode root = bt.createTree();
        System.out.print("前序遍历:");
        bt.preOrder(root);
        System.out.println();
        System.out.print("中序遍历:");
        bt.inOrder(root);
        System.out.println();
        System.out.print("后序遍历:");
        bt.postOrder(root);
        System.out.println();
        System.out.println("节点个数:" + bt.size2(root));
        bt.size(root);
        System.out.println("节点个数:" + bt.nodeSize);
        System.out.println("叶子个数:" + bt.getLeafNodeCount2(root));
        bt.getLeafNodeCount1(root);
        System.out.println("叶子个数:" + bt.leafSize);
        System.out.println("获取第k层节点的个数:" + bt.getKLevelNodeCount(root, 3));
        System.out.println("树的高度:" + bt.getHeight(root));
        System.out.println("查找元素:" + bt.find(root, 'D').val);
        System.out.print("层序遍历:");
        bt.levelOrder(root);
        System.out.println();
        System.out.print("判断是否为完全二叉树:");
        System.out.println(bt.isCompleteTree(root));
        System.out.print("二叉树的镜像:");
        bt.mirrorTree(root);
        System.out.print("前序遍历:");
        bt.preOrder(root);
    }

    @Test
    public void testBinarySearchTree(){
        BinarySearchTree bs=new BinarySearchTree();
        int[] array = {80,30,48,60,90,56};
        for (int i = 0; i < array.length; i++) {
          bs.insert(array[i]);
        }
        bs.remove(80);
        bs.remove(56);
        bs.inOrder(bs.root);
    }

}
