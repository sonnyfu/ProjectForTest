package Algorithm.company.ITkuOffer;

public class PrintlnToMax {
	static void prAndSave(int target){
		char src[]=new char[target];
		for(int i=0;i<target;i++)
			src[i]='0';
	while(!save(src)){
		pr(src);
	}
} 
	
	static Boolean save(char []src){
		Boolean flag=false;
		int advan=0,sum=0;
		for(int i=src.length-1;i>=0;i--){
			sum=(char) (src[i]-'0'+advan);
			if(i==src.length-1)
				sum++;
			if(sum==10){
				if(i==0)
					flag=true;
				else {
					sum-=10;
					advan=1;
					src[i]=(char) ('0'+sum);
				}
			}
			else{
				src[i]=(char) ('0'+sum);break;
			}
		}
		
		return flag;
	}
	
	static void pr(char[] src){
		int i=0;
		for(i=0;i<src.length;i++){
			if(src[i]!='0'){
				break;
			}
		}
		while(i<src.length){
			System.out.print(src[i++]);
		}
		System.out.println();
			
	}
	
	static void prinRecurse(int target) {
		char []src=new char[target];
		for(int i=0;i<target;i++)
			src[i]='0';
		recurse(src, target,0);
	}
	
	private static void recurse(char[] src,int depth,int index) {
		if(index==depth){
			pr(src);
			return;
		}
		for(int i=0;i<10;i++){
			src[index]=(char) ('0'+i);
			recurse(src, depth,index+1);

		}

	}
	
	public static void main(String[] args) {
		//prAndSave(3);
		prinRecurse(3);
	}
}
