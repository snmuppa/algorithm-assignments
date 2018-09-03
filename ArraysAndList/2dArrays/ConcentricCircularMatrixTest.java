package algorthims.practice;

import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple ConcentricCircularMatrix.
 */
public class ConcentricCircularMatrixTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConcentricCircularMatrixTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ConcentricCircularMatrixTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
        int count = 2;
        getConcentricMatrix(count);
    }

    /**
     * Print the concentric matrix
     * @param count
     * output:
     * 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9
     * 9 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9
     * 9 8 7 7 7 7 7 7 7 7 7 7 7 7 7 8 9
     * 9 8 7 6 6 6 6 6 6 6 6 6 6 6 7 8 9
     * 9 8 7 6 5 5 5 5 5 5 5 5 5 6 7 8 9
     * 9 8 7 6 5 4 4 4 4 4 4 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 3 3 3 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 2 2 2 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 2 1 2 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 2 2 2 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 3 3 3 3 3 4 5 6 7 8 9
     * 9 8 7 6 5 4 4 4 4 4 4 4 5 6 7 8 9
     * 9 8 7 6 5 5 5 5 5 5 5 5 5 6 7 8 9
     * 9 8 7 6 6 6 6 6 6 6 6 6 6 6 7 8 9
     * 9 8 7 7 7 7 7 7 7 7 7 7 7 7 7 8 9
     * 9 8 8 8 8 8 8 8 8 8 8 8 8 8 8 8 9
     * 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9 9
     */
    private void getConcentricMatrix(int count) {
        Integer matrixCount = 2 * count - 1;
        Integer[][] matrix = new Integer[matrixCount][matrixCount];
        ArrayList<ArrayList<Integer>> listOfLists = new ArrayList<ArrayList<Integer>>();
        try {
            for (int i = 0; i < count; i++) {
                for (int j = i; j < matrixCount - i; j++) {
                    if (j == count - 1) {
                        matrix[j][j] = 1;
                    }
                    int number = count - i;
                    matrix[i][j] = number;
                    matrix[matrixCount - i - 1][j] = number;
                    matrix[j][i] = number;
                    matrix[j][matrixCount - i - 1] = number;
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < matrixCount; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < matrixCount; j++) {
                arr.add(matrix[i][j]);
                System.out.print(matrix[i][j] + " ");
            }
            listOfLists.add(arr);
            System.out.println();
        }
    }
}
