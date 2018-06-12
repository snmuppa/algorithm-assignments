package algorthims.practice;

import java.util.ArrayList;
import java.util.Collections;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MinXorTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MinXorTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MinXorTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public int findMinXor(ArrayList<Integer> input) {
        int result = Integer.MAX_VALUE;

        // parse over all pairs
        for (int i = 0; i < input.size(); i++) {
            for (int j = i + 1; j < input.size(); j++) {
                result = Math.min(result, input.get(i) ^ input.get(j));
            }
        }

        return result;
    }


    static int findMinXor_NLogN(ArrayList<Integer> input)
    {
        // Sort given array
        Collections.sort(input);

        int result = Integer.MAX_VALUE;
        int val = 0;

        for (int i = 0; i < input.size() - 1; i++) {
            val = input.get(i) ^  input.get(i + 1);
            result = Math.min(result, val);
        }

        return result;
    }
}
