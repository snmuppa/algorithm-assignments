package fun.algorithms;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AddListsTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AddListsTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AddListsTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAddLists() {

		ListNode nodeA = new ListNode(2);
		nodeA.next = new ListNode(4);
		nodeA.next.next = new ListNode(3);

		ListNode nodeB = new ListNode(5);
		nodeB.next = new ListNode(6);
		nodeB.next.next = new ListNode(4);

		ListNode node = addTwoNumbers(nodeA, nodeB);

		System.out.println(node.val + " -->" + node.next.val + "-->" + node.next.next.val);
	}

	public ListNode addTwoNumbers(ListNode nodeA, ListNode nodeB) {
		int carry = 0;

		ListNode returnNode = new ListNode(0);
		ListNode returnNodeHead = returnNode;

		while (nodeA != null || nodeB != null) {
			if (nodeA != null) {
				carry += nodeA.val;
				nodeA = nodeA.next;
			}

			if (nodeB != null) {
				carry += nodeB.val;
				nodeB = nodeB.next;
			}

			returnNode.next = new ListNode(carry % 10);
			returnNode = returnNode.next;
			carry = carry / 10;
		}

		if (carry > 0) {
			returnNode.next = new ListNode(carry);
		}

		return returnNodeHead.next;
	}

	class ListNode {
		public int val;
		public ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
