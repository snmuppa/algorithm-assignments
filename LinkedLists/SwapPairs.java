/**
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:
Given 1->2->3->4, you should return the list as 2->1->4->3.
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
class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        // Null check
        if(head == null)
            return head;
        
        var dummyHead = new ListNode(-1);
        dummyHead.next = head;
        var currNode = dummyHead;
        
        while(currNode != null 
             && currNode.next != null
             && currNode.next.next != null) {
            
            var firstNode = currNode.next;
            var secondNode = currNode.next.next;
            
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            
            currNode.next = secondNode;
            currNode = firstNode;
        }
        
        return dummyHead.next;
    }
}
