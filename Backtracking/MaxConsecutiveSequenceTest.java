package fun.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MaxConsecutiveSequenceTest extends TestCase {

	/**
	 * Given an unsorted array of integers, find the length of the longest
	 * consecutive elements sequence.
	 *
	 * Example: Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
	 * sequence is [1, 2, 3, 4]. Return its length: 4.
	 *
	 * Your algorithm should run in O(n) complexity.
	 *
	 * @param testName
	 *            name of the test case
	 */
	public MaxConsecutiveSequenceTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(MaxConsecutiveSequenceTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	@SuppressWarnings({})
	public void testMaxSequence() {

		// TEST SETS
		// -6, -4, -5, -2, -3
		// 200, 2, 1, 3, 4, 201, 202, 203, 204, 205, 206, 208, 207
		// -5

		System.out.println("Result: " + longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2))); //
	}

	public class Holder {
		private Integer index;

		private boolean searched;

		public Holder(Integer index) {
			this.index = index;
		}

		public Integer getIndex() {
			return index;
		}

		public boolean getSearched() {
			return searched;
		}

		public void setSearched(boolean searched) {
			this.searched = searched;
		}
	}

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int longestConsecutive(final List<Integer> A) {
		Map<Integer, Holder> indexMap = new HashMap<>();

		int index = 0;
		for (Integer number : A) {
			indexMap.put(number, new Holder(index));
			index++;
		}

		Integer maxCount = 1;
		Integer currentCount = 0;

		for (Map.Entry<Integer, Holder> entry : indexMap.entrySet()) {
			if (!indexMap.get(entry.getKey()).getSearched()) { // DON'T search any values that have been searched
																// already.
				// System.out.println("Entry: " + entry.getKey()); //UNCOMMENT FOR TESTING
				currentCount = deepSearch(indexMap, entry.getKey(), 0);
				maxCount = Math.max(maxCount, currentCount);
				currentCount = 0;
			}
		}

		return maxCount;
	}

	/*
	 * TODO: The following method can have a stack overflow exception as this is an
	 * recursive method over large number of values 1) User iteration to fix this
	 * issue
	 */
	private Integer deepSearch(Map<Integer, Holder> indexMap, Integer searchNumber, Integer currentCount) {
		if (searchNumber > Integer.MIN_VALUE && searchNumber < Integer.MAX_VALUE) {
			Integer plusOneValue = searchNumber + 1;
			Integer minusOneValue = searchNumber - 1;
			if (indexMap.containsKey(plusOneValue) && !indexMap.get(plusOneValue).getSearched()) { // search +1 value if
																									// not searched
				indexMap.get(plusOneValue).setSearched(true);
				currentCount = deepSearch(indexMap, plusOneValue, currentCount + 1);
			}

			if (indexMap.containsKey(minusOneValue) && !indexMap.get(minusOneValue).getSearched()) { // search -1 value
																										// if not
																										// searched
				indexMap.get(minusOneValue).setSearched(true);
				currentCount = deepSearch(indexMap, minusOneValue, currentCount + 1);
			}
		}
		return currentCount;
	}
}
