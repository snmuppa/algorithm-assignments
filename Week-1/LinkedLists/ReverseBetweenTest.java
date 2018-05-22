package fun.algorithms;

import java.util.EmptyStackException;
import java.util.Stack;

import fun.algorithms.AddListsTest.ListNode;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ReverseBetweenTest extends TestCase {

	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public ReverseBetweenTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(ReverseBetweenTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAddLists() {

		// ListNode nodeA = new ListNode(2);
		// nodeA.next = new ListNode(4);
		// nodeA.next.next = new ListNode(3);

		// ListNode node = reverseBetween(nodeA, 1, 2);

		ListNode nodeA = new ListNode(1);

		ListNode node = reverseBetween(nodeA, 1, 1);

		System.out.println(node.val);
	}

	public ListNode reverseBetween(ListNode listNode, int startPosition, int endPosition) {
		int index = 1;
		ListNode returnNode = new ListNode(0);
		ListNode returnNodeHead = returnNode;
		Stack<Integer> stack = new Stack<>();
		while (listNode != null) {
			while (!stack.isEmpty()) {
				try {
					returnNode.next = new ListNode(stack.pop());
					returnNode = returnNode.next;
				} catch (EmptyStackException ex) {
					System.out.println("Emtpy STack.");
					break;
				}
			}

			if (index == startPosition) {
				while (startPosition <= endPosition) {
					stack.push(listNode.val);
					listNode = listNode.next;
					startPosition++;
					index++;
				}
				startPosition = Integer.MIN_VALUE; // reset startPosition
			} else {
				returnNode.next = new ListNode(listNode.val);
				returnNode = returnNode.next;
				listNode = listNode.next;
				index++;
			}
		}

		while (!stack.isEmpty()) {
			try {
				returnNode.next = new ListNode(stack.pop());
				returnNode = returnNode.next;
			} catch (EmptyStackException ex) {
				System.out.println("Emtpy STack.");
				break;
			}
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
