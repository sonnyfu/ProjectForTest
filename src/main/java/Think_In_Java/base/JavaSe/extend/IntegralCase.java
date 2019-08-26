package Think_In_Java.base.JavaSe.extend;

import java.util.ArrayList;

class Base{
	
	
	
	public Base() {
		System.out.println("父类无参构造函数");
	}

	public Base(int x) {
		System.out.println("父类有参构造函数");
	}
}

public class IntegralCase extends Base {

	public IntegralCase() {
		super(2);
		System.out.println("子类无参构造函数");
	}

	public IntegralCase(int x) {
		super(x);
		System.out.println("子类有参构造函数");
	}

	/**
	 * 
	 * 
	 * class A1 extends A{
	 * 
	 * @Override void test() {
	 * 
	 *           }
	 * 
	 *           }
	 * 
	 *           interface AI{}
	 * 
	 *           public abstract class A implements AI{ public String show(D
	 *           obj){ return ("A and D"); } public String show(A obj){ return (
	 *           "A and A"); }
	 * 
	 *           abstract void test(); }
	 * 
	 */

	public static void main(String args[]) {
		ArrayList<Integer> arrayList;
		IntegralCase t = new IntegralCase();// (1)
		IntegralCase t2 = new IntegralCase(2);// (2)
	}

}
