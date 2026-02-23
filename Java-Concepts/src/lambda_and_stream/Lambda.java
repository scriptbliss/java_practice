package lambda_and_stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lambda {

	public static void main(String[] args) {

		// TODO: Create a stream from this array and find numbers > 5
		int[] numbers = { 1, 6, 3, 8, 2, 9, 4, 7, 5 };
		IntStream stream1 = Arrays.stream(numbers);
		IntPredicate checkNumGreaterThan5IntPredicate = num -> num > 5;
		IntConsumer integerPrinterIntConsumer = System.out::println;
		stream1.filter(checkNumGreaterThan5IntPredicate).forEach(integerPrinterIntConsumer);

		Integer[] integers = { 1, 6, 3, 8, 2, 9, 4, 7, 5 };
		Stream<Integer> streamIntegers = Arrays.stream(integers);
		Predicate<Integer> checkNumGreaterThan5Predicate = num -> num > 5;
		Consumer<Integer> integerPrinterConsumer = System.out::println;
		streamIntegers.filter(checkNumGreaterThan5Predicate).forEach(integerPrinterConsumer);

		// TODO: Create an infinite stream of even numbers, take first 10

		// TODO: Process this list to get uppercase names starting with 'A'
		List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

		// Solutions:
		// Arrays.stream(numbers).filter(n -> n > 5).forEach(System.out::println);
		// Stream.iterate(2, n -> n + 2).limit(10).forEach(System.out::println);
		// names.stream().filter(n ->
		// n.startsWith("A")).map(String::toUpperCase).forEach(System.out::println);
	}

	public static void main3(String[] args) {
		List<String> words = Arrays.asList("hello", "world", "java");

		// Basic transformation
		Function<String, String> toUpper = String::toUpperCase;
		words.stream().map(toUpper).forEach(System.out::println);
		// Output: HELLO, WORLD, JAVA

		// Chaining with andThen
		Function<String, Integer> getLength = String::length;
		Function<Integer, String> format = n -> "Length: " + n;
		Function<String, String> lengthFormatter = getLength.andThen(format);
		System.out.println(lengthFormatter.apply("hello")); // "Length: 5"

		// Chaining with compose (reverse order)
		Function<String, String> result = format.compose(getLength);
		System.out.println(result.apply("hello"));
	}

	public static void main2(String[] args) {
		List<String> strList = Arrays.asList("String1", "String22", "String333", "String1", "String4444", "String22",
				"String55555", "String1");

		// using predicate for filtering
		Predicate<String> predicate = str -> str.length() > 8;

		System.err.println("filtered strList: ");
		strList.stream().filter(predicate).forEach(System.out::println);

		System.err.println("strList: ");
		strList.forEach(System.out::println);
		// using predicate for filtering

		// using function instead of predicate for filtering
		Function<String, Boolean> fnFunction = str -> str.length() > 8;

		System.err.println("filtered strList using fn: ");
		strList.stream().filter(fnFunction::apply).forEach(System.out::println);

		System.err.println("strList: ");
		strList.forEach(System.out::println);
		// using function instead of predicate for filtering

	}

	public static void main1(String[] args) {
		List<String> strList = new ArrayList<>();
		strList.add("String1");
		strList.add("String2");
		strList.add("String3");
		strList.add("String4");
		strList.add("String5");

		strList.forEach(System.out::println);
	}
}
