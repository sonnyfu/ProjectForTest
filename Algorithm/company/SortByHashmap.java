package Algorithm.company;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SortByHashmap {

	static void sort(HashMap<String, Integer> src) {

		Map<String, Integer> map = new TreeMap<String, Integer>(new Comparator<String>() {

			public int compare(String obj1,String obj2) {
				// 降序排序
				if (obj1.contains("市") && obj2.contains("市"))
					return 0;
				else if (!obj1.contains("市") && !obj2.contains("市"))
					return 0;
				else if (obj1.contains("市") && !obj2.contains("市"))
					return 1;
				else
					return -1;

				// return obj2.compareTo(obj1);
			}
		});
		
		Set s = src.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String key = (String) entry.getKey();
			Integer value = (Integer) entry.getValue();
			map.put(key, value);
		}
		
		printMap(map);
		
		// return src;
	}

	public static void printMap(Map<String, Integer> map) {
		Set s = map.entrySet();
		Iterator it = s.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String key = (String) entry.getKey();
			Integer value = (Integer) entry.getValue();
			System.out.println(key + " => " + value);
		} // while
	}// printMap
	
	public static void main(String[] args) {
		HashMap<String, Integer> src=new HashMap<>();
		//src.put
		//src.put("库徽省", 3000);
		src.put("广州市", 3000);
		src.put("户州市", 3000);
		src.put("安里省", 3000);
		sort(src);
	}

}
