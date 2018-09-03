package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SqrtOfIntegerTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SqrtOfIntegerTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SqrtOfIntegerTest.class);
    }

    public void testApp() {
        System.out.println(sqrt(3));
    }

    public int sqrt(int input) {
        long start = 1;
        long end = input;
        int result = 0;

        while (start <= end) {
            long middle = (start + end) / 2;

            long square = middle * middle;

            if (square == input) {
                result = (int) middle;
                break;
            }

            if (square < input) {
                start = middle + 1;
                result = (int) middle;
            } else {
                end = middle - 1;
            }
        }

        return result;
    }
}
