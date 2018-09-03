package algorthims.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CombinationSumTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CombinationSumTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CombinationSumTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (numbers == null || numbers.size() == 0) {
            return result;
        }
        Collections.sort(numbers);

        ArrayList<Integer> currentList = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        combinationSum(numbers, target, 0, currentList, result, set);

        return result;
    }

    public static void combinationSum(ArrayList<Integer> numbers, int target, int index, ArrayList<Integer> currentList,
            ArrayList<ArrayList<Integer>> result, HashSet<ArrayList<Integer>> set) {
        if (target == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(currentList);
            if (!set.contains(temp)) {
                set.add(temp);
                result.add(temp);
            }
            return;
        }

        for (int currentIndex = index; currentIndex < numbers.size(); currentIndex++) {
            if (target < numbers.get(currentIndex)) {
                return;
            }
            currentList.add(numbers.get(currentIndex));
            combinationSum(numbers, target - numbers.get(currentIndex), currentIndex + 1, currentList, result, set);
            currentList.remove(currentList.size() - 1);
        }
    }
}
