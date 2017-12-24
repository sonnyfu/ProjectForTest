package compet;

public class BinarysearchString {
	/**
	 *题目:排序的的字符串数组（"a"），其中插入了空字符串，
	 *I:a,b, ,c,d, ,;6,c
	 *O:3无则返回0
	 思路：
	 找到给字符串，去掉前面的空字符个数即得答案；
	 1、i<j为循环条件（首尾重合退出）
	 2、循环时
	 Z：
	 1、写的时候出错了，一遍的思路不足则回看，否则浪费了精力且易出错；
	 */
	static int search(String str[],String ask){
		
		int begin=0,end=str.length-1;
		int i=begin;int j=end;
		int mid;
		while(i<j){
		mid=(i+j)/2;
		if(str[mid]==""){
			int t1,t2;
			t1=t2=mid;
			while(str[--t1]=="");
				if(str[t1]==ask)
					return realNum(str, t1);
				//str[t1]比ask大
				if(str[t1].compareTo(ask)>0)
					j=t1;
				while(str[++t2]=="");
				if(str[t2]==ask)
					return realNum(str, t2);
				if(str[t2].compareTo(ask)<0)
					i=t2;
		}
		else{
			if(str[mid]==ask)
				return realNum(str, mid);
			//str[t1]比ask大
			if(str[mid].compareTo(ask)>0)
				j=mid-1;
			if(str[mid].compareTo(ask)<0)
				i=mid+1;
		}
	}
		return 0;		
}
	static int realNum(String str[],int curPos){
		int count=0;
		for(int i=0;i<curPos;i++){
			if(str[i]=="")count++;
		}
		return curPos+1-count;
	}
	
	
	public static void main(String[] args) {
		//字符串为空格，空字符串，字符串为null是三个不同的概念
/*		String str[]={"a",""};
		String src=" ";
		System.out.println(str.length);
		System.out.println(str[1].equals(src));
*/		
		String str[]={"a","b","","c","d",""};
		String str2[]={""};
		System.out.println(search(str, "d"));	
	}
}
