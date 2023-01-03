package tree;

/**
 * truth:talk is cheap, show me the code
 *
 * @author KC萧寒
 * @description
 * @createDate: 2022-05-05 08:15
 */

public class BinaryTreeDemo {
    public static void main(String[] args) {
        //创建二叉树
        BinaryTree tree = new BinaryTree();
        //创建二叉树的节点
        heroNode root = new heroNode(1, "黄茂荣");
        heroNode node2 = new heroNode(2, "叶子秋");
        heroNode node3 = new heroNode(3, "叶秋涵");
        heroNode node4 = new heroNode(4, "黄茂云");
        heroNode node5 = new heroNode(5, "黄歇");
       //创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        tree.setRoot(root);
        //测试三种遍历方式
        System.out.println("前序遍历：");
        tree.preOrder();
        System.out.println("中序遍历：");
        tree.infixOrder();
        System.out.println("后序遍历：");
        tree.postOrder();
        //测试三种查找方式
        System.out.println("前序查找：");
        heroNode res=tree.preOrderSeach(5);
        if(res!=null){
            System.out.printf("知道了该人物,编号为 no=%d,name=%s",res.getNo(),res.getName());
        }else{
            System.out.println("没有找到");
        }

        System.out.println("中序查找：");
        heroNode res2=tree.infixOrderSeach(5);
        if(res!=null){
            System.out.printf("知道了该人物,编号为 no=%d,name=%s",res2.getNo(),res2.getName());
        }else{
            System.out.println("没有找到");
        }
        System.out.println("后序查找：");
        heroNode res3=tree.postOrderSeach(5);
        if(res!=null){
            System.out.printf("知道了该人物,编号为 no=%d,name=%s",res3.getNo(),res3.getName());
        }else{
            System.out.println("没有找到");
        }
    }
}

class BinaryTree {
    private heroNode root;

    public void setRoot(heroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空无法遍历");
        }
    }

    //前序遍历查找
    public heroNode preOrderSeach(int no){
        if(root!=null){
            return root.preOrderSeach(no);
        }else{
            return null;
        }

    }
    //中序遍历查找
    public heroNode infixOrderSeach(int no){
        if(root != null){
            return root.infixOrderSeach(no);
        }else{
            return null;
        }
    }
    //后序遍历查找
    public heroNode postOrderSeach(int no){
        if(root != null){
            return root.postOrderSeach(no);
        }else{
            return null;
        }
    }
}


class heroNode {
    private int no;
    private String name;
    private heroNode left;
    private heroNode right;

    public heroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public heroNode getLeft() {
        return left;
    }

    public void setLeft(heroNode left) {
        this.left = left;
    }

    public heroNode getRight() {
        return right;
    }

    public void setRight(heroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "heroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        //递归遍历左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归遍历右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    //前序遍历查找

    /**
     *
     * @param no
     * @return
     */
    public heroNode preOrderSeach(int no) {
        System.out.println("进入前序查找");
        if(this.no == no) {
            return this;
        }
        heroNode res=null;
        if(this.left!=null){
            res=this.left.preOrderSeach(no);
        }
        if(res!=null){
            return res;
        }
        if(this.right!=null){
            res=this.right.preOrderSeach(no);
        }
        return res;
    }

    //中序遍历查找
    public heroNode infixOrderSeach(int no) {
        heroNode res=null;
        if (this.left != null) {
            res=this.left.infixOrderSeach(no);
        }
        if(res!=null){
            return res;
        }
        System.out.println("进入中序查找");
        if(this.no==no){
            return this;
        }
        if(this.right!=null){
            res=this.right.infixOrderSeach(no);
        }
        return res;
    }
    //后序遍历查找
    public heroNode postOrderSeach(int no) {
      heroNode res=null;
        if(this.left!=null){
            res=this.left.postOrderSeach(no);
        }
        if(res!=null){
            return res;
        }
        if(this.right!=null){
            res=this.right.postOrderSeach(no);
        }
        if(res!=null){
           return res;
        }
        System.out.println("进入后序查找");
        if(this.no==no){
            return this;
        }
        return res;
    }
}
