package Algorithm.compet;

public class PathTree {
	/*基本情况
	 * 
	 * 
	 * 
	 1、根节点为空，直接返回false，否则若该节点为sum则可以证明true
	 （递（一分为二）；归：节点是否等于sum-前一个节点的值；）；
	*/
	int val;
	PathTree left;
	PathTree right;
	public PathTree(int x) {
		val=x;
		left=null;
		right=null;
	}
	
	public static Boolean pathValidate(PathTree head,int sum) {
		if(head==null)return false;
		if(head.left==null&&head.right==null) return sum==head.val;
		return pathValidate(head.left, sum-head.val)||pathValidate(head.right, sum-head.val);
	}
	
	public static void main(String[] args) {
		PathTree root=new PathTree(1);
		PathTree left=new PathTree(2);
		PathTree right=new PathTree(3);
		root.left=left;
		root.right=right;
		int sum=2;
		if(pathValidate(root, sum))
			System.out.println("ture!");
		else
			System.out.println("false!");
	}
}
