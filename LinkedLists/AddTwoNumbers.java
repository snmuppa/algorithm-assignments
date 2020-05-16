/**
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }
        
        var carry = 0;
        var traversalNode = new ListNode();
        var resultNode = traversalNode;
            
        while(l1 != null || l2 != null) {  
            if(l1 == null) {
                traversalNode.val = ((l2.val + carry) % 10);
                carry = ((l2.val + carry) / 10);
            } else if (l2 == null) {
                traversalNode.val = ((l1.val + carry) % 10);
                carry = ((l1.val + carry) / 10);
            } else {
                traversalNode.val = ((l1.val + l2.val + carry) % 10);
                carry = ((l1.val + l2.val + carry) / 10);
            }
            
            if(l1 != null) {
                l1 = l1.next;
            }
            
            if(l2 != null) {
                l2 = l2.next;
            }
            
            if(l1 == null && l2 == null && carry == 0)
                traversalNode.next = null;
            else {
                traversalNode.next = new ListNode();
            } 
            traversalNode = traversalNode.next;
        }
        
        if(carry != 0) {
            traversalNode.val = carry;
        } 
        
        return resultNode;
    }
}
