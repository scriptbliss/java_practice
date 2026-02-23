package lambda_and_stream;
// Convert list of strings to uppercase

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringListToUppercase {
	public static void main(String[] args) {
		Stream<String> stringStream = Stream.of("hello", "world", "java");

		List<String> uppercaseStrings = stringStream.map(String::toUpperCase).collect(Collectors.toList());

		uppercaseStrings.forEach(System.out::println);
	}
}
