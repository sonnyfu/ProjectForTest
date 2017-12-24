package Algorithm.company.ITkuOffer;

import java.util.ArrayList;

public class ClockWisePrint {
	 static ArrayList<Integer> clockWisePrint(int matrix[][]){
		if(matrix==null||matrix.length==0) return null;
		int l=matrix.length;
		int r=matrix[0].length;
		ArrayList<Integer> result=new ArrayList(l*r);
		int left=0,top=0,right=matrix.length-1,bottom=matrix[0].length-1;
		while(left<=right&&top<=bottom){
			for(int i=top;i<=bottom;i++)
				result.add(matrix[left][i]);
			for(int i=left+1;i<=right;i++)
				result.add(matrix[i][bottom]);
			if(left!=right)
				for(int i=bottom-1;i>=top;i--)
					result.add(matrix[right][i]);
			if(top!=bottom)
				for(int i=right-1;i>left;i--)
					result.add(matrix[i][top]);

			left++;top++;right--;bottom--;
		}
		return result;
	}
	 
	 public static void main(String[] args) {
		int a[][]={{1,2},{3,4}};
		clockWisePrint(a);
	}
}
