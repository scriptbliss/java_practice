// Remove duplicates from list

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class RemoveDuplicatesFromList {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>(List.of("Sachin", "Er", "Sachin"));

//		list.stream().forEach(System.out::println);

		Set<String> seen = new HashSet<>();
		list.removeIf(e -> !seen.add(e));
		list.forEach(System.out::println);
	}
}
