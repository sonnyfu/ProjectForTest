package compet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class minmax {

	
	/**10,10,10,10,10,10
	 * 6
	 * 3，6，13，34，25，45
	 * 输入：n，
	 * 处理：
	 * 排序；遍历相邻的数，用min记录最小值；用map，key为差，value为个数（+1地改变）；
	 * 先1，取出再加1；
	 * 倒数地减去num[0],max记录最大值；用map,ke
	 * 输出：n位数两两组合的绝对值的最小值及其位数；
	 * Z：输入，描述——自己（做或没做过的）的解决办法，输出；
	 * @param args
	 */
	static void minmax(){
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int num[]=new int[n];
		for(int i=0;i<n-1;i++)
			num[i]=sc.nextInt();
		Arrays.sort(num);
		int min=Integer.MAX_VALUE;
		HashMap<Integer, Integer> minnum=new HashMap<>();
		//如果
		//
		for(int i=1;i<n;i++)
			min=Math.min(min,num[i]-num[i-1]);
		for(int i=1;i<n;i++){
			int value=num[i]-num[i-1];
			if(minnum.get(value)!=null)
				minnum.put(value,minnum.get(value)+1);
			else
				minnum.put(value,1);
		}
		
		int max=num[n-1]-num[0];
		HashMap<Integer, Integer> maxnum=new HashMap<>();
		for(int i=n-1;i>0;i--){
			max=Math.max(max,num[i]-num[i-1]);
			if(maxnum.get(max)!=null)
				minnum.put(max,minnum.get(min)+1);
			else
				minnum.put(max,1);
		}
		
		System.out.println(min+" "+minnum.get(min));	
		//System.out.println(max+" "+maxnum.get(max));	
		
	}
	
	
	public static void main(String[] args) {
		minmax();
	}

}
