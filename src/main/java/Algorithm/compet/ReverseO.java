package Algorithm.compet;

public class ReverseO {


	      int val; 
	      ReverseO next; 
	      ReverseO(int x) { 
	          val = x; 
	         next = null; 
	      } 
 
	    // Divide the list to three parts:   
	    // 1)Nodes before m keep still;   
	    // 2)Traverse m~n nodes;  
	    // 3)Nodes after n keep still.  
	    public ReverseO reverseBetween(ReverseO head, int m, int n) {  
	        if (m == n) return head;  
	          
	        ReverseO preHead = new ReverseO(0);  
	        preHead.next = head;  
	          
	        // The (m-1) node is the tail of first tail.  
	        ReverseO firstTail = preHead;  
	        int k = m - 1;  
	        while (k-- > 0) {  
	            firstTail = firstTail.next;  
	        }  
	          
	        // The m-th node is the traversed tail.  
	        ReverseO secondTail = firstTail.next;  
	          
	        // Traverse m~n nodes, and get the traversed head.  
	        ReverseO tmpHead = null;  
	        ReverseO tmpNext = null;  
	        ReverseO node = firstTail.next;  
	        k = n - m + 1;  
	        while (k-- > 0) {  
	            tmpHead = node;  
	            node = node.next;  
	              
	            tmpHead.next = tmpNext;  
	            tmpNext = tmpHead;  
	        }  
	          
	        // Connect three parts.  
	        firstTail.next = tmpHead;  
	        secondTail.next = node;  
	          
	        return preHead.next;  
	    }  
	
	public static void main(String[] args) {
		

	}

}
