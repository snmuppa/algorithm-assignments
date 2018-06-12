package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ReverseBits extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ReverseBits(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ReverseBits.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public long reverse(long input) {
        long result = 0;
        int i = 31;
        while(input > 0){
            result += (input % 2) * Math.pow(2, i);
            i--;
            input = input/2;
        }
        return result;
    }
}
