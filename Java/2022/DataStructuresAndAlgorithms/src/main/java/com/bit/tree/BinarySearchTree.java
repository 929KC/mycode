package com.bit.tree;

/**
 * truth:talk is cheap, show me the code
 * @author KC萧寒
 * @description
 * @createDate: 2022-07-20 11:02
 */

public class BinarySearchTree {

//    static class TreeNode{
//        private TreeNode left;
//        private TreeNode right;
//        private int data;
//
//        public TreeNode(int data){
//          this.data = data;
//        }
//    }

   public  TreeNode root;
    /**
     * 查找key是否存在于二插搜索树中
     * @param key
     * @return
     */
    public TreeNode search(int key){
        TreeNode cur=root;
        while (cur!=null){
            if(cur.data>key){
                cur=cur.right;
            }else if(cur.data<key){
                cur=cur.left;
            }else{
                return cur;
            }
        }
        return null;
    }
    /**
     * 插入元素
     */
    public   boolean insert(int key){
        TreeNode ListNode=new TreeNode(key);
        if(root==null){
            root= ListNode;
            return true;
        }
        TreeNode cur=root;
        TreeNode parent = null;
        while (cur!=null){
            if (cur.data>key){
                parent = cur;
                cur = cur.left;
            }else if(cur.data<key){
                parent = cur;
                cur = cur.right;
            }else {
                return false;
            }
        }
        if(parent.data>key){
            parent.left= ListNode;
        }else{
           parent.right = ListNode;
        }
        return true;
    }


    /**
     * 删除节点
     * @param key
     */
    public void remove(int key){
            TreeNode cur = root;
            TreeNode parent = null;
            while(cur!=null){
                if(cur.data>key){
                    parent = cur;
                    cur = cur.left;
                }else if(cur.data<key){
                    parent = cur;
                    cur = cur.right;
                }else{
                    removeListNode(parent,cur);
                    return;
                }
            }
    }

    public void removeListNode(TreeNode parent,TreeNode cur){
            if(cur.left==null){
                if(cur==root){
                    root = cur.right;
                }else if(cur == parent.left){
                    parent.left = cur.right;
                }else{
                    parent.right = cur.right;
                }
            }else if(cur.right==null){
                if(cur==root){
                    root = cur.left;
                }else if(cur==parent.left){
                    parent.left = cur.left;
                }else{
                    parent.right = cur.left;
                }
            }else{
               TreeNode targetParent = cur;
               TreeNode target = cur.right;
               while (target.left!=null){
                   targetParent = target;
                   target = target.left;
               }
                cur.data = target.data;
               if (targetParent.left == target){
                   targetParent.left = target.right;
               }else{
                   targetParent.right = target.right;
               }
            }
    }

    public static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
}
