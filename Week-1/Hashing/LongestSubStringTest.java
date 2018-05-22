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

public class LongestSubStringTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public LongestSubStringTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(LongestSubStringTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testLongestSubstring() {

		// String testInput = "AbCdaBcD";
		// String testInput = "ABBfffgggghhh";
		String testInput = "abcdefaghjcklm";

		int lengthOfLongestSubstring = getLengthOfSubstring(testInput);

		System.out.println(lengthOfLongestSubstring);

		ArrayList<ArrayList<Integer>> anagrams = anagrams(
				Arrays.asList("Buenos Aires", "Córdoba", "La Plata", "cat", "dog", "god", "tca"));

		System.out.println(anagrams);
	}

	private int getLengthOfSubstring(String testInput) {
		int maxSubstringLength = 1;
		int currentLength = 1;
		int numberOfCharacters = testInput.length();
		Integer previousIndex = null;

		HashMap<Character, Integer> characterMap = new HashMap<>();
		characterMap.put(testInput.charAt(0), 0);

		for (int index = 1; index < numberOfCharacters; index++) {
			previousIndex = characterMap.get(testInput.charAt(index));

			if (previousIndex == null || index - currentLength > previousIndex) {
				currentLength++;
			} else {
				if (currentLength > maxSubstringLength) {
					maxSubstringLength = currentLength;
				}
				currentLength = index - previousIndex;
			}
			characterMap.put(testInput.charAt(index), index);
		}

		return Math.max(currentLength, maxSubstringLength);
	}
}
