package algorthims.practice;

import java.util.ArrayList;
import java.util.Stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PreOrderTraversalTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PreOrderTraversalTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PreOrderTraversalTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.empty()) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);

            if (tmp.right != null) {
                stack.push(tmp.right);
            }

            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }

        return result;
    }

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

}
