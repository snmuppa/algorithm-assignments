/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// Reverse a singly linked list.
// Example:
// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// Follow up:
// A linked list can be reversed either iteratively or recursively. Could you implement both?
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {        
        if(head == null || head.next == null) {
            return head;
        }
        
        // Take 3 pointers
        // currentNode which starts at head.next
        // nextNode which is head.next.next
        // previousNode which starts at headNode
        // Sample:
        // 1->2->3->4->5->NULL
        // previousNode->currentNode->nextNode->
        //
        // initialize previousNode's next pointer to be null
        // 
        // in a while loop:
        // set the currentNode's next pointer to previousNode
        // if the nextNode is Null, break out of the loop
        // else set previousNode to currentNode, 
        //          currentNode to nextNode and 
        //          nextNode to nextNode's next pointer, 
        // continue in the loop
        // 
        // finally return currentNode
        ListNode currentNode = head.next;
        ListNode nextNode = currentNode.next;
        ListNode previousNode = head;
        previousNode.next = null;
        while(true) {
            currentNode.next = previousNode;
            if(nextNode == null) {
                break;
            }
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.next;
        }
        
        return currentNode;
    }
}
