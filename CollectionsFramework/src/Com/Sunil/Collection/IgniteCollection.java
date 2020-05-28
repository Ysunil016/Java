package Com.Sunil.Collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class IgniteCollection {

	public static void main(String[] args) {
		startCollecting();
	}

	public static void startCollecting() {
		// No Generics
//		Collection collection = new ArrayList<>();

		// With Generics
		Collection<Integer> collection = new ArrayList<>();
		collection.add(1);

		Collection<Integer> collection2 = new ArrayList<Integer>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			{
				add(1);
				add(3);
				add(1);
				add(3);
				add(1);
				add(3);
			} // Instantiation
		}; // Anonymus Function

		Collection<Integer> collection3 = Arrays.asList(1, 2, 3, 4);

		for (int i : collection)
			System.out.println(i);

		for (int i : collection2)
			System.out.println(i);

		for (int i : collection3)
			System.out.println(i);

	}
	
//	Collection has List, Set, Map Interfaces that Extends It;
	
//	We Cannot Sort Collection as It Doesn't has Index Based Element Access Functions.
	
}
