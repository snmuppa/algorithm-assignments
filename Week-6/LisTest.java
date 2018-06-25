package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

// https://www.interviewbit.com/problems/longest-increasing-subsequence/
public class LisTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LisTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LisTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public int lis(final List<Integer> A) {
        int lis[] = new int[A.size()];

        int result = 0;

        for (int index =0; index< A.size(); index++) {
            lis[index] = 1;
        }

        for(int i=0; i < A.size(); i++) {
            for(int j = 0; j < i; j++) {
                if(A.get(j) < A.get(i) && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        for(int index = 0; index < A.size(); index++) {
            if(result < lis[index]) {
                result = lis[index];
            }
        }

        return result;
    }
}
