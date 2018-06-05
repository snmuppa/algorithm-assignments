package algorthims.practice;

import java.util.Stack;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FlattenABinaryTreeTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FlattenABinaryTreeTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(FlattenABinaryTreeTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {

    }

    public TreeNode flatten(TreeNode rootNode) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = rootNode;

        while (currentNode != null) {
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            if (currentNode.left != null) {
                currentNode.right = currentNode.left;
                currentNode.left = null;
                currentNode = currentNode.right;
            } else {
                if (!stack.empty()) {
                    currentNode.right = stack.pop();
                    currentNode.left = null;
                    currentNode = currentNode.right;
                } else {
                    currentNode = null;
                }
            }
        }

        return rootNode;
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
