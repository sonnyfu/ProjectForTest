package string;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

//00;35min
public class KMP {
	static int[] next(String s){
		char ss[]=s.toCharArray();
		int next[]=new int[s.length()];
		for(int i=0;i<s.length();i++){
			if(i==0)next[i]=-1;
			else if(i==1)next[i]=0;
			else{
				int j,v;j=v=i;
				for(j=0;i>1;){
					if(ss[--i]==ss[j])
						next[v]=++j;
				}
			}
		}
		return next;
		
	}
	
	/*
	 * I:S:ababaababc;T:ababc;
	 * 
	 * O:
	 */
	 static boolean kmp(String s,String t){
		 int next[]=next(t);
		 int sl,tl;
		 sl=s.length()-1;
		 tl=t.length()-1; 
		 char ss[]=s.toCharArray();
		 char tt[]=t.toCharArray();
		 int i=0,j=0;
		 while(i<=sl){
			 if(ss[i]==tt[j]){
				 i++;j++;
			 }
			 else{
				 j=next[j];
			 }
		 }
		 if(j==tl+1)
			 return true;
		 return false;
	 }
	 //abaabx:20+10+20
	 static int[] rnext(String t){
		 char[] tt=t.toCharArray();
		 int[] next=new int[tt.length];
		 for(int i=0;i<tt.length;i++){
			 if(i==0)next[i]=0;
			 else if(i==1)next[i]=1;
			 else{
				 int max=1;int j=i;
				 while(--j>0){
					 int k=0;					//abaabx
					if(tt[j]==tt[k]){
						next[i]=j;
						//max>next[i]?:max=next[i];
						if(max<next[i])max=next[i];
						
						
					}
					else{
						
					}
				 }
			 }
		 }
			 
		 return null;
	 }
	 
	 //
	 
	 static Boolean rkmp(String A,String B){
	   char b[]=B.toCharArray();
	   char []bb=new char[b.length+1];
	   for(int t=1;t<=b.length;t++)
		   bb[t]=b[t-1];
       int[] next=new int[bb.length];
       int i=1;
       int j=0;
       next[1]=0;
       while(i<bb.length-1){
               if(j==0||bb[i]==bb[j]){
                   ++i;
                   ++j;
                   next[i]=j;
               }
               else{
                   j=next[j];
               }
           }
           
       
       char a[]=A.toCharArray();
	   char []aa=new char[a.length+1];
	   for(int t=1;t<=a.length;t++)
		   aa[t]=a[t-1];
       int k=1;
       for(i=1;i<=a.length;){
           if(aa[i]==bb[k]){
               k++;
               i++;
           }
           else{
               i=i+next[k]+1;
               k=1;
           }
       }
       
       
       if(k>b.length)
       return true;
       else
       return false;
       
      }    	 
	 public static void main(String[] args) {
		String s="adabababc";String t="ababd";
		System.out.println(rkmp(s, t));
		
 
	 }	
}