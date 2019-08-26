package Algorithm.company.ITkuOffer;

public class QExponent {
    public static double Power(double base, int exponent) {
        int exp;
        if(exponent<0){
            if(base==0)throw new RuntimeException("分母不能为0");
            exp=-exponent;
        }
        else if(exponent==0) return 1;
        else{
            exp=exponent;
        }
        double res=1;
            while(exp!=0){
               if((exp&1)==1)
                   res*=base;
                   base*=base;
                exp>>=1;
            }
        return exponent>0?res:(1/res);
    }
    public static void main(String[] args) {
		System.out.println(Power(2,-3));
	}
}
