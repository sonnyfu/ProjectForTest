package structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Hashmap {
	public static void main(String[] args) {
	    List<List<String>> result = new ArrayList<List<String>>();
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs){
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++){
	            arr[str.charAt(i)-'a']++;
	        }
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        }else{
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	    
	    List<String> res=new ArrayList<>();
	    Iterator it=map.entrySet().iterator();
	    while(it.hasNext()){
	    	Map.Entry entry=(Entry) it.next();
	    	List<String> r=(List<String>) entry.getValue();
	    	if(r.size()>1)
	    		res.addAll(r);
	    }	
	}
}
