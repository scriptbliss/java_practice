// Filter numbers greater than 50

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterNum {
	public static void main(String[] args) {
		List<Integer> integers = List.of(2, 45, 5, 378, 10, 23, 58, 34, 70);

		Set<Integer> uniqueNums = integers.stream().filter(num -> num > 50).collect(Collectors.toSet());

		uniqueNums.forEach(System.out::println);
	}
}
