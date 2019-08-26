package Algorithm.compet;

public class Kforax {
	
	/**1327
	 * 处理：
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	static int[] max(int a[],int k){
		int i,j,n;
		int[] tmp=new int[a.length-k];
		int[] result=new int[a.length-k];
		for(i=0,j=1,n=0;n<k;n++,i+=2,j=i+1){
			if(a[i]<a[j])
				tmp[n]=j;
			else
				tmp[n]=i;
		}
		if(j>a.length){
			for(i=0;i<tmp.length;i++)
				result[i]=a[tmp[i]];
			return result;
		}
		else{
		for(i=0;i<tmp.length;i++)
			result[i]=a[tmp[i]];
		for(i=n,k=j-1;k<a.length;k++,i++)
			result[i]=a[k];
		return result;
		}
	}
	public static void main(String[] args) {
		int src1[]={1,3,2,7};
		int re1[]=max(src1,2);
		int src2[]={1,3,2,7,4,5};
		int re2[]=max(src2,2);
		for(int i:re1){
		System.out.print(i);
	}
		System.out.println();
	for(int i:re2){
	System.out.print(i);}
}
}
