package lambda_and_stream;
// Find sum of all even numbers in array

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class EvenNumSum {

	public static void main1(String[] args) {
		List<Integer> integers = Arrays.asList(2, 45, 5, 10, 23, 34);

		Predicate<Integer> isEvenPredicate = num -> num % 2 == 0;

		int result = integers.stream().filter(isEvenPredicate).reduce(0, (a, b) -> a + b);
		System.out.println("Sum of all even numbers in array: " + result);
	}
}
