package Algorithm.compet;

public class Shift {
	
	/*
	 *adbDfe;65:A,96:Z
	 *思路：
	 *
	 */
	
		

	static String shif(String str){
		char[]strc=str.toCharArray();
		int begin,end=str.length()-1;
		for(begin=str.length()-1;begin>=0;begin--){
			if(strc[begin]>64&&strc[begin]<97){
				if(begin==end)
					end--;
				else{
					int i=begin;
					char temp=strc[begin];
					while(i<end){
						strc[i]=strc[++i];
					}
					strc[end]=temp;
					end--;
				}					
			}	
		}
		//return str=str.copyValueOf(strc);
		//System.out.println(strc);
		return String.valueOf(strc);
		//return (String)strc;
		
	}
	public static void main(String[] args) {
		String str="AkleBiCeilD";
		str=shif(str);
		System.out.print(str);
	}
}
