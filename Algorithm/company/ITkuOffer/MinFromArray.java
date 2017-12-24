package Algorithm.company.ITkuOffer;

public class MinFromArray {
	
	public  int getMin(int[] array) {
		int beg = 0, mid;
		// Boolean flag = false;
		int end = array.length - 1;
		 while (beg < end) {
			mid = (beg + end) / 2;
			if (array[mid] >= array[beg]) {
			    beg = mid + 1;
			}

			else {
				// if(array[mid]>=array[beg])
				end = mid - 1;
			}
		}
		return array[beg];
	}
	
	static int getMinForTranArr(int[] array){
		if(array==null) return 0;
		int beg=0,end=array.length-1,mid=(beg+end)/2;
		while(array[beg]>=array[end]){
			if(end-beg==1){
				return array[end];	
			}
			else if(array[beg]==array[end]&&array[mid]==array[end])
			return repeteSit(array,beg,end);
			mid=(beg+end)/2;
			if(array[mid]>=array[beg])
				beg=mid;
			else if(array[mid]<=array[end])
				end=mid;
		}//在里面结束或外面结束
			return array[beg]; 
	}
	
	static int repeteSit(int[] array,int beg,int end){
		int result=array[beg];
		for(int i=beg+1;beg<=end;i++){
			if(array[i]>result)
				result=array[i];
		}
		return result;
	}
	

	public static void main(String[] args) {
/*		int a[] = { 6,5,0,1, 2, 3, 4 };//算法1用例1
		System.out.println(getMin(a));*/
		
		int a1[] = { 5,6,0,1, 2, 3, 4 };//算法2功能测试1
		int a2[] = { 2,2,2,4,2,2,2 };
		int a3[] = { 2,2,2,1,2,2,2 };
		int a4[] = { 0,1, 2, 3, 4 };//边界测试2
		//特殊测试null
		System.out.println(getMinForTranArr(a1)+" "+getMinForTranArr(a2)+" "+getMinForTranArr(a3)+" "+getMinForTranArr(a4)+" "+getMinForTranArr(null));
		
		//

	//System.out.println(a1);
	}
}
