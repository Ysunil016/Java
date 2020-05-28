package Com.Sunil.Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IgniteCollections {

	public static void main(String[] args) {
		startCollection();
	}

	static void startCollection() {
		List<Integer> list = Arrays.asList(1, 4, 1, 45, 64, 2, 24, 2, 4);

		// Sorting By Default Collections Approach
//		Collections.sort(list);

		// Sorting By Comparator Interface

//		Collections.sort(list, new comparator());

		// Sorting By Annonymus Comparator Interface

		Collections.sort(list, (o1, o2) -> o1 > o2 ? -1 : o1 < o2 ? 1 : 0);

		for (int i : list)
			System.out.println(i);

		System.out.println("Custom Class Comparable");

		List<Node> arrNode = Arrays.asList(new Node(23), new Node(5), new Node(2), new Node(3), new Node(22),
				new Node(9));
		Collections.sort(arrNode);

		for (Node n : arrNode)
			System.out.println(n.data);

	}

	static class comparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return (o1 > o2 ? -1 : o1 < o2 ? 1 : 0);
		}

	}

	static class Node implements Comparable<Node> {
		int data;

		public Node(int data) {
			this.data = data;
		}

		@Override
		public int compareTo(Node o) {
			return (this.data < o.data ? -1 : this.data > o.data ? 1 : 0);
		}
	}

}
