package Algorithm.structure;

public class HeapSort {
	//
	static void heapS(int a[]){
		//
		for(int j=a.length-1;j>=1;j--){
			heapSPrint(a, 0,j);
		}
		for(int j=a.length-1;j>=0;j--){
			System.out.println(a[j]);
		}
		
	}
	
	static void heapSPrint(int a[],int l,int r){
		int n;
		if(r%2==0)n=(l+r)/2-1;
		else n=(l+r)/2;
		for(int i=n;i>=0;i--){
			if(a[i]>a[2*i+1])
				swap(a, i, 2*i+1);
			if(2*i+2>r) continue; 
			else if (a[i]>a[2*i+2]) 
				swap(a, i, 2*i+2);
		}
		swap(a, 0, r);
	}
	static void swap(int a[],int l,int r){
		int tmp=a[l];
		a[l]=a[r];
		a[r]=tmp;
	}
	
	public static void main(String[] args) {
		int a[]={5,1};
		heapS(a);
	}
}

