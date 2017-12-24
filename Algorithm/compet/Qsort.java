package Algorithm.compet;

public class Qsort {
	
	/*median-Kth number-Qsort
	 *挖坑填补——用首尾下标移动实现分区
	 *分而治之——即细分到两个数的交换
	 *5,3,7,1
	 *1,3,7,5
	 *1,3,5,7
	 * */
	static void swap(int a[],int l,int r){
		int temp;
		temp=a[l];
		a[l]=a[r];
		a[r]=temp;
	}
	static int arraySort(int a[],int l,int r){
		int i,j,pivot;
		i=l;j=r;pivot=a[l];
		while(i<j){ 
			//加=号可能是一样的数字；用while及i<j，是为了
			while(a[j]>=pivot&&i<j)j--;
			swap(a,i,j);
			//前后交换过程中，a[i]可能等于pivot，因为pivot是随着分区来移动位置的
			while(a[i]<=pivot&&i<j)i++;
			swap(a,i,j);
		}
		return i;
	}
	//
 	static void qSort(int a[],int l,int r){
		int i;
		if(l<r){
			i=arraySort(a, l, r);
			qSort(a, l, i-1);
			qSort(a, i+1, r);
		}
	}
	//
	public static void main(String[] args) {
		//int b;
		//System.out.println(b+1);error:基本类型和引用类型声明后没有默认值，必须初始化或赋值或实例化才行，否则不能用
		int a[]={5,3,7,1,5,8,7};
		qSort(a, 0,a.length-1);
		for (int i : a) {
			System.out.print(i+" ");
		}
/*		for(int j=2;j<=1;j++)
			System.out.print(j);*/
	}

}
