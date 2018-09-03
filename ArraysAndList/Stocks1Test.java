package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

//Say you have an array for which the ith element is the price of a given stock on day i.
//If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
public class Stocks1Test extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public Stocks1Test(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(Stocks1Test.class);
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
        int stockPosition = 0;

        for(int index = 1; index < A.size(); index++) {
            if(A.get(index) < A.get(stockPosition)) {
                stockPosition = index;
            }

            int tempPrice = A.get(index) - A.get(stockPosition);

            if(tempPrice > result) {
                result = tempPrice;
            }
        }

        return result;
    }
}
