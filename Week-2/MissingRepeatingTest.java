package algorthims.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple ConcentricCircularMatrix.
 */
public class MissingRepeatingTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MissingRepeatingTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MissingRepeatingTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        Integer inputArray[] = { 3, 5, 2, 1, 3 };

        ArrayList<Integer> missingRepeatingElements = getMissingRepeatingElement(Arrays.asList(inputArray));
        System.out.println(Arrays.toString(missingRepeatingElements.toArray()));
    }

    /**
     * Non-Optimal implementation
     * @param inputArray
     * @return
     */
    /*private ArrayList<Integer> getMissingRepeatingElement(final List<Integer> inputArray) {
        int inputLength = inputArray.size();

        long sumOfElements = (inputLength * (inputLength + 1)) / 2;

        long sumOfSquares = (inputLength * (inputLength + 1) * (2 * inputLength + 1)) / 6;

        long actualSum = 0;

        long actualSumofSquares = 0;

        for (int element : inputArray) {
            actualSum += element;
            actualSumofSquares += (element * element);
        }

        long missingMinusRepeating = sumOfElements - actualSum;

        long missingPlusRepeating = (sumOfSquares - actualSumofSquares) / missingMinusRepeating;

        int missingNumber = (int) (missingMinusRepeating + missingPlusRepeating) / 2;

        int repeatingNumber = (int) (missingNumber - missingMinusRepeating);

        return new ArrayList<Integer>() {
            {
                add(repeatingNumber);
                add(missingNumber);
            }
        };
    }*/

    private ArrayList<Integer> getMissingRepeatingElement(final List<Integer> inputArray) {
        long missingMinusRepeating = 0;
        long squaresDiff = 0;

        int startIndex = 0;
        int endIndex = inputArray.size() - 1;

        int currentIndex = 0;
        for (int index = 0; index < inputArray.size(); index++) {
            if (startIndex <= endIndex) {
                if (squaresDiff < 0) {
                    currentIndex = endIndex;
                    endIndex--;
                } else {
                    currentIndex = startIndex;
                    startIndex++;
                }

                int element = inputArray.get(currentIndex);

                long tempIndex = currentIndex + 1;
                long tempElement = element;
                missingMinusRepeating += (tempIndex - tempElement);
                squaresDiff += ((tempIndex * tempIndex) - (tempElement * tempElement));
            }
        }

        long missingPlusRepeating = squaresDiff / missingMinusRepeating;

        int missingNumber = (int) (missingMinusRepeating + missingPlusRepeating) / 2;

        int repeatingNumber = (int) (missingNumber - missingMinusRepeating);

        return new ArrayList<Integer>() {
            {
                add(repeatingNumber);
                add(missingNumber);
            }
        };
    }
}
