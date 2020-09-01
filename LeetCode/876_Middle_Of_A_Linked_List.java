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

// Completed using 2 pointer technique 
class Solution {
    public ListNode middleNode(ListNode head) {
        
        ListNode slow = head, fast = head;  
        while(fast != null && fast.next != null)
        {
            if(fast.next.next == null) // even 
            {
                return slow.next; 
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; 
       
	/*
	//Even better solution 
	ListNode slow = head, fast = head; 
	while(fast != null && fast.next != null)
	{
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow; 
	*/

    }
}
