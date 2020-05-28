package Com.Sunil.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class IgniteList {

	public static void main(String[] args) {
		startList();
	}

	static void startList() {
		@SuppressWarnings("unused")
		Collection<Integer> list = new ArrayList<Integer>(); // No Thread Safe
		Vector<Integer> vectors = new Vector<Integer>(); // High Memory Utilisation
		@SuppressWarnings("unused")
		List<Integer> aList = new ArrayList<Integer>(); // High Cost for Insertion and Deletion
		@SuppressWarnings("unused")
		List<Integer> lList = new LinkedList<Integer>(); // High Cost for Search

		// Vector is ThreadSafe
		// Vector Increases Its Capacity by 100%

		System.out.println(vectors.capacity());

	}

}
