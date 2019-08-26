package Algorithm.company;


import java.util.ArrayList;
import java.util.List;



public class LsatNo {

	    private static class Node1 {  
	        public int no;// 编号  
	        public Node1 next;// 下一个节点  
	  
	        public Node1(int no) {  
	            this.no = no;  
	        } 	  
	    }
	    //模拟境界：外围类为作为一个容器，（省去内部类机制）里面各种类可以用于模拟;有staic关键字作用下
	    
	    //mine，数学原理难推敲
	    static int Num(int a[]){
			int i=0;int j=2;
			if(a.length%2==0)return a[a.length-1];
			int t=0;
			while(j<=a.length){
				if(j<a.length){
					i++;
					j++;
					t=++j;		
				}
				if(j==a.length){
					//if
				}
				else{
					
				}
			}
			return 0;
		}
	    
	    static class Node {  
	        private int index;  
	        private Node next;  
	        public Node(int index) {  
	            this.index = index;  
	        }  
	        public int getIndex() {  
	            return index;  
	        }  
	        public void setIndex(int index) {  
	            this.index = index;  
	        }  
	        public Node getNext() {  
	            return next;  
	        }  
	        public void setNext(Node next) {  
	            this.next = next;  
	        }  
	        @Override  
	        public String toString() {  
	            return String.valueOf(index);  
	        }  
	    }  
	      
	    static public class Josephus {  
	        private List<Node> nodes = new ArrayList<LsatNo.Node>();  
	        public Josephus(int n) {  
	            for(int i=1; i<=n; i++) {  
	                Node node = new Node(i);  
	                push(node);  
	            }  
	        }  
	        public void push(Node node) {  
	            if(nodes.size()== 0) {  
	                node.setNext(node);  
	                nodes.add(node);  
	            }else {  
	                nodes.get(nodes.size()-1).setNext(node);  
	                node.setNext(nodes.get(0));  
	                nodes.add(node);  
	            }  
	        }  
	        public void pull(Node node) {  
	            if(nodes.size()>1) {  
	                int pre = nodes.indexOf(node);  
	                if(pre==0) {  
	                    pre = nodes.size();  
	                }  
	                Node node_pre = nodes.get(pre-1);  
	                node_pre.setNext(node.getNext());  
	                nodes.remove(node);  
	            }else {  
	                nodes.remove(node);  
	            }  
	            System.out.println(nodes);  
	            System.out.println(node);  
	        }  
	        public List<Integer> output(int m) {  
	            List<Integer> result = new ArrayList<Integer>();  
	            Node node = null;  
	            if(nodes.size()!=0) {  
	                node = nodes.get(0);  
	            }  
	            while(nodes.size()!= 0) {  
	                for(int i=0; i<m; i++) {  
	                    node = node.getNext();  
	                }  
	                pull(node);  
	                result.add(node.getIndex());  
	            }  
	            return result;  
	        }
	    } 
	    
	    public static void main(String[] args) {  
	    	//...
	    	Node1 node=new Node1(0);
	    	//...
	    	
	    	
	        Josephus jos = new Josephus(41);  
	        List<Integer> result = jos.output(2);  
	        System.out.println(result);  

	    }

}
