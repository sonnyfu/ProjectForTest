
package Algorithm.string;

public class LCS {
	
    static public int longestCommonSubstring(String A, String B) {
        /*
        ACAD
        ABAC
        1,遍历com；32；
        找出最大；
        2,排序
        */
    	
    	//int str[]=new int[A.length()+1];
    	
    	if(A==null||A==""||B==null||B=="")
    		return 0;
    	int fmax=0;
        for(int i=0;i<A.length();i++){
        int k,max=0,tmp2;k=tmp2=i;int j=0;
         for(;j<B.length();j++){
             if(A.charAt(k)==B.charAt(j)){
                 k++;
                 /*
                  * 第一次为max
                  * 第二次判断一下
                  */
                 tmp2=k-i;
                 if(tmp2>max)
                	 max=tmp2;
                 if(k==A.length())break;
             }
             else{
                 k=i;
             }
         }
         
         fmax=Math.max(fmax, max);
         //ar[i]=Math.m(st);
     }
        	return fmax;
    }
    
    public static void main(String[] args) {
		System.out.println(longestCommonSubstring("A","AB"));
	}
}
