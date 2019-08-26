package Algorithm.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Scanner;

public class Fomat {
	static void f(){
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		System.out.println(s);
	}
	
	static void bigF(){
		Scanner sc=new Scanner(System.in);
		
		while(sc.hasNext()){
			String s=sc.nextLine();
			System.out.println(s);
		}
		
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
/*		Node n=new Node();
		n.iterator();
		
		Queue q=new LinkedList<Integer>();
		q.add(2);
		if(q.offer(1))System.out.println("没1");
		else System.out.println("有1");
		Object head=q.peek();
		Iterator i=q.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}*/
		bigF();
		//f();
	}
	
}
