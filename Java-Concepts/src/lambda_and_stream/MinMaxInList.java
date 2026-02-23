package lambda_and_stream;
// Find maximum/minimum in list

import java.util.Arrays;
import java.util.List;

public class MinMaxInList {
	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(25, 34, 12, 45, 89, 3, 87, 45);

//		Optional<Integer> max = integers.stream().max(Integer::compare);
//		Optional<Integer> max = integers.stream().max(Integer::compareTo);
		int max = integers.stream().mapToInt(Integer::intValue).max().orElseThrow();
		System.out.println("Max: " + max);

		int min = integers.stream().mapToInt(Integer::intValue).min().orElseThrow();
		System.out.println("Min: " + min);

	}
}
