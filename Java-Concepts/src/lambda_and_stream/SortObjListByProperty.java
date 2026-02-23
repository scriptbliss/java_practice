package lambda_and_stream;
// Sort list of objects by property

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class MyObj {
	private int id;
	private String nameString;

	public MyObj(int id, String str) {
		this.id = id;
		nameString = str;
	}

	public int getId() {
		return id;
	}

	public String getNameString() {
		return nameString;
	}

	@Override
	public String toString() {
		return "MyObj [id=" + id + ", nameString=" + nameString + "]";
	}
}

public class SortObjListByProperty {
	public static void main(String[] args) {
		List<MyObj> objList = Arrays.asList(new MyObj(7, "GHI"), new MyObj(2, "BCD"), new MyObj(6, "FGH"),
				new MyObj(4, "DEF"), new MyObj(5, "EFG"), new MyObj(1, "ABC"), new MyObj(3, "CDE"));

//		objList.sort(Comparator.comparing(o -> o.nameString));
		objList.sort(Comparator.comparing(MyObj::getNameString));
		objList.stream().forEach(System.out::println);

//		objList.stream().sorted((a, b) -> a.nameString.compareTo(b.nameString)).forEach(System.out::println);

	}
}
