package algorthims.practice;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MergerSortTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MergerSortTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MergerSortTest.class);
    }

    public void testApp() {
        int testArray[] = { 5, 8, 6, 4, 7, 3, 1, 2, 1 };

        getSortedArray(testArray);

        System.out.println(Arrays.toString(testArray));
    }

    private void getSortedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0 || inputArray.length == 1) {
            return;
        }

        mergeSort(inputArray, 0, inputArray.length - 1);
    }

    private void mergeSort(int[] inputArray, int min, int max) {
        if (min < max) {
            int mid = (min + max) / 2;
            mergeSort(inputArray, min, mid);
            mergeSort(inputArray, mid + 1, max);
            merge(inputArray, min, mid, mid + 1, max);
        }
    }

    private void merge(int[] inputArray, int leftMin, int leftMax, int rightMin, int rightMax) {
        int i = leftMin, j = rightMin;

        int tempArray[] = new int[rightMax - leftMin + 1];
        int currentPosition = 0;

        while (i <= leftMax || j <= rightMax) {
            // boundary cases
            if (i <= leftMax && j > rightMax) {
                tempArray[currentPosition] = inputArray[i];
                i++;
                currentPosition++;
                continue;
            } else if (i > leftMax && j <= rightMax) {
                tempArray[currentPosition] = inputArray[j];
                j++;
                currentPosition++;
                continue;
            }
            // End of boundary cases

            if (inputArray[i] <= inputArray[j]) {
                tempArray[currentPosition] = inputArray[i];
                i++;
            } else {
                tempArray[currentPosition] = inputArray[j];
                j++;
            }

            currentPosition++;
        }

        for (int x = 0, y = leftMin; x < tempArray.length; x++, y++) { // update the input array based on temp array, but use the correct locations based on left min and max
            inputArray[y] = tempArray[x];
        }
    }
}
