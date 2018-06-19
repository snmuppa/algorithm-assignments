package algorthims.practice;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ListToBSTTest extends TestCase {
    private ListNode head;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ListToBSTTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ListToBSTTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        ListNode node = new ListNode(1);
        node.next = new ListNode(4);
        node.next.next = new ListNode(8);
        node.next.next.next = new ListNode(16);

        preOrder(sortedListToBST(node));
    }

    void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public TreeNode sortedListToBST(ListNode head) {
        int numberOfNodes = numberOfNodes(head);
        this.head = head;
        return sortedListToBST(numberOfNodes);
    }

    public TreeNode sortedListToBST(int numberOfNodes) {
        if (numberOfNodes <= 0) {
            return null;
        }

        int mid = (numberOfNodes) / 2;

        TreeNode left = sortedListToBST(mid);
        TreeNode root = new TreeNode(head.val);
        head = head.next;
        TreeNode right = sortedListToBST(numberOfNodes - mid -1);

        root.left = left;
        root.right = right;

        return root;
    }

    public int numberOfNodes(ListNode head) {
        int nodeCount = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            nodeCount++;
        }

        return nodeCount;
    }

    /**
     * Definition for binary tree
     */
    class TreeNode {
        int val;

        TreeNode left;

        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Definition for singly-linked list.
     */
    class ListNode {
        public int val;

        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
