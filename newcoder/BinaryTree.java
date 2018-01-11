package newcoder;

import com.sun.deploy.net.proxy.StaticProxyManager;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 二叉树
 * Created by sonny on 2017/12/15.
 */

class TreeNode{

    Integer value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TreeNode)) return false;

        TreeNode node = (TreeNode) o;

        if (value != null ? !value.equals(node.value) : node.value != null) return false;
        if (left != null ? !left.equals(node.left) : node.left != null) return false;
        return right != null ? right.equals(node.right) : node.right == null;
    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (left != null ? left.hashCode() : 0);
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    TreeNode left;
    TreeNode right;

    public TreeNode(Integer value){
        this.value=value;
    }

    public TreeNode(){
    }


}
public class BinaryTree {

    private BinaryTree() {

    }

    /**
     * 问题难点：最左节点怎么获取
     * @param root
     * @param leftNode
     */
    static  void prePrintEdgeNodeReverse(TreeNode root,TreeNode leftNode){
        if(root==null)
            return;
        if(leftNode==null)
            System.out.println(root.value);
        else{
            if(leftNode.left==null&&leftNode.right==null
                    &&root.left==null&&root.right.right==null)
                System.out.println(root.value);
        }

    }


    /**
     * 先序遍历递归版(非递归版在栈和队列一章中)
     * @param root
     */
    static  void preTraverse(TreeNode root){
        if(root==null)
            return;
        System.out.println(root.value);
        preTraverse(root.left);
        preTraverse(root.right);
    }

    /**
     * 二叉树序列化
     * @param root
     * @param str
     * @return
     */
    static  StringBuffer preTraverseSeri(TreeNode root,StringBuffer str){
        if(root==null)
            return str.append("#!");
        str.append(root.value+"!");
        preTraverseSeri(root.left,str);
        preTraverseSeri(root.right,str);
        return str;
    }

    static  void midTraverse(TreeNode root){
        if(root==null)
            return;
        midTraverse(root.left);
        System.out.println(root.value);
        midTraverse(root.right);
    }

    /**
     * 中序遍历非递归版
     * -要想输出左根右的顺序，先将根左节点逆序压栈，
     * -直到左节点为空，弹出栈里面的节点，开始遍历右节点，重复上面步骤
     * -若栈为空和遍历结点为null，则结束
     *  原理为通过栈的入出实现函数的递归
     * @param root
     */
    static void recurMidTraverse(TreeNode root){
        Stack<TreeNode> stack=new Stack<TreeNode>();
        if(root==null)
            return;
        while(!stack.isEmpty()||root!=null){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }else{
                TreeNode popNode=stack.pop();
                System.out.println(popNode.value);
                root=popNode.right;
            }
        }
    }

    static  void postTraverse(TreeNode root){
        if(root==null)
            return;
        postTraverse(root.left);
        postTraverse(root.right);
        System.out.println(root.value);
    }

    /**
     * 原理
     * 增加一个栈b;
     * 概述：栈a进左右，进栈b为右左，最后栈b可以左右输出
     * @param root
     */
    static  void recurPostTraverse(TreeNode root){
        if(root==null)
            return;
    }


    /**
     * 层序遍历
     * 利用队列先进先出性质,函数栈的特点
     * @param root
     */
    static void levelTraverse(TreeNode root){

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.add(root);
        TreeNode node=null;
        boolean b=false;
        while (!queue.isEmpty()){
            node=queue.poll();
            System.out.println(node.value);
            if(node.left!=null)
            queue.add(node.left);
            if(node.right!=null)
            queue.add(node.right);
        }
    }

    /**
     * 按格式打印二叉树
     * 原理：在用队列添加每层的最右节点时nextLast，此时弹出的节点是上一层的最右节点last。
     * 因此从第二层开始从左到右入队的节点就被nextLast指向，直到弹出的节点是上一层的最右节点last，此时更新（
     * last=nextLast）
     * 
     * @param root
     */
    static  void printTreeAsFormated(TreeNode root){
        Queue<TreeNode> nodesQueue=new LinkedList<TreeNode>();
        nodesQueue.add(root);
        TreeNode last=root;
        TreeNode nextlast=null;
          while (!nodesQueue.isEmpty()){
              TreeNode node1=nodesQueue.poll();
              System.out.print(node1.value);
              if(node1.left!=null){
                  nextlast=node1.left;
                  nodesQueue.add(node1.left);
              }
              if(node1.right!=null){
                  nextlast=node1.right;
                  nodesQueue.add(node1.right);
              }
              if(node1==last){
                  System.out.println();
                  last=nextlast;
              }

          }
    }

    /**
     * 先序遍历序列化二叉树
     * @param root
     * @return
     */
    static  String serializeBTree(TreeNode root){
        StringBuffer resStr=new StringBuffer();
        resStr=preTraverseSeri(root,resStr);
        return resStr.toString();
    }

    static  TreeNode preCreateBTree(String a[],TreeNode root,TreeNode preNode,TreeNode childNode,boolean isLeft){
        if(a[pos].equals("#")){
            if(isLeft)
                preNode.left=null;
            else
                preNode.right=null;
            return null;
        }
        preNode=childNode==null?preNode:childNode;
        preNode.value=Integer.valueOf(a[pos++]);
        TreeNode leftNode=new TreeNode();
        preNode.left=leftNode;
        preCreateBTree(a,root,preNode,leftNode,true);

        pos++;
        TreeNode rightNode=new TreeNode();
        preNode.right=rightNode;
        preCreateBTree(a,root,preNode,rightNode,false);
        return root;
    }

    static int pos=0;
    static  TreeNode deserializeBTree(String str){
        String[] a=str.split("!");
        TreeNode node=new TreeNode();
        TreeNode res=preCreateBTree(a,node,node,null,false);
        return res;
    }


    public  static  void  main(String[] args){
        TreeNode t1=new TreeNode();
        t1.value=1;
        TreeNode t2=new TreeNode();
        t2.value=2;
        TreeNode t3=new TreeNode();
        t3.value=3;
        t1.left=t2;t1.right=t3;
        TreeNode t4=new TreeNode();
        t4.value=4;
        t2.left=t4;
        //levelTraverse(t1);
        //preTraverse(t1);
        //StackAndQueueUtil.dfsBTree(t1);
/*        midTraverse(t1);
        recurMidTraverse(t1);*/
        //postTraverse(t1);
        printTreeAsFormated(t1);
        //System.out.println(serializeBTree(t1));
/*        TreeNode t5=new TreeNode();
        String serialStr="1!2!4!#!#!#!3!#!#!";
        deserializeBTree(serialStr);*/
        //指针仍未释放一样
/*        TreeNode root=new TreeNode();
        TreeNode test6=new TreeNode();
        TreeNode test7=new TreeNode();
        root.left=test6;
        root.right=test7;
        test6=null;
        test7=null;
        System.out.println(root.left);
        System.out.println(root.right);*/

    }

}

