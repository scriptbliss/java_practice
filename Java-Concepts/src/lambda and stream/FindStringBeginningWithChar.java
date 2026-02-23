// Count strings starting with 'A'

import java.util.List;

public class FindStringBeginningWithChar {
	public static void main(String[] args) {
		List<String> strings = List.of("Rohit", "Sachin", "Amit", "Aditya", "Deepak", "Anurag");

		List<String> strStartingWithA = strings.stream().filter(str -> str.charAt(0) == 'A').toList();

		strStartingWithA.forEach(System.out::println);

	}
}
