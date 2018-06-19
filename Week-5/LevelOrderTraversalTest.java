package algorthims.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class LevelOrderTraversalTest extends TestCase {
    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LevelOrderTraversalTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(LevelOrderTraversalTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(null);

        ArrayList<Integer> current = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if (temp != null) {
                current.add(temp.val);
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            } else {
                ArrayList<Integer> newCurrent = new ArrayList<Integer>(current);
                result.add(newCurrent);
                current.clear();

                if (!queue.isEmpty()) {
                    queue.offer(null);
                }
            }
        }

        return result;
    }
}
