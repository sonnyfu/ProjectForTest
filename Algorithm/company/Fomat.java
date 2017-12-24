package Algorithm.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
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
	
	static class Node implements Queue<Node>{
		
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterator<Node> iterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Object[] toArray() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends Node> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean add(Node e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean offer(Node e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Node remove() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Node poll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Node element() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Node peek() {
			// TODO Auto-generated method stub
			return null;
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
