package algorthims.practice;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DuplicateRemoverTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DuplicateRemoverTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(DuplicateRemoverTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        // int input[] = new int[] { 1, 2, 3, 3, 4, 5, 6, 8, 8, 9, 10, 10 };
        // int input[] = new int[] { 1, 1, 3, 3, 3, 3, 6, 8, 8, 8, 10, 10 };
        // int input[] = new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 6, 6, 6, 6, 6, 6, 8, 9, 9, 10, 10, 10, 10 };
        // int input[] = new int[] { 1, 1, 1, 1, 1, 1 };
        // int input[] = new int[] { 1, 1, 1, 1, 1, 1, 10 };
        // int input[] = new int[] { 1, 2, 3, 4, 5, 10, 10, 10, 10 };
        // int input[] = new int[] { 1, 2, 3, 4, 5, 10, 10, 10, 10, 11 };
        int input[] = new int[] { 1, 1, 1, 1, 1, 2, 3, 4, 5, 6 };
        System.out.println(removeDuplicates(input));
        System.out.println(Arrays.toString(input));
    }

    private int removeDuplicates(int[] input) {
        int removedElementCount = 0;

        int previousValue = input[0];
        for (int index = 1; index < input.length; index++) {
            int currentValue = input[index];

            if (previousValue == currentValue) {
                input[index] = -1;
                removedElementCount++;
            } else {
                previousValue = currentValue;
            }
        }

        // 1, -1, 3, -1, -1, -1, -1, 6, 8, -1, -1, 10, -1
        // 1, 3, -1, -1, -1, -1, -1, 6, 8, -1, -1, 10, -1
        // 1, 3, 6, -1, -1, -1, -1, -1, 8, -1, -1, 10, -1
        // 1, 3, 6, 8, -1, -1, -1, -1, -1, -1, -1, 10, -1
        // 1, 3, 6, 8, 10, -1, -1, -1, -1, -1, -1, -1, -1

        int minusOneIndex = -1;
        int runningMinusOneElementsCount = 0;
        for (int index = 0; index < input.length; index++) {
            if (input[index] == -1) {
                if (minusOneIndex == -1) {
                    minusOneIndex = index;
                }
                runningMinusOneElementsCount++;
            } else {
                if (minusOneIndex > -1 && index > minusOneIndex) {
                    input[minusOneIndex] = input[index];
                    input[index] = -1;
                    if (runningMinusOneElementsCount > 0) {
                        minusOneIndex++;
                    } else {
                        minusOneIndex = index;
                    }
                }
            }
        }

        return removedElementCount;
    }
}
