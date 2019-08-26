package Algorithm.structure;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

import Algorithm.compet.ListNode;

public class LevelTravel {
	public static void levelPrint(TreeNode root){	
		if(root==null)System.out.println("参数不能为空！");;
		Queue<TreeNode> rootContain=new ArrayDeque();
		rootContain.add(root);
		while(!rootContain.isEmpty()){
			TreeNode tNode=rootContain.poll();
			System.out.println(tNode.value);
			if(tNode.left!=null)rootContain.add(tNode.left);
			if(tNode.right!=null)rootContain.add(tNode.right);
		}
		
	}
	
	void remove(Integer i){
		
	}
	
	void remove(int i){
		
	}
	
	
	public static void main(String[] args) {
/*		Queue<Integer> rootContain=new ArrayDeque();
		for(int i=0;i<3;i++){
			rootContain.add(i);
		}
		System.out.println(rootContain.poll());*/
		int a[]={2,3,5,1,4};
		TreeNode root=TreeNode.createTree(a);
		levelPrint(root);
	}
	
}
