package newcoder;

/**
 * Created by sonny on 2017/12/21.
 */
public class BinarySearch {

    static boolean recurBinarySearch(Integer[] a,Integer e,int min,int max){
        if (min>max)
            return false;
        int mid=(min+max)/2;
        if(a[mid].equals(e))
            return true;
        else if(a[mid]>e)
            return recurBinarySearch(a,e,min,mid-1);
        else
                return recurBinarySearch(a,e,mid+1,max);
}

    static boolean classicBinarySearch(Integer[] a,Integer e){
        if (a==null)
            return false;
        int min=0,max=a.length-1;
        while(min<=max){
            int mid=(min+max)/2;
            if(a[mid].equals(e))
                return true;
            else if(a[mid]>e)
                max=mid-1;
            else
                min=mid+1;
        }
        return false;
    }

    public  static  void  main(String[] args){
        Integer a[]={1,3,5,6};
        if(classicBinarySearch(a,0))
            System.out.println("yes");
        else
            System.out.println("no");
        if(recurBinarySearch(a,6,0,3))
            System.out.println("yes");
        else
            System.out.println("no");
    }
}
