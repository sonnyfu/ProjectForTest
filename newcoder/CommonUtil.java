package newcoder;

/**
 * Created by sonny on 2017/12/15.
 */
public class CommonUtil {
    public static void swapChar(char[] a, Integer mid, Integer end) {
        char tmp=a[mid];
        a[mid]=a[end];
        a[end]=tmp;
    }


    public static void testGVar(Integer[] count){
        if(count[0]==7)
            return;
        count[0]++;
        testGVar(count);
        System.out.println(count);
    }

    public static void testGPrimitiveVar(Integer count){
        if(count==131)
            return;
        count++;
        testGPrimitiveVar(count);
        System.out.println(count);
    }

    public static  void main(String[] args){
/*      Integer[] count=new Integer[]{0};
        testGVar(count);*/
        Integer a=129;
        testGPrimitiveVar(a);
    }

}
