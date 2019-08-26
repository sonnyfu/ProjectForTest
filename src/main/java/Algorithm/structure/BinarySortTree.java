package Algorithm.structure;

import java.util.HashSet;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;




	


public class BinarySortTree {
	
	static class TreeNode {
		int key;
		int value;
		TreeNode left;
		TreeNode right;
		
		public TreeNode(){}
		
		public TreeNode(int key,int value){
			this.key=key;
			this.value=value;
		}
	
	/**
	 * B：，判断大小不重复添加（实例化）
	 * I:
	 * 
	 * O:
	 */
	public static TreeNode creaTree(int key,int value,TreeNode tN){
		if(tN==null)
			tN=new TreeNode(key,value);
		if(key==tN.key)return tN;
		if(key>tN.key)
			creaTree(key, value, tN.right);
		if(key<tN.key)
			creaTree(key, value, tN.left);
		return tN;
	}
	/**
	 * B：查找二叉树
	 * I:min,max,tN,hashset;
	 * 
	 * O:
	 */
	
	public static void testTravel(TreeNode tN){
		if(tN==null)return;
		else{
			testTravel(tN.left);
			System.out.println(tN.key);
			testTravel(tN.right);
		}
	}
	
	public static HashSet<Integer> travel(Integer min,Integer max,HashSet<Integer> resu,TreeNode tN){
		if(tN==null)return resu;
		
		if(min<tN.key)travel(min, max, resu, tN.left);
		
		if(min<=tN.key&&max>=tN.key)
			resu.add(tN.key);
		
		if(min>tN.key||max>tN.key)
			travel(min, max, resu, tN.right);
		
		return resu;
	}
	
	public static void main(String[] args) {
		int i=5,min=0,max=0,key=0,value=0;
			Scanner in=new Scanner(System.in);
			TreeNode tN=new TreeNode();
			
/*			while(i--!=0){
			min= in.nextInt();
			max=in.nextInt();
System.out.println(min+max);
			}*/
			
			while(i--!=0){
			min= in.nextInt();
			max=in.nextInt();
			tN=creaTree(key, value, tN);
			}
			testTravel(tN);
	}

}
}