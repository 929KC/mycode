package com.offer.tree;

import com.bit.tree.BinarySearchTree;
import com.bit.tree.TreeNode;

import java.util.*;

public class BuildBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bs = new BinarySearchTree();
        bs.insert(3);
        bs.insert(1);
        bs.insert(2);
        bs.insert(4);
        bs.inOrder(bs.root);
        int i = kthSmallest(bs.root, 1);
        System.out.println(i);
        System.out.println(bs.root.data);
        System.out.println(bs.root.left.data);
        System.out.println(bs.root.left.right.data);
        System.out.println(bs.root.right.data);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return  buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    //重建二叉树
    public TreeNode buildTree(int [] preorder,int preStart,int preEnd,int [] inorder,int inStart,int inEnd){
        //递归出口
        if (preStart>preEnd||inStart>inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        //寻找中序遍历中的根节点的位置
        int index  = 0;
        for (int i=0;i<inorder.length;i++) {
            if (preorder[preStart]==inorder[i]) {
                index = i;
                break;
            }
        }
        int leftSize = index -inStart;
        //构建左子树
        root.left = buildTree(preorder,preStart+1,preStart+leftSize,inorder,inStart,index-1);
        //构建右子树
        root.right = buildTree(preorder,preStart+leftSize+1,preEnd,inorder,index+1,inEnd);
        return root;
    }

    /**
     * 二叉树的子树
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null ||B==null) {
            return false;
        }
        boolean result = false;
        //起始位置
        if (A.val==B.val) {
            result = IsSameFromBegin(A,B);
        }
        if(result!=true) {
            result = isSubStructure(A.left,B);
        }
        if (result!=true) {
            result = isSubStructure(A.right,B);
        }
        return result;
    }

    public boolean IsSameFromBegin(TreeNode root1,TreeNode root2) {
        if (root2==null) {//root2树已遍历完
            return true;
        }
        if (root1==null) {//root1树已遍历完
            return false;
        }
        if (root1.val!=root2.val) {
            return false;
        }
        return IsSameFromBegin(root1.left,root2.left)&&IsSameFromBegin(root1.right,root2.right);
    }

    /**
     * 层序遍历
     * 将头节点加入到队列
     * 头节点出队
     * 将头节点值加入到list
     * 判断头节点的左子树和右子树是否为空,不为空则入队
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root==null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode father = queue.poll();
            list.add(father.data);
            if (father.left!=null) {
                queue.offer(father.left);
            }
            if (father.right!=null) {
                queue.offer(father.right);
            }
        }
        return list;
    }

    /**
     * 二叉搜索树的后序遍历序列
     * 搜索二叉树的遍历特点
     * 前序:三个有序序列
     * 后序:,前一段序列的值小于root.val，后一段序列大于root.val
     * 中序:升序序列
     * 判断整个序列是否满足条件
     * 判断左右子树是否满足条件
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length==0) {
            return true;
        }
        return VerifySquenceOfBSTCore(postorder,0,postorder.length-1);
    }

    public boolean VerifySquenceOfBSTCore(int [] postorder,int start,int end){
        if (start>=end) {
            return true;
        }
        //拿到根节点
        int root = postorder[end];
        int i = start;
        //划分范围
        //左子树
        while (i<end&&postorder[i]<root) {
            i++;
        }
        //右子树
        for (int j = i;j<end;j++) {
            if (postorder[j]<root) {
                return false;
            }
        }
        return VerifySquenceOfBSTCore(postorder,start,i-1)&&VerifySquenceOfBSTCore(postorder,i,end-1);
    }

    /**
     * 二叉树中和为某一值的路径
     * 回溯法
     * 1.先添加值 待选结果
     * 2.在判断现有结果是否满足条件 待选结果是否符合条件
     * 3.DFS 深度优先
     * 4.回退 检测下一个
     * @param root
     * @param expectNumber
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list = new ArrayList<>();
        FindPathDFS(root,expectNumber,res,list);
        return res;
    }
    public void FindPathDFS(TreeNode root, int target,
                            ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list) {
        if (root==null) {
            return;
        }
        list.add(root.data);
        target-=root.data;
        if (target==0&&root.left==null&&root.right==null) {
            result.add(new ArrayList<>(list));
        }
        FindPathDFS(root.left,target,result,list);
        FindPathDFS(root.right,target,result,list);
        list.remove(list.size()-1);
    }

    /**
     * 二叉树搜索树第K个小的元素
     * @param root
     * @param k
     * @return
     */
    public static int kthSmallest(TreeNode root, int k) {
        if (root==null||k<=0) {
            return -1;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        do{
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                k--;
                if (k==0) {
                    return node.data;
                }
                node = node.right;
            }
        }while (node!=null||!stack.isEmpty());
        return -1;
    }
}
