package Algorithm.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	class Node{
		Integer value;
		Node right;
		Node left;
	}
	
	
	
	void printTree(Node tn){
		if(tn!=null)return;
		Queue<Node> q=new LinkedList<Node>();
		q.add(tn);
		while(tn!=null){
			Node n=q.poll();
			System.out.println(n.value);
			if(n.left!=null)q.add(n.left);
			if(n.right!=null)q.add(n.right);
			System.out.println();
 		}
	}
	
	
	public static void main(String[] args) {
		
	}
}
