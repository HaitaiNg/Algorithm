

// Question ::  Add Two Numbers
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

import java.util.*;
class Solution {
    public int helperFuctionForLinkedList(ListNode node)
    {
        List<Integer> listOfIntegers = new ArrayList<Integer>();
        while(true)
        {
            listOfIntegers.add(node.val);
            if(node.next == null)
            {
                break;
            }
            node = node.next;
        }
        Collections.reverse(listOfIntegers);
        return Integer.parseInt(listOfIntegers.stream().map(String::valueOf).collect(Collectors.joining()));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = helperFuctionForLinkedList(l1) + helperFuctionForLinkedList(l2) ;
        // reverse a number using a while loop in java
        ListNode head = null;
        for(;sum != 0; sum /= 10)
        {
            int digit = sum % 10;

            // Continously add nodes to the linked list
            ListNode newNode = new ListNode(digit);
            if(head == null)
            {
                head = new ListNode(digit);
            }
            else
            {
                newNode.next = null;
                ListNode lastNode = head;
                while(lastNode.next != null)
                {
                 lastNode = lastNode.next;
                }
                lastNode.next = newNode;
            }
        }
        return head;
    }
}

/*
 Solution from LeetCode

 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}

*/
