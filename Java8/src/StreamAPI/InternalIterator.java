package StreamAPI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class InternalIterator {

	public static void main(String[] args) {
		internalIterator();
	}

	static void internalIterator() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

		// Iteration can be Done though -

		// External -- Normal For Loop
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));

		System.out.println();

		// External -- Enhanced For Loop
		for (int i : list)
			System.out.println(i);

		System.out.println();

		// Internal -- ForEach Loop
		Iterator<Integer> iterate = list.iterator();

		// Using Lamda Expression, Since Consumer is a Functional Interface.
		iterate.forEachRemaining(data -> System.out.println(data));

		System.out.println();
		iterate = list.iterator();

		// Actual Implementation of Internal Iterator using Consumer Interface
		iterate.forEachRemaining(new Consume());

		System.out.println();
		iterate = list.iterator();
		System.out.println();

		// We can Also do this with Annonymus Functional Programming as
		iterate.forEachRemaining(new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.print("->>" + t);
			}
		});

	}

	static class Consume implements Consumer<Integer> {

		@Override
		public void accept(Integer t) {
			System.out.print(":: " + t);
		}

	}

}
