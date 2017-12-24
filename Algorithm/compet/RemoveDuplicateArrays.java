package compet;

import java.util.Vector;

public class RemoveDuplicateArrays {
//封装的方法，底层运行逻辑不透明
	public static void main(String[] args) {
		Vector<Integer> ar=new Vector<Integer>(3);
		ar.addElement(1);
		ar.addElement(1);
		ar.addElement(2);
		int index=0;
		for(int i=1;i<ar.size();i++){
			if(ar.get(index)!=ar.get(i)){
				int temp=ar.get(i);
				ar.add(index++, temp);
			}
		}
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
}
