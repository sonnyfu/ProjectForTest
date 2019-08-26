package Algorithm.compet;

public class Pack01 {    
            static int W = 6;
        	static int[] w_arr = new int[] { 3, 4, 2 };
        	static int[] p_arr = new int[] { 4, 5, 3 };
        	static int[][] v;

        	public static void main(String[] args) {
        		// TODO Auto-generated method stub
        		//动态规划 填表
        		cal();
        		
        		System.out.println();
        		
        		//改进版 动态规划
        		k();
        	}

        	static void k()
        	{
        		int[] b=new int[W+1];
        		//boolean[] m=new boolean[w_arr.length];
        		for(int i=0;i<w_arr.length;i++)
        		{
        			for(int j=W;j>=w_arr[i];j--)
        			{
        				//b[j]= Math.max(b[j], b[j-w_arr[i]]+p_arr[i]);
        				if(b[j-w_arr[i]]+p_arr[i]>b[j])
        				{
        					b[j] =b[j-w_arr[i]]+p_arr[i];
        				}
        			}
        		}
        		System.out.println("最大价值："+b[W]);
        		/*for(int i=0;i<m.length;i++)
        		{
        			if(m[i])
        				System.out.print(i+" ");
        		}*/
        	}
        	static void cal() {
        		v = new int[w_arr.length + 1][W + 1];

        		for (int j = 1; j < v[0].length; j++) {//下标（数组如果正常初始化，循环从0开始；循环从1开始的话，数组空间加1）容量，这么做为了回溯公式服务的；
        			 for (int i = 1; i < v.length; i++) {//行数；要放的物体个数
        				 if (w_arr[i - 1] > j) {//体积大于单位1的；大于容量限制
                                                //最大价值等于已放入的第i-1个物体的最大价值
           					v[i][j] = v[i - 1][j];
        				  } else {
                                                 //在第i-1个物体是最大价值前提下v[i-1]，（从第i时刻角度考虑要不要放入第i个物体）不大于容纳限制，判断若放入（容纳空间减小）价值是否变大，否则还是原来的最大价值，继续循环
        					 if (v[i - 1][j - w_arr[i - 1]] + p_arr[i - 1] > v[i -  1][j])  {
        						v[i][j] = v[i - 1][j - w_arr[i - 1]] + p_arr[i - 1];
        					} else {
         						v[i][j] = v[i - 1][j];
         					}
        				}
        			}
        		}

        		for (int i[] : v) {
        			for (int j : i) {
        				System.out.print(j + " ");
        			}
        			System.out.println();
        		}
        		int max = v[w_arr.length][W];
        		System.out.println("最大价值："+v[w_arr.length][W]);

        		System.out.print("选取物品编号：");
        		get_solu(W, w_arr.length);

        	}
                //已知最大价值，求编号；
        	static void get_solu(int m, int i) {
        		if (i == 0 || m == 0)
        			return;
                         //第i个物体放入容量为m的最大价值。
        		 if (v[i][m] > v[i - 1][m]) {
                         
        			get_solu(m - w_arr[i - 1], i - 1);
        			System.out.print(i + " ");
        		 } else {
        			get_solu(m, i - 1);
        		}
        	}
              
        }  

