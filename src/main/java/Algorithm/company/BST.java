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
	private Integer val;
	
	public BST(Integer val) {
		this.val=val;
	}
	
	public BST() {
	}
	
	/**
	 * 根节点
	 * @param val
	 * @param node
	 */
	public BST insert(Integer val,BST node) {
		
		if(node==null) {
			BST tmpode=new BST();
			tmpode.val=val;
			return tmpode;
		}
		if(val<this.val) {
			node.left=insert(val,node.left);
		}else if(val>this.val){
			node.right=insert(val,node.right);
		}
		return node;
	}
	
	public static void main(String[] args) {
		BST root=new BST(3);
		root.insert(1, root);
		root.insert(4, root);
		root.insert(5, root);
		root.insert(7, root);
		
//		
		System.out.println(root);
	
		
		
	}
	
}
