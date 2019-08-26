package Think_In_Java.base.JavaSe.extend;

import java.lang.reflect.Array;

public class A{
	Object a=new Object();
    public String show(D obj){  
        return ("A and D");  
 }   
 public String show(A obj){  
        return ("A and A"); 
        
 }  
 
 static void reflect(Class<?> class1){
	 System.out.println((Object)class1==(Object)Object.class);
 }
 
 public static void main(String[] args) {
	int a[]={};//new int[5];
	A aRef=new A();
	//a[0]=1;//不能像C++动态赋值了
	System.out.println(A.class);
	reflect(aRef.a.getClass());
	System.out.println(Integer.MAX_VALUE+1);
	//Array.newInstance(null, 0);//通过这个方法重新赋值
	
}
}
