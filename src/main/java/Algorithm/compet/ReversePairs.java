package Algorithm.compet;


public class ReversePairs {
	// 一定要实例化才能实例化其中的变量（静态变量）
	static int number;
	static int sum;
	static int mergeSort(int a[],int l,int r,int sum){
		
		if(l==r){
			return 0;
		}
			
		int m=(l+r)/2;
		mergeSort(a, m+1, r,sum);
		mergeSort(a, l, m,sum);
		sum+=merge(a,l,m,r);
		return sum;
	}
	
	static int merge(int a[],int l,int m,int r){
		//若想引用数组变量，面向对象则为 int a[]=new int[len];
		int save[]=new int[a.length];//最大数值扩容
		int mk=m+1;
		int ll=l;
		int cIndex=l;
		int count=0;
		while(l<=m&&mk<=r){
			if(a[l]<=a[mk]) 
				save[ll++]=a[l++];
			else{
				count+=(m-l+1);
				save[ll++]=a[mk++];
			}
				
		}
		//归并左边剩余的数
		while(l<=m){
		save[ll++]=a[l++];	
		}
		//归并右边剩余的数
		while(mk<=r){
			save[ll++]=a[mk++];
		}
		
/*		if(cIndex==0&&r==a.length-1){
			for (int i : save) {
				System.out.print(i+" ");
			}
		}*/
		
        System.out.println("第"+(++number)+"趟排序:\t");
        //从临时数组拷贝到原数组
         while(cIndex<=r){
                a[cIndex]=save[cIndex];
                //输出中间归并排序结果
                System.out.print(a[cIndex]+"\t");
                cIndex++;
            }
         System.out.println();
         return count;
		
	}
	public static void main(String[] args) {
		int a[]= new int[]{4,5,3,2};
		System.out.println("数组逆序对的个数是："+mergeSort(a, 0, a.length-1,0));
	}
}
