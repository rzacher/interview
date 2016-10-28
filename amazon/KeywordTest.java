package amazon;

public class KeywordTest {
	public enum Day {MONDAY, TUESDAY, WEDNESDAY}
	
	public static void enumTest() {
		System.out.println("Printing enum for " + Day.MONDAY);
	}

	public static void testInstanceOf() {
		String foo = new String();
		if (foo instanceof String) {
			System.out.println("Found a string");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		enumTest();
		testInstanceOf();
	}

}
