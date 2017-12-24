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
	
	//����⿼�������
	//������һ�����ֳ���������̫�����ˣ�ԭ���ǿ��ŵı��֣�����д�˳��򣬺���������֪���ˣ��϶����������λ�ò��������������Ϊ���ű�����ǲ��ȶ����㷨���ȶ���Ч�������㷨���õ�ֻ�й鲢�ˣ�����Ҳ�ǲ��ȶ��ġ����ԣ��ù鲢�����˼�����Ϻ��ʡ�ʱ�临�Ӷȵ͡��������£�

	public class Solution {
	    public void reOrderArray(int [] array) {
	        //ע�͵Ĳ���ʹ�ÿ���������㷨�������Կ��������ǲ��ȶ��ģ�������Ҫ�ù鲢����
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
	       
	        //���ù鲢�����˼�룬��Ϊ�鲢�������ȶ���
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
