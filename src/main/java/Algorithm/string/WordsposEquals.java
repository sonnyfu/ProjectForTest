package Algorithm.string;

import java.util.Arrays;

public class WordsposEquals {
	//
    public static boolean anagram(String s, String t) {
       char a[]=s.toCharArray();
        char b[]=t.toCharArray();
    	Arrays.sort(a);
         Arrays.sort(b);
         
         for(int i=0;i<a.length;i++)
        	 if(i==a.length-1&&a[i]==b[i])  		 
    	return true;
    	return false;
    }
    
    public static void main(String[] args) {
		System.out.println(anagram("agjh", "aghj"));
	}
}
