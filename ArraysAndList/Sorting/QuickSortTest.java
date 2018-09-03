package algorthims.practice;

import java.util.Arrays;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class QuickSortTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuickSortTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(QuickSortTest.class);
    }

    public void testApp() {
        // int testArray[] = { 5, 8, 6, 4, 7, 3, 1, 2, 1 };
        int testArray[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 1 };
        // int testArray[] = { 1, 2, 1, 2, 3, 4, 3, 4, 5, 6, 5, 6, 7, 8, 7, 8, 9, 10, 9, 10 };
        // int testArray[] = { 1, 2, 2, 2, 3, 2, 4, 2, 1, 5, 1, 4, 2, 3, 4, 5 };
        System.out.println("Input test array: " + Arrays.toString(testArray));
        getSortedArray(testArray);
        System.out.println("Sorted array: " + Arrays.toString(testArray));
    }

    private void getSortedArray(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0 || inputArray.length == 1) {
            return;
        }

        quickSort(inputArray, 0, inputArray.length - 1);
    }

    private void quickSort(int[] inputArray, int minIndex, int maxIndex) {
        if (minIndex < maxIndex) {
            int partitionIndex = partition(inputArray, minIndex, maxIndex);
            quickSort(inputArray, minIndex, partitionIndex - 1);
            quickSort(inputArray, partitionIndex + 1, maxIndex);
        }
    }

    private int partition(int[] inputArray, int minIndex, int maxIndex) {
        // 5 , 8, 6, 4, 7, 3, 1, 2, 1
        //---- i                    j
        //where i ~ leftSliderIndex and j ~ rightSliderIndex
        int leftSliderIndex = minIndex, rightSliderIndex = maxIndex;

        int pivot = inputArray[minIndex];

        while (leftSliderIndex < rightSliderIndex) {
            while (leftSliderIndex < inputArray.length && inputArray[leftSliderIndex] <= pivot) {
                leftSliderIndex++;
            }

            while (rightSliderIndex >= 0 && inputArray[rightSliderIndex] > pivot) {
                rightSliderIndex--;
            }

            if (leftSliderIndex < rightSliderIndex) {
                swap(inputArray, leftSliderIndex, rightSliderIndex);
            }
        }

        if (rightSliderIndex > minIndex) {
            swap(inputArray, minIndex, rightSliderIndex);
        }

        // System.out.println(Arrays.toString(inputArray));
        // System.out.println(rightSliderIndex);

        return rightSliderIndex;
    }

    private void swap(int[] inputArray, int leftIndex, int rightIndex) {
        int temp = inputArray[leftIndex];
        inputArray[leftIndex] = inputArray[rightIndex];
        inputArray[rightIndex] = temp;
    }
}
