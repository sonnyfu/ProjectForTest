package compet;
public class MergeSort{
	// 一定要实例化才能实例化其中的变量（静态变量）
	//static int save[];
	//若想引用数组变量，面向对象则为 int a[]=new int[len];
	static int number;
	static void mergeSort(int a[],int l,int r){
		
		if(l>=r)
			return;
		int m=(l+r)/2;
		mergeSort(a, l, m);
		mergeSort(a, m+1, r);
		merge(a,l,m,r);
	}
	
	static void merge(int a[],int l,int m,int r){
		int save[]=new int[a.length];
		int mk=m+1;
		int ll=l;
		int cIndex=l;
		while(ll<=m&&mk<=r){
			if(a[ll]<=a[mk])
				save[ll++]=a[l++];
			else
				save[ll++]=a[mk++];
		}
		while(l<=m){
		save[ll++]=a[l++];	
		}
		while(mk<=r){
			save[ll++]=a[mk++];
		}
		
		//if(l==0&&r==a.length-1){
			//for (int i : save) {
			//	System.out.print(i);
			//}
		//}
		
        System.out.println("第"+(++number)+"趟排序:\t");
        //从临时数组拷贝到原数组
         while(cIndex<=r){
                a[cIndex]=save[cIndex];
                //输出中间归并排序结果
                System.out.print(a[cIndex]+"\t");
                cIndex++;
            }
         System.out.println();
    }
			

	
	public static void main(String[] args) {
		
		int a[]= new int[]{26,5,98,108,28,99,100,56,34,1};
		mergeSort(a, 0, a.length-1);
	}
	
	
/* 参考学习的地方：在算法设计中，如果对递归过程只有模型的认识而没有清晰的实践的认识，
 * 最佳实践就是在给每一层的遍历添加一个输出，这样就可以验证并把握递归的实质了。
 * 拓展：这种学习思想可用于项目中的测试，以及其他高大难问题的分解验证。
	    
	    public static void main(String[] args) {
	        int[] a = {26, 5, 98, 108, 28, 99, 100, 56, 34, 1 };
	        printArray("排序前：",a);
	        MergeSort(a);
	        printArray("排序后：",a);
	    }

	    private static void printArray(String pre,int[] a) {
	        System.out.print(pre+"\n");
	        for(int i=0;i<a.length;i++)
	            System.out.print(a[i]+"\t");    
	        System.out.println();
	    }

	    private static void MergeSort(int[] a) {
	        // TODO Auto-generated method stub
	        System.out.println("开始排序");
	        Sort(a, 0, a.length - 1);
	    }

	    private static void Sort(int[] a, int left, int right) {
	        if(left>=right)
	            return;
	    
	        int mid = (left + right) / 2;
	        //二路归并排序里面有两个Sort，多路归并排序里面写多个Sort就可以了
	        Sort(a, left, mid);
	        Sort(a, mid + 1, right);
	        merge(a, left, mid, right);

	    }


	    private static void merge(int[] a, int left, int mid, int right) {
	    	
	        int[] tmp = new int[a.length];
	        int r1 = mid + 1;
	        int tIndex = left;
	         int cIndex=left;
	        // 逐个归并
	        while(left <=mid && r1 <= right) {
	            if (a[left] <= a[r1]) 
	                tmp[tIndex++] = a[left++];
	            else
	                tmp[tIndex++] = a[r1++];
	        }
	            // 将左边剩余的归并
	            while (left <=mid) {
	                tmp[tIndex++] = a[left++];
	            }
	            // 将右边剩余的归并
	            while ( r1 <= right ) {
	                tmp[tIndex++] = a[r1++];
	            }
	            
	            
	           
	            
	            System.out.println("第"+(++number)+"趟排序:\t");
	            //从临时数组拷贝到原数组
	             while(cIndex<=right){
	                    a[cIndex]=tmp[cIndex];
	                    //输出中间归并排序结果
	                    System.out.print(a[cIndex]+"\t");
	                    cIndex++;
	                }
	             System.out.println();
	        }
*/

}
	    


