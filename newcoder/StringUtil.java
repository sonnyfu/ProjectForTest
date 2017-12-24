package newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sonny on 2017/12/15.
 */
public class StringUtil {



    static  String reverseWords(String words){
        char[] wChar=words.toCharArray();
        Integer beg=0,end=wChar.length-1;
        while(end>beg){
            CommonUtil.swapChar(wChar,beg++,end--);
        }

        String[] indexStr=words.split(" ");
        int[] indexArray=new int[indexStr.length-1];

        int index=0;
        for (int i=0;i<wChar.length;i++)
            if(wChar[i]==' ')
                indexArray[index++]=i;

        for(int j=0;j<=indexArray.length;j++){
            if(j==0)
            beg=0;
            else
            beg=indexArray[j-1]+1;
            if(j==indexArray.length)
                end=wChar.length-1;
            else
                end=indexArray[j]-1;
            while (end>beg){
                CommonUtil.swapChar(wChar,beg++,end--);
            }
        }
        return String.valueOf(wChar);
    }

    public static  void  main(String[] args){
        List<Integer> test=new ArrayList<Integer>();
        test.add(1);
        System.out.println(test);


/*       String words="dogs loves pig";
        words=reverseWords(words);
        System.out.println(reverseWords(words));*/

        //字典序测试
/*        if("bba".compareTo("bad")>0)
            System.out.println("大于");
        else
            System.out.println("小于");

        PriorityQueue<Integer> a=new PriorityQueue<Integer>();*/

    }
}
