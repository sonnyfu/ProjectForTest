package newcoder;

/**
 * 排序
 * @author sonny
 *
 */
public class SortUtil {
	
	
	/*************n^2复杂度排序*****************/
	/**
	 * 选择排序
	 * 将0~n-1中的min放0，以此1~n-1类推得到
	 * @param a
	 * @return
	 */
	int[] chooseSort(Integer[] a){
		
		return null;
	}

	/**
	 * 插入排序
	 * 取前一个数和前面几个数比较，然后位移和插入
	 * @param a
	 * @return
	 */
	static Integer[] insertSort(Integer[] a){
		
		for(int i=1;i<a.length;i++){
			int j=i-1;
			int i_int=a[i];
			//得出插入的位置
			for(;j>=0;){
				if(a[i]<=a[j]){
					j--;
				}else
					break;
			}
			for(int k=i;k>j+1;)
				a[k]=a[--k];
			a[j+1]=i_int;
		}
		return a;
		
	}
	
	/*************nlog2N复杂度排序*****************/
	/**
	 * 归并排序
	 * 
	 * log2N趟，每趟消耗N时间
	 * @param a
	 * @param beg
	 * @param end
	 */
	static void mergeSort(Integer[] a,Integer beg,Integer end){
		if(beg.equals(end))
			return;
		Integer mid=(beg+end)/2;
		mergeSort(a, beg, mid);
		mergeSort(a, mid+1, end);
		merge(a,beg,mid,end);
	}
	
	static void merge(Integer[] a, Integer beg, Integer mid,Integer end){
		int left_min_num=end-beg+1;
		Integer[] con=new Integer[left_min_num];

		int beg_int=beg;
		int left=0;
		int mid_tmp=mid+1;
		while(beg<=mid&&mid_tmp<=end){
			if(a[beg]<=a[mid_tmp]){
				con[left++]=a[beg++];
			}else
				con[left++]=a[mid_tmp++];
		}
		for(;beg<=mid;left++,beg++)
			con[left]=a[beg];
		for(;mid_tmp<=end;left++,mid_tmp++)
			con[left]=a[mid_tmp];		
		for(int i=beg_int,j=0;left_min_num-->0;i++,j++)
			a[i]=con[j];
	}
	/**
	 * 快速排序
	 * 默认找第一个数为基准，小于等于区间数下标i为0
	 * 和末尾数交换
	 * 从左到右遍历，小于等于基准数和下标为i++交换，大于则跳过，最后末尾数和下标为i++的交换，返回基准瞎下标
	 * 一分为二递归以上步骤
	 * @param a
	 * @param beg
	 * @param end
	 */
	static void quickSort(Integer[] a,Integer beg,Integer end){
		if(beg>=end)
			return;
		Integer base=partition(a,beg,end);
		quickSort(a, beg, base-1);
		quickSort(a, base+1,end);
	}
	
	static Integer partition(Integer[] a, Integer beg, Integer end) {
		int min_point=beg;
		swap(a,beg,end);
		for(int i=beg;i<end;i++){
			if(a[i]<=a[end]){
				swap(a, i, min_point++);
			}else
				continue;
		}
		swap(a, min_point, end);	
		return min_point;
	}
	
	static void swap(Integer[] a, Integer mid, Integer end) {
		Integer tmp=a[mid];
		a[mid]=a[end];
		a[end]=tmp;
	}
	
	/**
	 * 堆排序
	 * 创建大顶堆；
	 * 分离（交换）；
	 * 重新调整（n-1）；
	 * @param a
	 */
	private static void st_heapSort(Integer[] a){
		for(int i=(a.length/2)-1;i>=0;i--)
			st_adjustHeap(a, i, a.length-1);
		
		for(int j=a.length-1;j>=0;j--){
			swap(a, 0, j);
			st_adjustHeap(a, 0, j-1);
		}
			
		
	}
	
	static	void st_adjustHeap(Integer[] a,int root,int limit){
		//保存可能交换的值,因为该值会从上到下被交换，直到break;
		int rootValue=a[root];
		
		for(int i=2*root+1;i<=limit;i*=2+1){
			if(i<limit&&a[i+1]>a[i])
				i++;
			//循环停止
			if(rootValue>=a[i])
				break;
			a[root]=a[i];
			//保存较大值的索引
			root=i;
		}
		a[root]=rootValue;
	}
	
	
	/**
	 * 堆排序（o（n^2）解法）
	 * 利用完全二叉树及其性质（从上倒下，左到右的第一个父节点为length/2,和子节点成倍数关系）建立大顶堆
	 * n和0对应的数交换循环可得
	 * @param a
	 */
	private static void heapSort(Integer[] a){
		for(int i=0;i<a.length;i++){
			for(int j=(a.length-i)/2-1;j>=0;j--)
				adjustHeap(a,j,i);
			swap(a, 0, a.length-1-i);
		}
	}
	
	static	Integer adjustHeap(Integer[] b,int root,int order){
		int limit=b.length-order-1;
		if(2*root+1>limit)
			return null;
		
		if(b[2*root+1]>=b[root])
			swap(b, root, 2*root+1);
		
		if(2*root+2>limit)
			return null;
		else
			if(b[2*root+2]>=b[root])
				swap(b, root, 2*root+2);
		return b[root];
	}
	
	/**
	 * shell排序：
	 * （但步长满足一个数学公式时）时间复杂度n^3/2,好于n^2
	 * 在插入排序基础上改进的（数量少和基本有序），因此设计步长概念，其实步长为1时，过程类似冒泡排序
	 * @param a
	 */
	void shellSort(Integer[] a){
		
	}
	
	/**
	 * 荷兰（红白蓝对应0,1,2）国旗问题
	 * 类似快排分区逻辑，增加了大值区间的下标变量max
	 * @param a
	 */
	//0,1,2,0,1,2,2,1,1,0
	static void hollandSort(Integer a[]){
		int i=0,min=0,max=a.length-1;
		while(i<=max){
			if(a[i]==0){
				swap(a, min++, i++);
			}else if(a[i]==1){
				i++;
				continue;				
			}else if(a[i]==2){
				swap(a, i, max--);
			}
		}
	}
	
	/**
	 * 待排序最短子数组的长度{
	 * 如1,3,2,5,6,7最短的是3,2,5,其他待排序数组有3,2,5,6
	 * 
	 * }
	 * @param a
	 * @return
	 */
	static Integer shortestUnSortedArray(Integer[] a){
		
		int left_max=a[0];
		int left_point=0;
		for(int i=1;i<a.length;i++){
			if(a[i]>=left_max)
				left_max=a[i];
			else
				left_point=i;
		}
		int right_min=a[a.length-1];
		int right_point=0;
		for(int j=a.length-1;j>0;j--){
			if(a[j]<=right_min)
				right_min=a[j];
			else
				right_point=j;			
		}
		return left_point-right_point+1;	
	}
	
	/**
	 * 计数排序
	 * @param a 身高(cm)数组
	 * @return 
	 */
	static Integer[] countSort(Integer a[]){
		int minH=a[0],maxH=a[a.length-1];
		for(int i=0;i<a.length;i++){
			if(minH>a[i])
				minH=a[i];
			if(maxH<a[i])
				maxH=a[i];
		}
		//记录每个桶的数量
		int[] bucket=new int[maxH-minH+1];
		for(int i=0;i<a.length;i++){
			bucket[a[i]-minH]++;
		}
		//下标+minh等于身高
		int k=0;
		for(int i=0;i<maxH-minH+1;i++){
			for(int j=bucket[i];j>0;j--)
				a[k++]=i+minH;
		}
		return a;
	}
	
	
	static void radixSort(String[] s){
		
	}
	
	static int findMinInSList(Integer a[]){
		return 0;
	}
	
	public static void main(String[] args) {
		//System.out.println(insertSort(new Integer[]{1,1,1,1,0}));
/*		final Integer[] a={0,3,2,5,1,1,7};
		mergeSort(a, 0, a.length-1);
		Integer[] b = a;*/
		
/*		final Integer[] a_1={4,5,3,1,0};
		quickSort(a_1, 0, a_1.length-1);
		Integer[] b_1 = a_1;
		*/

/*		final Integer[] a_2={3,1,0,9,8,4};
		heapSort(a_2);
		Integer[] b_2 = a_2;*/
		
/*		final Integer[] a_3={3,9,8,4,1,0};
		st_heapSort(a_3);
		Integer[] b_3 = a_3;*/
		
/*		final Integer[] a_4={0,1,2,0,1,2,2,1,1,0,1,0,2,1,2,2,1,1};
		hollandSort(a_4);
		Integer[] b_4 = a_4;	*/	
		
/*		final Integer[] a_5={1,3,2,4,5,6};
		Integer b_5=shortestUnSortedArray(a_5);*/
		
		final Integer[] a_6={101,105,123,144,153,164};
		Integer[] b_6=countSort(a_6);
		
		//测试&&运算
		Integer[] a=new Integer[2];
		if(a.length>2&&a[3]==null)
			System.out.println("");
		else
			System.out.println("从左到右运算，左边不满足右边不执行，");
		//测试加减乘除优先级
		int i=1;
		System.out.println(i*=2+1);
	}	
	
}
