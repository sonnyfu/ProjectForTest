package Algorithm.structure;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class EntrysetforHashmap {
public static void main(String[] args) {
	HashMap<String,String> kmap = new HashMap<String,String>();
	
    HashMap<String, String> emap = new HashMap<String, String>();
      
    //装数据  
    for (int i = 0; i < 1000; i++)   
    {  
        kmap.put(""+i, "YL");  
    }  
    for (int j = 0; j < 1000; j++)   
    {  
        emap.put(""+j, "ZT");  
    }  
      
    long stimes = System.currentTimeMillis();  
    long ctimes = Calendar.getInstance().getTimeInMillis();  
    long dtimes = new Date().getTime();  
      
    //初始时间 这里我用了三种取值方式 最后发现System.currentTimeMillis();是最直接的取值方法  
    System.out.println(stimes+" "+ctimes+"  "+dtimes);  
      
    Iterator<String> ktor = kmap.keySet().iterator();  
    while(ktor.hasNext())  
    {  
        System.out.println(ktor.next());  
    }  
      
    long stimes1 = System.currentTimeMillis();  
    long ctimes1 = Calendar.getInstance().getTimeInMillis();  
    long dtimes1 = new Date().getTime();  
      
    //结束世界并且也是entrySet的开始时间  
    System.out.println((stimes1-stimes)+"   "+(ctimes1-ctimes)+"    "+(dtimes1-dtimes));  
    System.out.println(stimes1+"    "+ctimes1+" "+dtimes1);  
      
    Iterator<Entry<String, String>> itor = emap.entrySet().iterator();  
    while(itor.hasNext())  
    {  
        Entry<String, String> e = itor.next();  
        //System.out.println(e.getKey());  
        System.out.println(e.getValue());  
    }  
      
    long stimes2 = System.currentTimeMillis();  
    long ctimes2 = Calendar.getInstance().getTimeInMillis();  
    long dtimes2 = new Date().getTime();  
    System.out.println(stimes2+"    "+ctimes2+" "+dtimes2);  
    System.out.println((stimes2-stimes1)+"  "+(ctimes2-ctimes1)+"   "+(dtimes2-dtimes1));
}  
}