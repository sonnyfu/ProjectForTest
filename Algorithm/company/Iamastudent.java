package Algorithm.company;


public class Iamastudent {
	/**
	 * 
	 * @param str
	 */
 	static String Reverse(String str,char p){
 		char strChar[]=str.toCharArray();
 		int l=strChar.length-1;
 		int i=l>>1;
 		while(i-->=0){
 			swap(strChar[i],strChar[l-i]);
 		}
 		
 		for(int j=0;j<=l;j++){
// 			if(strChar[j]){
// 				
// 			}
 		}
		return null;
 	} 
 	
 	static void swap(char a,char b){
 		char tmp;
 		tmp=a;
 		a=b;
 		b=tmp;
 	} 
 	
 	public static void main(String[] args) {
		StringBuffer sb=new StringBuffer();
		//sb.ap
 	}
}
