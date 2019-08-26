package Algorithm.company.ITkuOffer;

public class MoveOdd {
	static int[] move(int []array){
		
		int l=0;
		int r=array.length-1;
		int tmp=0;
		while(l<r){
			while(l<r&&array[l]%2!=0){
				l++;
			}
			while(l<r&&array[r]%2==0){
				r--;
			}
			tmp=array[l];
			array[l]=array[r];
			array[r]=tmp;
		}
		return array;
	}
	
	//这道题考察的排序。
	//这题这一看，分成两部本，太开心了，原来是快排的变种，于是写了程序，后来结果大家知道了，肯定不满足相对位置不变这个条件。因为快排本身就是不稳定的算法，稳定高效的排序算法常用的只有归并了，堆排也是不稳定的。所以，用归并排序的思想解决较合适。时间复杂度低。代码如下：

	public class Solution {
	    public void reOrderArray(int [] array) {
	        //注释的部分使用快速排序的算法，很明显快速排序是不稳定的，这里需要用归并排序
	        /*
	        if(array.length == 0){
	            return;
	        }
	        int high = array.length - 1;
	        int low = 0;
	        while(low < high){
	            while(low < high && array[low] % 2 == 1){
	                low ++;
	            }
	            while(low < high && array[high] % 2 == 0){
	                high --;
	            }
	            int temp = array[low];
	            array[low] = array[high];
	            array[high] = temp;
	        }*/
	       
	        //用用归并排序的思想，因为归并排序是稳定的
	        int length = array.length;
	        if(length == 0){
	            return;
	        }
	        int[] des = new int[length];
	        MergeMethod(array, des, 0,length - 1);
	    }
	    public void MergeMethod(int[] array, int [] des, int start, int end){
	        if(start < end){
	            int mid = (start + end) / 2;
	            MergeMethod(array, des, start, mid);
	            MergeMethod(array, des, mid + 1, end);
	            Merge(array, des, start, mid, end);
	        }
	    }
	   
	    public void Merge(int[] array, int[] des, int start, int mid, int end){
	        int i = start;
	        int j = mid + 1;
	        int k = start;
	        while(i <= mid && array[i] % 2 == 1){
	            des[k++] = array[i++];
	        }
	        while(j <= end && array[j] % 2 == 1){
	            des[k++] = array[j++];
	        }
	        while(i <= mid){
	            des[k++] = array[i++];
	        }
	        while(j <= end){
	            des[k++] = array[j++];
	        }
	       
	        for(int m = start; m <= end; m++){
	            array[m] = des[m];
	        }
	    }
	}
	
	public static void main(String[] args) {
		int a[]={1,2,3,4,5,6};
		a=move(a);
		for(int i=0;i<a.length;i++){
			System.out.println(a[i]+" ");
		}
	}
}
