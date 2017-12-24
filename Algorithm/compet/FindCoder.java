package compet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCoder implements Comparable<FindCoder> {

	List list1=new ArrayList<Integer>();
	int counts;
	int index;
	public FindCoder(int index,int counts){
		this.index=index;
		this.counts=counts;
	}
	
	public int getcounts(){
		return counts;
	}
	
	String[] findCoder(String[] src){
		String s;
		return null;
	}

	@Override
	public int compareTo(FindCoder o) {
		
		return 0;
	}
	
	public static void main(String[] args) {
		FindCoder fc=new FindCoder(0, 2);
		System.out.println(fc.counts);
		System.out.println(fc.getcounts());
		
	}
	

}
