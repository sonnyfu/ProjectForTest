package Algorithm.company.ITkuOffer;

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
} 

public class ContaisSubTree {
	
	static boolean own;
	
	static TreeNode createTree(int a[]){
		if(a==null||a.length==0)return null;
		TreeNode node=new TreeNode();
		creatImp(a, 0, node);
		return node;
	}
	
	static void creatImp(int a[],int index,TreeNode node){
		if(index>=a.length) return;
		node.value=a[index];
		if(2*index+1>=a.length) return;
		TreeNode lNode=new TreeNode();
		lNode.value=a[2*index+1];
		node.left=lNode;
		if(2*index+2>=a.length) return;
		TreeNode rNode=new TreeNode();
		rNode.value=a[2*index+2];
		node.right=rNode;
		creatImp(a, 2*index+1, lNode);
		creatImp(a, 2*index+2, rNode);
	}
	
	static boolean hasSubTree(TreeNode t1,TreeNode t2){
		own=false;
		if(t1!=null&&t2!=null){
			if(t1.value==t2.value)
			own=theSame(t1, t2);
			if(!own)hasSubTree(t1.left, t2);
			if(!own)hasSubTree(t1.right, t2);
		}
		return own;
	}
	
	static boolean theSame(TreeNode st1,TreeNode st2){
		if(st2==null)return true;//相等的出口,下面是过程不相等的终止条件
		if(st1==null) return false;
		if(st1.value!=st2.value) return false;
		return theSame(st1.left, st2.left)&&theSame(st1.right, st2.right);
	}
	
	public static void main(String[] args) {
		int a1[]={8,8,2,9,2};
		int a2[]={8,9,2};
		TreeNode t1=createTree(a1);
		TreeNode t2=createTree(a2);
		System.out.println(hasSubTree(t1, t2));
	}
}
