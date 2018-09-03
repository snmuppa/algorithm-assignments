package algorthims.practice;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SumOfFibonnaciTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public SumOfFibonnaciTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SumOfFibonnaciTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public int fibsum(int fibonnaciTerm) {
        if (fibonnaciTerm <= 2) {
            return 1;
        }

        int result = 0;
        ArrayList<Integer> fibonacciSeries = getFibonacciSeries(fibonnaciTerm);
        int seriesSize = fibonacciSeries.size() - 1;

        while (fibonnaciTerm > 0) {
            result += (fibonnaciTerm / fibonacciSeries.get(seriesSize));
            fibonnaciTerm %= (fibonacciSeries.get(seriesSize));

            seriesSize--;
        }

        return result;
    }

    private ArrayList<Integer> getFibonacciSeries(int fibonnaciTerm) {
        ArrayList<Integer> series = new ArrayList<>();

        series.add(1);
        series.add(1);
        series.add(2);
        int currentIndex = 2;
        int nextTerm = 0;

        while (true) {
            nextTerm = series.get(currentIndex) + series.get(currentIndex - 1);

            if (nextTerm > fibonnaciTerm) {
                return series;
            }

            series.add(nextTerm);
            currentIndex++;
        }
    }
}
