package com.bit.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

 

    /**
     * 创建一棵二叉树 返回这棵树的根节点
     *
     * @return
     */
    public TreeNode createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        TreeNode I = new TreeNode('I');
        TreeNode K = new TreeNode('K');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        D.right = G;
        E.left = H;
        C.left = F;
        F.right = I;
        I.left = K;
        return A;
    }

    // 前序遍历
    public void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历
    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    // 后序遍历
    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static int ListNodeSize;

    /**
     * 获取树中节点的个数：遍历思路
     */
    public void size(TreeNode root) {
        if (root == null) {
            return;
        }
        this.ListNodeSize++;
        size(root.left);
        size(root.right);
    }

    /**
     * 获取节点的个数：子问题的思路
     *
     * @param root
     * @return
     */
    public int size2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }


    /*
     获取叶子节点的个数：遍历思路
     */
    public static int leafSize = 0;

    public void getLeafListNodeCount1(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafSize++;
        }
        getLeafListNodeCount1(root.left);
        getLeafListNodeCount1(root.right);
    }

    /*
     获取叶子节点的个数：子问题
     */
    public int getLeafListNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafListNodeCount2(root.left) + getLeafListNodeCount2(root.right);
    }

    /*
    获取第K层节点的个数
     */
    public int getKLevelListNodeCount(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return getKLevelListNodeCount(root.left, k - 1) + getKLevelListNodeCount(root.right, k - 1);
    }

    /*
     获取二叉树的高度
     时间复杂度：O(N)
     */
    public int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftTree = getHeight(root.left);
        int rightTree = getHeight(root.right);
        return (leftTree > rightTree ? leftTree + 1 : rightTree + 1);
    }


    // 检测值为dataue的元素是否存在
    public TreeNode find(TreeNode root, char data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            return root;
        }
        TreeNode ret1 = find(root.left, data);
        if (ret1 != null) {
            return ret1;
        }
        TreeNode ret2 = find(root.right, data);
        if (ret2 != null) {
            return ret2;
        }
        return null;
    }

    //层序遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.data + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }


    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur != null) {
                queue.offer(cur.left);
                queue.offer(cur.right);
            } else {
                break;
            }
        }
        while (!queue.isEmpty()) {
            TreeNode cur = queue.peek();
            if (cur != null) {
                return false;
            } else {
                queue.poll();
            }
        }
        return true;
    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.data > high) {
            return rangeSumBST(root.left, low, high);
        }

        if (root.data < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.data + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    /**
     * 二叉树的镜像
     *
     * @param root
     * @return
     */
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }

        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

}