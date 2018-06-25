package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// https://www.interviewbit.com/problems/best-time-to-buy-and-sell-stocks-ii/
public class Stocks2Test extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Stocks2Test(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(Stocks2Test.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public int maxProfit(final List<Integer> A) {
      if(A.size() < 2) {
        return 0;
      }

      int result = 0;

      for(int index = 1; index < A.size(); index++) {
        int currentProfit = A.get(index) - A.get(index -1);
        if(currentProfit > 0) {
          result += currentProfit;
        }
      }

      return result;
    }
}
