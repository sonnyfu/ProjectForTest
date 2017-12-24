package Algorithm.string;

public class SourceAndTarget {
	/**I：
	 * 1,分3类
	 * 1.1 
	 * 2，匹配直到
	 * 2.1相同则一块往后移
	 * 2.3不同一个后移，一个重新回头
	 */
	
	static int compatable(String source,String target){
		int i=0,j=0;
		if(source==null||target==null)return -1;
		if(target=="")return i;
		if(source=="")return -1;
		
		while(i<source.length()){
			if(source.charAt(i)==target.charAt(j)){
				while(source.charAt(i)==target.charAt(j)){
				    i++;j++;
					if(j==target.length()) return i-j;
					if(i==source.length()) return -1;
				}
				j=0;
			}
			else{
				i++;
				j=0;
			}
		}
		return -1;	}
	
	public static void main(String[] args) {
		
	}
}
