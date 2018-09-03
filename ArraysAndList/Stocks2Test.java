package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//Say you have an array for which the ith element is the price of a given stock on day i.
//Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
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
