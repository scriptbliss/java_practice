// Group elements by condition

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GroupElements {
	private static void printGroupedMyObjList(Map<Boolean, List<MyObj>> groupedList) {

		Consumer<MyObj> printMyObjConsumer = System.out::println;
		BiConsumer<Boolean, List<MyObj>> biConsumer = (Boolean b, List<MyObj> listMyObj) -> {
			System.out.println(b ? "Even" : "Odd");
			listMyObj.forEach(printMyObjConsumer);
		};

		groupedList.forEach(biConsumer);
	}

	public static void main(String[] args) {
		List<MyObj> objList = Arrays.asList(new MyObj(7, "GHI"), new MyObj(2, "BCD"), new MyObj(6, "FGH"),
				new MyObj(4, "DEF"), new MyObj(5, "EFG"), new MyObj(1, "ABC"), new MyObj(3, "CDE"));

//		SORTING - START
//		Function<MyObj, Integer> comparingFn = obj -> obj.getId();
//		objList.sort(Comparator.comparing(comparingFn));
//		objList.sort(Comparator.comparing(MyObj::getId));
//		objList.sort();
		Collections.sort(objList, Comparator.comparingInt(MyObj::getId));
//		SORTING - END

//		GROUPING (can have multiple groups)
		Function<MyObj, Boolean> classifierFunction = obj -> obj.getId() % 2 == 0;
		Map<Boolean, List<MyObj>> groupedList = objList.stream().collect(Collectors.groupingBy(classifierFunction));
		printGroupedMyObjList(groupedList);
//		GROUPING (can have multiple groups)

		System.out.println();

//		PARTITIONING 
		Predicate<MyObj> partitionerPredicate = obj -> obj.getId() % 2 == 0;
		Map<Boolean, List<MyObj>> groupedList2 = objList.stream()
				.collect(Collectors.partitioningBy(partitionerPredicate));
		printGroupedMyObjList(groupedList2);
//		PARTITIONING 
	}
}
