package compet;
/* 输入：东西及其重量w[i],价值v[i]背包最大重量W;
 * 处理：
 * 初始化状态
 * 		pw背包重量0，pv价值0
 * 递归放入，不放入
 *
 * 二叉树先序遍历原理输出最优解
 * 输出:          
 * 变量：
 * 1、递归中的变量及函数值独立包含在每一层的每一个函数中
 * 2、局部变量必须要赋值，如在递归过程不用另外变量，则可以把参数全写到小括号里面
 * */


public class Pack011 {

	static int maxV=0;
	//x[]存放最终解,op[]为临时解,即记录选中的物品

	static void lay(int pv,int pw,int w[],int v[],int i,int W,int maxW,int op[],int x[]){
		int j;
		//通过在最后叶子结点选择最优解
		if(i>=w.length){
			if(pw<=W&&pv>maxV){
				maxW=pw;
				maxV=pv;
				for(j=0;j<w.length;j++){
					x[j]=op[j];
				}
			}
		}
		//还有叶子结点未遍历到
		else{
			op[i]=1;
			lay(pv+v[i], pw+w[i], w, v, i+1, W, maxW,op,x);
			op[i]=0;
			lay(pv, pw, w, v, i+1, W, maxW,op,x);
		}
	}
	
	public static void main(String[] args) {
		int pv=0;
		int pw=0;
		int W=7;
		int w[]={5,3,2,1};
		int v[]={4,4,3,1};
		int maxW=0;
		int op[]=new int[w.length];
		int x[]=new int[w.length];
		
		for(int i=0;i<w.length;i++)
			op[i]=0;
		lay(pv, pw, w, v, 0, W, maxW, op,x);
		for(int i=0;i<w.length;i++)
			System.out.print(x[i]+" ");
	}
	
	
}
