// Given a linked list, determine if it has a cycle in it.
// Follow up:
// Can you solve it without using extra space?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null || head.next == null) {
            return false;
        }
        
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        boolean hasCycle = false;
        while(!hasCycle) {
            if(slowPointer == null || fastPointer == null) {
                break;
            }
            
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
            if(slowPointer == null || fastPointer == null) {
                break;
            }
            fastPointer = fastPointer.next;
            
            if(slowPointer.equals(fastPointer)) {
                hasCycle = true;
            }
        }
        
        return hasCycle;
    }
}
