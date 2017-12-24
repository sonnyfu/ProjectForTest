package newcoder;

/**
 * Created by sonny on 2017/12/23.
 */
public class DynamicPlan {

    static int countExchangeSolu(int money[],Integer aim){
        if(money==null||aim==null)
            return 0;
        return exchange(money,0,aim);
    }

    static  int exchange(int[] money,int moneyIndex,int aim){
        int res=0;
        if(moneyIndex==money.length){
            return aim==0?1:0;
        }

        for(int i=0;i*money[moneyIndex]<=aim;i++)
            res+=exchange(money,moneyIndex+1,aim-i*money[moneyIndex]);
        return res;
    }


    static  int exchange2(int[] money,int aim){
        //省略边界判断
        int[][] soluNum=new int[money.length][aim+1];
        for(int i=1;money[0]*i<=aim;i++){
            soluNum[0][money[0]*i]=1;
        }
        for(int i=0;i<money.length;i++)
            soluNum[i][0]=1;
        //moneyIndex求和
        for(int i=1;i<money.length;i++)
            for(int j=1;j<=aim;j++){
                int num=0;
                for(int k=0;j>=k*money[i];k++)
                    num+=soluNum[i-1][j-k*money[i]];
                soluNum[i][j]=num;
            }
        return soluNum[money.length-1][aim];
    }

    public static  void main(String[] args){
        int[] money={25,25};
        int aim=100;
        System.out.println(countExchangeSolu(money,aim));
        System.out.println(exchange2(money,aim));
}
}
