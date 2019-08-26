package Algorithm.string;

public class LCSDP {
	/*
	 *BackGround:LCS
	 *1、初始化
	 *2、a[i][j]由a[i-1][j-1]等3种情况
	 */
	static int lcsDP(String a,String b){
		
		if(a==null||a==""||b==null||b=="")
		return 0;
		
		int maxLen=a.length()>b.length()?a.length()+1:b.length()+1;
		int sto[][]=new int[maxLen][maxLen];
		
		//DP
		int i=1;
		for(;i<=a.length();i++){
			
			for(int j=1;j<=b.length();j++){
				if(a.charAt(i-1)==b.charAt(j-1))
				sto[i][j]=sto[i-1][j-1]+1;
				else{
					//i,j,k,意思是第i,j,k轮
					//若a[i-1]!=b[j-1],且c[k-1]!=b[j-1]=>c[k-1]由a[i-1]和b[j-2]得出,
					//即sto[i][j]=sto[i][j-1]+0;
					if(sto[i][j-1]>=sto[i-1][j])
					sto[i][j]=sto[i][j-1];
					else
						sto[i][j]=sto[i-1][j];
				}
			}	
		}
		
		return sto[a.length()][b.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(lcsDP("abcd", "bd"));
	}
}
