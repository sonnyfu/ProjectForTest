package Algorithm.company;

/**
 * 
 * 二叉排序（搜索）树
 * 
 * @author sonny
 * @since 20191002
 * feature 数据结构一个类并包含其中的api
 */
public class BST {

	private BST left;
	private BST right;
	private BST parent;//for recall
	
	private Integer val;
	private Integer bf=0;//balancefactor
	private Boolean out_of_balance=true;//每个节点默认有不平衡的特性
	
	public BST(Integer val) {
		this.val=val;
	}
	
	public BST(Integer val,BST parent) {
		this.val=val;
		this.parent=parent;
	}	
	
	public BST() {
		
	}
	/**
	 * 
	 * @param leftSubTreeRootNode
	 * @return
	 */
	public void  rightRotate(BST leftSubTreeRootNode) {
		BST tmpLLNode=leftSubTreeRootNode.left.left;
		Integer tmpLVal=leftSubTreeRootNode.left.val;
		Integer tmpRootVal=leftSubTreeRootNode.val;
		
		leftSubTreeRootNode.val=tmpLVal;
		leftSubTreeRootNode.left.val=tmpLLNode.val;
		leftSubTreeRootNode.left.left=null;
		tmpLLNode.val=tmpRootVal;
		leftSubTreeRootNode.right=tmpLLNode;
		
		//bf置0
		leftSubTreeRootNode.bf=0;
		leftSubTreeRootNode.left.bf=0;
		leftSubTreeRootNode.right.bf=0;
		
	}
	
	/**
	 * 二叉平衡树版本
	 * @param val
	 * @param node
	 */
	public BST insertInBalance(Integer val,BST node) {
		if(node==null) {
			BST tmpode=new BST();
			tmpode.val=val;
			return tmpode;
		}
		if(val<node.val) {
			node.left=insertInBalance(val,node.left);
			node.left.parent=node;
			//设置bf（先判断bf，再决定旋转与否）
			if(node.bf.equals(0)) {
				node.bf=1;
			}else if(node.bf.equals(1)&&node.out_of_balance) {//右旋
				rightRotate(node);
				if(node.parent!=null) {
					node.parent.out_of_balance=false;	
				}
				
			}else {//先右旋再左旋
				
			}
		}else if(val>node.val){
			node.right=insertInBalance(val,node.right);
			node.right.parent=node;
		}
		return node;
	}	
	
	/**
	 * 从根节点开始,带父节点
	 * @param val
	 * @param node
	 */
	public BST insertWithParent(Integer val,BST node) {
		if(node==null) {
			BST tmpode=new BST();
			tmpode.val=val;
			return tmpode;
		}
		if(val<node.val) {
			node.left=insertWithParent(val,node.left);
			node.left.parent=node;
		}else if(val>node.val){
			node.right=insertWithParent(val,node.right);
			node.right.parent=node;
		}
		return node;
	}
	
	/**
	 * 从根节点开始
	 * @param val
	 * @param node
	 */
	public BST insert(Integer val,BST node) {
		
		if(node==null) {
			BST tmpode=new BST();
			tmpode.val=val;
			return tmpode;
		}
		if(val<node.val) {
			node.left=insert(val,node.left);
		}else if(val>node.val){
			node.right=insert(val,node.right);
		}else {
			//相等的情况
			
		}
		return node;
	}	
	
	/**
	 * 
	 * @param val
	 * @param node
	 */
	public BST getNode(Integer val,BST node) {
		
		if(node==null) {
			return node;
		}else if(val.equals(node.val)) {
			return node;
		}else if(val<node.val) {
			return getNode(val,node.left);
		}else{
			return getNode(val,node.right);
		}
	}
	
	/**
	 * 
	 * @param val
	 * @param node
	 */
	public BST getMinNode(BST node) {
		if(node.left==null) {
			return node;
		}else {
			return getMinNode(node.left);			
		}
	}
	
	/**
	 * 没有自动调整版本，删一个节点，子节点就会unmounted，生成内存碎片；
	 * @param val
	 * @param node
	 */
	public BST deleteNode(Integer val,BST node) {
		if(node==null) {
			return null;
		}else if(val.equals(node.val)) {
			//delete
			return null;
		}else if(val<node.val) {
			return node.left=delete(val,node.left);
		}else{
			return node.right=delete(val,node.right);
		}
	}
	
	public void exchNode(BST source,BST target) {
		
	}
	
	/**
	 * 删除右子树节点的背景
	 * @param val
	 * @param node 返回头节点()
	 */
	public BST delete(Integer val,BST node) {
		BST tartGetNode=getNode(val, node);
		BST minNode=getMinNode(tartGetNode);
		//BST minP= minNode.parent;
		minNode.parent=tartGetNode.parent;
		if(minNode!=tartGetNode.left) {
			minNode.left=tartGetNode.left;	
		}
		
		minNode.right=tartGetNode.right;
		
		if(tartGetNode.parent!=null) {
			tartGetNode.parent.right=minNode;
		}
		return node;
	}	
	
	
	
	public static void main(String[] args) {
		BST root=new BST(3);
		root.insert(2, root);
		root.insert(1, root);
		//root.rightRotate(root);
		root.insert(7, root);
		BST targetNode=root.getNode(3, root);
		System.out.println(targetNode==null?targetNode:targetNode.val);
		root.deleteNode(1, root);
		targetNode=root.getNode(1, root);
		System.out.println(targetNode==null?targetNode:targetNode.val);
		
		
		
		BST root2=new BST(3,null);
		root2.insertWithParent(1, root2);
		root2.insertWithParent(4, root2);
		root2.insertWithParent(5, root2);
		root2.insertWithParent(7, root2);
		System.out.println(root2);
		
		BST root3=new BST(5,null);
		root3.insertWithParent(1, root3);
		root3.insertWithParent(10, root3);
		root3.insertWithParent(7, root3);
		root3.insertWithParent(12, root3);
		root3.delete(10, root3);
		System.out.println(root3);		
		
		
		BST root4=new BST(5);
		root4.insertInBalance(4, root4);
		root4.insertInBalance(3, root4);
		root4.insertInBalance(2, root4);
		root4.insertInBalance(1, root4);
		
		System.out.println(root4);	
		
	}
	
}
