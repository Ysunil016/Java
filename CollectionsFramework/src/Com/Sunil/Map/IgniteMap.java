package Com.Sunil.Map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class IgniteMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startMap();
	}

	static void startMap() {

		// Generally Used Map
		// Stores Entry in Random Fashion Order
		// Not Thread Safe // Not Synchronized
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(6, 69);
		map.put(3, 39);
		map.put(9, 49);
		map.put(1, 9);

		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			System.out.println(entry.getKey() + " and " + entry.getValue());

		System.out.println();

		// Stores Entry in Insertion Order
		Map<Integer, Integer> lMap = new LinkedHashMap<Integer, Integer>();
		lMap.put(6, 69);
		lMap.put(3, 39);
		lMap.put(9, 49);
		lMap.put(1, 9);

		for (Map.Entry<Integer, Integer> entry : lMap.entrySet())
			System.out.println(entry.getKey() + " and " + entry.getValue());

		System.out.println();

		// Stores Entry in Sorted Order
		Map<Integer, Integer> tMap = new TreeMap<Integer, Integer>();
		tMap.put(6, 69);
		tMap.put(3, 39);
		tMap.put(9, 49);
		tMap.put(1, 9);

		for (Map.Entry<Integer, Integer> entry : tMap.entrySet())
			System.out.println(entry.getKey() + " and " + entry.getValue());

		System.out.println();

		// Stores Entry in Random Fashion Order
		// Thread Safe // Synchronized
		Map<Integer, Integer> hMap = new Hashtable<Integer, Integer>();
		hMap.put(6, 69);
		hMap.put(3, 39);
		hMap.put(9, 49);
		hMap.put(1, 9);
		hMap.put(4, 69);
		hMap.put(23, 39);
		hMap.put(43, 49);

		for (Map.Entry<Integer, Integer> entry : hMap.entrySet())
			System.out.println(entry.getKey() + " and " + entry.getValue());

	}

}
