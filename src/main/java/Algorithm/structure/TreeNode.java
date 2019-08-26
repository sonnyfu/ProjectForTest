package Algorithm.structure;


public class TreeNode {
	public Integer value;
	public TreeNode left;
	public TreeNode right;
	static public TreeNode createTree(int a[]){
		if(a==null||a.length==0)return null;
		TreeNode node=new TreeNode();
		creatImp(a, 0, node);
		return node;
	}
	
	static public void creatImp(int a[],int index,TreeNode node){
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

	
}
