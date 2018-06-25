package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// https://www.interviewbit.com/problems/stairs/
public class StairsTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public StairsTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(StairsTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public int climbStairs(int A) {
      if (A == 0) {
        return 0;
      } else if (A == 1) {
        return 1;
      }

      int a = 1;
      int b = 0;
      int result = 0;
      for (int i = 0; i <= A; i++) {
        result = a + b;
        b = a;
        a = result;
      }

      return b;
    }
}
