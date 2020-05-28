package Com.Sunil.Set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class IgniteSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		startSet();
	}

	static void startSet() {
		// Default Mostly Used
		// Stores Data in Random Fashion BAsed on HAshing.
		Set<Integer> set = new HashSet<Integer>();
		set.add(1);
		set.add(8);
		set.add(6);
		set.add(4);

		for (int i : set)
			System.out.println(i);

		System.out.println();

		// Stores Data in Sorted Order
		Set<Integer> lSet = new TreeSet<Integer>();
		lSet.add(3);
		lSet.add(6);
		lSet.add(1);
		lSet.add(7);

		for (int i : lSet)
			System.out.println(i);

	}

}
