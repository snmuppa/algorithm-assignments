package fun.algorithms;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AnagramsTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AnagramsTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AnagramsTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testLongestSubstring() {
		ArrayList<ArrayList<Integer>> anagrams = anagrams(
				Arrays.asList("Buenos Aires", "Córdoba", "La Plata", "cat", "dog", "god", "tca"));

		System.out.println(anagrams);
	}

	public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<>();

		LinkedHashMap<String, ArrayList<Integer>> anagramMap = new LinkedHashMap<>();
		for (int index = 0; index < A.size(); index++) {
			String input = A.get(index);
			char[] charArray = input.toCharArray();
			Arrays.sort(charArray);
			String sortedInput = new String(charArray);
			ArrayList<Integer> list = null;

			if (anagramMap.containsKey(sortedInput)) {
				list = anagramMap.get(sortedInput);
			} else {
				list = new ArrayList<>();
			}
			list.add(index + 1);
			anagramMap.put(sortedInput, list);
		}

		for (ArrayList<Integer> anagramGroup : anagramMap.values()) {
			output.add(anagramGroup);
		}

		return output;
	}
}
