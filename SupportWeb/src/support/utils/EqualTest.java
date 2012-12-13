package support.utils;

import java.util.HashSet;
import java.util.Set;

public class EqualTest {
	private String name;

	public EqualTest(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		EqualTest equalTest = (EqualTest) o;

		if (name != null ? !name.equals(equalTest.name)
				: equalTest.name != null)
			return false;

		return true;
	}

	public String toString() {
		return "EqualTest{" + "name='" + name + '\'' + '}';
	}

	public int hashCode() {
		return (name != null ? name.hashCode() : 0);
	}

	public static void main(String[] args) {
		EqualTest equalTest = new EqualTest("jason");

		Set<EqualTest> set = new HashSet<EqualTest>();
		set.add(equalTest);
		EqualTest equalTest2 = new EqualTest("jason");
		if (set.contains(new EqualTest("jason"))) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		
		if(equalTest == equalTest2){
			System.out.println("true");
		} else {
			System.out.println("false");
		}

	}
}
