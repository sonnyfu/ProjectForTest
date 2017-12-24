package Algorithm.company.ITkuOffer;

import java.util.Stack;


public class ISPopOrder {
    static boolean ispopA (int pushA[],int popA[]){
    	if(pushA==null||popA==null)return false;
    	Stack<Integer> t1=new Stack();
       for(int i=0,j=0;i<pushA.length;i++){
    	t1.add(pushA[i]);
    	//Integer t2=;左边可以带函数
    	   while(popA[j]==t1.peek()){
    		   t1.pop();j++;
    		   if(t1.isEmpty())break;
    	   }   
       }
       if(t1.isEmpty())return true;
       return false;
    }
    
    public static void main(String[] args) {
		int push[]={1,2,3,4,5},pop[]={4,5,3,2,1};
		System.out.println(ispopA(push, pop));
	}
}
