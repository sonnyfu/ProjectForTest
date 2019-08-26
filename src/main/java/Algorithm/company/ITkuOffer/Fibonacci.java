
package Algorithm.company.ITkuOffer;

public class Fibonacci {
	
	
    public static  int Fibonacci(int n) {
        if(n==0)return 0;
        int f1=1,f2=0,tmp;
        for(int i=0;i<=n-2;i++){
            tmp=f2;
            f2=f1;
            f1=f1+tmp;
        }
        return f1;
    }
	public static void main(String[] args) {
		System.out.println(Fibonacci(3)); 
	}

}
