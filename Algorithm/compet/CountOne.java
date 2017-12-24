package compet;

public class CountOne {

	//思路：找出个位1的个数，其他位为1的个数（转换为个位）
	static public long CountOne1(int n){
		int count=0,j;
		for(int i=1;i<=n;i++){
			j=i;
			//对每一位数从个位开始处理
			while(j!=0){
				if(j%10==1) count++;
				j/=10;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		System.out.println(CountOne1(2));
		System.out.println(CountOne1(12));
		
	}
}
