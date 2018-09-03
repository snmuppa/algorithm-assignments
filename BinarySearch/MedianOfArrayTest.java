package algorthims.practice;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class MedianOfArrayTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MedianOfArrayTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(MedianOfArrayTest.class);
    }

    /**
     * Rigourous Test :-)
     * A : [ -50, -41, -40, -19, 5, 21, 28 ]
     * B : [ -50, -21, -10 ]
     */
    public void testApp() {
        assertTrue(true);

        /*List<Integer> listA = new ArrayList<Integer>() {{
            add(1);
            add(2);
            add(5);
        }};
        List<Integer> listB = new ArrayList<Integer>() {{
            add(3);
            add(4);
        }};*/

        List<Integer> listA = new ArrayList<Integer>() {
            {
                add(-50);
                add(-41);
                add(-40);
                add(-19);
                add(5);
                add(21);
                add(28);
            }
        };
        List<Integer> listB = new ArrayList<Integer>() {
            {
                add(-50);
                add(-21);
                add(-10);
            }
        };
        System.out.println((findMedianSortedArrays(listA, listB)));

        System.out.println((findMedianSortedArraysLogrithmicTime(listA, listB)));
    }

    public double findMedianSortedArrays(final List<Integer> listA, final List<Integer> listB) {
        int sizeA = listA.size();
        int sizeB = listB.size();

        int mergeListSize = sizeA + sizeB;

        List<Integer> mergedList = new ArrayList<>();

        int indexListA = 0;
        int indexListB = 0;

        double result = 0;

        while (indexListA < sizeA && indexListB < sizeB) {
            if (listA.get(indexListA) < listB.get(indexListB)) {
                mergedList.add(listA.get(indexListA));
                indexListA++;
            } else {
                mergedList.add(listB.get(indexListB));
                indexListB++;
            }
        }

        while (indexListA < sizeA) {
            mergedList.add(listA.get(indexListA));
            indexListA++;
        }

        while (indexListB < sizeB) {
            mergedList.add(listB.get(indexListB));
            indexListB++;
        }

        if (mergedList.size() % 2 == 0) {
            result = ((double) mergedList.get((mergedList.size() / 2) - 1) + (double) mergedList.get(mergedList.size() / 2)) / 2;
        } else {
            result = mergedList.get(mergedList.size() / 2);
        }

        return result;
    }

    public double findMedianSortedArraysLogrithmicTime(final List<Integer> listA, final List<Integer> listB) {
        //if input1 length is greater than switch them so that input1 is smaller than input2.
        if (listA.size() > listB.size()) {
            return findMedianSortedArraysLogrithmicTime(listB, listA);
        }
        int x = listA.size();
        int y = listB.size();

        int low = 0;
        int high = x;
        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            //if partitionX is 0 it means nothing is there on left side. Use -INF for maxLeftX
            //if partitionX is length of input then there is nothing on right side. Use +INF for minRightX
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : listA.get(partitionX - 1);
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : listA.get(partitionX);

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : listB.get(partitionY - 1);
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : listB.get(partitionY);

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                //We have partitioned array at correct place
                // Now get max of left elements and min of right elements to get the median in case of even length combined array size
                // or get max of left for odd length combined array size.
                if ((x + y) % 2 == 0) {
                    return ((double) Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) { //we are too far on right side for partitionX. Go on left side.
                high = partitionX - 1;
            } else { //we are too far on left side for partitionX. Go on right side.
                low = partitionX + 1;
            }
        }

        //Only we we can come here is if input arrays were not sorted. Throw in that scenario.
        throw new IllegalArgumentException();
    }

}
