package algorthims.practice;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PermutationsTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PermutationsTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PermutationsTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        ArrayList<ArrayList<Integer>> result = permute(numbers);
        for (int index = 0; index < result.size(); index++) {

            System.out.println(result.get(index));

        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        permute(numbers, 0, result);
        return result;
    }

    void permute(ArrayList<Integer> numbers, int start, ArrayList<ArrayList<Integer>> result) {
        if (start >= numbers.size()) {
            result.add(new ArrayList<>(numbers));
        }

        for (int index = start; index < numbers.size(); index++) {
            swap(numbers, start, index);
            permute(numbers, start + 1, result);
            swap(numbers, start, index);
        }
    }

    private void swap(ArrayList<Integer> numbers, int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i, numbers.get(j));
        numbers.set(j, temp);
    }
}
