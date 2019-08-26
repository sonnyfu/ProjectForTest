package Algorithm.structure;

import java.util.Stack;

public class Traverse {
	static void preOrder(TreeNode root){
		Stack<TreeNode> s=new Stack();
		while(root!=null||!s.empty()){
			if(root!=null){
				System.out.println(root.value);
				s.push(root);
				root=root.left;
			}
			else{
				root=s.peek();
				s.pop();
				root=root.right;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[]={8,9,2,4,5,3,1};
		TreeNode root=TreeNode.createTree(a);
		preOrder(root);
	}
}
