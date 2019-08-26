package Algorithm.compet;

import java.util.Arrays;

public class KMPcopy {
	
	/*
	kmp算法
	Q：生成部分匹配值； 
	A：一组1,~m-2，分别生成一组n-2~1，依次比较且判断相等与否，等则记录字符长度,即比较序数；
	Q:匹配
	A:字符串遇到不匹配的字符，头部移位，即匹配数-最后一个字符串代表的匹配值，直至全部匹配完毕或被匹配字符串完毕；
	
	*/ 
	
	public static boolean kmp(){



	int i,j;String[] pre={""};String[] post={""};
	String matchS="abe";
	String srcS="ababcdag";
	int[] value=new int[matchS.length()];
	Arrays.fill(value, 0);
	for(i=1;i<matchS.length();i++){
		if(matchS.charAt(i)==matchS.charAt(i-1))
			value[i]=value[i-1]+1;
	}  
	
	
	for(i=0;i<srcS.length();){
		j=0;
		while(matchS.charAt(j)==srcS.charAt(i)){
			if(j==matchS.length()-1)
				return true;
			++j;++i;
			if(i==srcS.length())
				return false;
		}
		//首次不相等和溯回
		if(j==0)
			i+=1;
		else
			i+=value[j-1];
	}
	
		return i>=srcS.length();
}
	public static void main(String[] args) {
		if(kmp())
			System.out.println("ok!");
		else{
			System.out.println("Sorry!");
		}
	}

}
