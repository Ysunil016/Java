package StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MapReduce {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

//		Predicate<Integer> predicate = new Predicate<Integer>() {
//
//			@Override
//			public boolean test(Integer t) {
//				if (t.intValue() % 2 == 0)
//					return true;
//				return false;
//			}
//		};

		// Single Threaded Iteration Procedure - list.stream()
		// Concurrent Approach Multi-Core Utilisation Approach - list.parallelStream()

//		list.stream().filter(predicate).forEach((i) -> {
//			System.out.println(i);
//		});

		// Map and Reduce to Calculate the Sum, Required by StreamAPI
//		Function<Integer, Integer> map_fun = new Function<Integer, Integer>() {
//
//			@Override
//			public Integer apply(Integer t) {
//				return 2 * t.intValue();
//			}
//		};

		// Binary Operator Interface Required by StreamAPI
//		BinaryOperator<Integer> bOps = new BinaryOperator<Integer>() {
//
//			@Override
//			public Integer apply(Integer t, Integer u) {
//				return t + u;
//			}
//		};

		Optional<Integer> listValue = list.parallelStream().map((i) -> 2 * i).reduce((c, e) -> c + e);
		System.out.println(listValue.get());

		// Filter for Passing Only ELements that are Divisible by 3
		Optional<Integer> listFilterValue = list.parallelStream().filter((i) -> i % 3 == 0).reduce((c, e) -> c + e);
		System.out.println(listFilterValue.get());

		// Filter for Passing Only ELements that are Divisible by 3 and Mapping It as
		// Multiple by 5
		Optional<Integer> listFilterValueMap = list.parallelStream().filter((i) -> i % 3 == 0).map((i) -> i * 5)
				.reduce((c, e) -> c + e);
		System.out.println(listFilterValueMap.get());

		// FindFirst
		Integer listFilterValueMapFindFirst = list.stream().filter((i) -> i % 3 == 0).map((i) -> i * 5).findFirst()
				.orElse(0);
		System.out.println(listFilterValueMapFindFirst);

	}

}
