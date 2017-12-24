package Algorithm.company.ITkuOffer;

public class BitCompute {
	
	
	public static void main(String[] args) {
		/**
		 * 计算机组成原理：
		 * 1、机器数：正数（最高位（也叫形式位）为0），负数的为1
		 * 2、真值：如一个字节的机器数为1000 0011的数，真值为3，非131
		 * 3、计算机用加法器来做减，乘，除的运算：最后结果要求的是原码的真值
		 * （提示：反码和补码是为了解决减法-+符号问题而产生的中间值）
		 */
		
		System.out.println(~1);//-2
		/*
		 * 32位 0000 0000 0000 0000 0000 0000 0000 0001(1的补码)
		 * 取反 1111 1111 1111 1111 1111 1111 1111 1110 
		 * 为了知道上述二进制代表的真实大小 减一得反码：
		 *     1111 1111 1111 1111 1111 1111 1111 1101
		 * 取反(符号为不变)得原码 ：
		 *     1000 0000 0000 0000 0000 0000 0000 0010 这即是-2的原码
		 * 
		 */
	}

}
