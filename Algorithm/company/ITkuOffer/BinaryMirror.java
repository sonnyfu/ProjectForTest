package Algorithm.company.ITkuOffer;

import Algorithm.structure.LevelTravel;
import Algorithm.structure.TreeNode;

public class BinaryMirror {
	static void PrintMirror(TreeNode root){
		if(root!=null){
			swap(root);
			PrintMirror(root.left);
			PrintMirror(root.right);
		}
	} 
	
	static void swap(TreeNode root){
		if(root.left!=null){
			TreeNode node=root.left;
			root.left=root.right;
			root.right=node;
		}
	}
	
	public static void main(String[] args) {
		int a[]={};
		TreeNode root=TreeNode.createTree(a);
		PrintMirror(root);
		LevelTravel lVisit=new LevelTravel();
		lVisit.levelPrint(root);
	}
	
}
