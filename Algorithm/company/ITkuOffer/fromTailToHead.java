package Algorithm.company.ITkuOffer;

import java.util.ArrayList;
import java.util.Stack;

import Algorithm.compet.ListNode;

public class fromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	
    	if(listNode==null) return null;
        /*        ArrayList result=new ArrayList<Integer>();
        while(listNode.next!=null){
            result.add(listNode.val);
                listNode=listNode.next;
        }
        int tmp[]=new int[result.size()];
        for(int i=0;i<result.size();i++){
            tmp[i]=(int) result.get(i);
        }
        for(int i=result.size()-1,j=0;i>=0;i--){
            result.set(j,tmp[i]);
        }
        return result;*/
        Stack<Integer> stack=new Stack<Integer>();
    	while(listNode!=null){
    		stack.add(listNode.val);//
    		listNode=listNode.next;
    	}
    	ArrayList<Integer> result=new ArrayList<Integer>();
    	while(stack.size()!=0){
    		result.add(stack.pop());
    	}
    	return result;
    }
    
    public static void main(String[] args) {

    	
	}
    
}
