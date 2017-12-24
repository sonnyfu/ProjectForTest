package Algorithm.string;

public class Lcp {
    static public String longestCommonPrefix(String[] strs) {
        int k=0,i=0;
        int len=strs[i].length();
        //i的值的变化
        
        //用k记录最短字符串下标；
        for(;i<strs.length-1;){
            if(len>strs[++i].length()){
                len=strs[i].length();
                k=i;
            }
        }
        //第i轮的第j个比较
        int j=0;Boolean sign=false;
        for(;j<strs[k].length();j++){
            int n=0;
            while(n<strs.length-1){
                char tmp=strs[n++].charAt(j);
                if(tmp!=strs[n].charAt(j)){
                	sign=true;
                	break;
                } 
            }
            if(sign)break; 
        }
        return strs[k].substring(0,j);
    }
    
    
public static void main(String[] args) {
	//对于StringArray,""也为一个对象，对于""本身，长度为0
/*	String s[] = {""};
	System.out.print(s[0].length());*/
	
	String str[]={"abcde","abcd"};
	String res=longestCommonPrefix(str);
	System.out.println(res);
}
   }

