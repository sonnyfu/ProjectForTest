package Algorithm.compet;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ArrayForTarget {

	boolean contain(int [][]ar,int target){
		
		
		return false;
		
		
	}
	
     List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        List<Integer> res = new LinkedList<Integer>();
        if(root!=null) s.push(root);
        while(!s.isEmpty()){
           TreeNode curr = s.pop();
            res.add(curr.val);
            if(curr.right!=null) s.push(curr.right);
            if(curr.left!=null) s.push(curr.left);
        }
        return res;
    }
	
	public static void main(String[] args) {
		
	}

}
