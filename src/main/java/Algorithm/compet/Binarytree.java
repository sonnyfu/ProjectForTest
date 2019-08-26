package Algorithm.compet;

import java.util.LinkedList;
import java.util.Stack;

public class Binarytree {
	//输入
	LinkedList<TreeNode> PreOrderTraverse(TreeNode root){
		
		LinkedList<TreeNode> link=new LinkedList<TreeNode>();
		Stack<TreeNode> stack=new Stack<TreeNode>();  
		stack.push(root);
		while(stack!=null){
			TreeNode cur=stack.pop();
			link.add(cur);
			if(root.right!=null)stack.push(root.right);
			if(root.left!=null)stack.push(root.left);
		}
			
		return link;
	}
	
	
	class TreeNode{
		char val;
		TreeNode left;
		TreeNode right;
		public TreeNode(){
			
		}
		
		
		//输入：一个二叉树先序扩展序列数组(即空字符用#代替)
		//处理：递归实现：先写左子树，再回溯写右子树
		//输出：一个二叉树
		void PreBinaryTree(char []src,int i,TreeNode node){
			node=new TreeNode();
			node.val=src[i];
			if(src[i]=='#')node=null;
			while(node!=null){
				PreBinaryTree(src,i+1,node.left);
				PreBinaryTree(src,i+1, node.right);
			}
		}	
	}
	
	public static void main(String[] args) {
		Binarytree bt=new Binarytree();
		TreeNode tr=bt.new TreeNode();
		TreeNode src=bt.new TreeNode();
		LinkedList<TreeNode> result=new LinkedList<TreeNode>();
		char []a={'a','b','d','#','#','#','c','#','#'};
		int i=0;
		tr.PreBinaryTree(a, i, src);
		
/*		result=bt.PreOrderTraverse(src);
		for(TreeNode trr:result)
		System.out.print(trr.val);*/
	}
	
}
