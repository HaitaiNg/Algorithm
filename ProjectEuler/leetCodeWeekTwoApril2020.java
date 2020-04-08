import java.util.*;
import java.math.*; 

public class leetCodeWeekTwoApril2020{

    // 4.8 Middle Of A Linked List 
    // input : [1,2,3,4,5]
    // return [3,4,5] 
    // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
    
    public ListNode middleNode(ListNode head) {
        ListNode copyOfCurrentHead = head; 
        int numberOfNodes = 0; 
        while(copyOfCurrentHead.next != null){
            numberOfNodes++; 
            copyOfCurrentHead = copyOfCurrentHead.next; 
        }
        if(numberOfNodes % 2 == 0)
        {
            numberOfNodes = numberOfNodes / 2; 
        }else
        {
            numberOfNodes = numberOfNodes / 2  + 1;             
        }
        while(numberOfNodes > 0){
            head = head.next; 
            numberOfNodes--; 
        }
        return head; 
    }

    public static void main(String[] args){
        leetCodeWeekTwoApril2020 object = new leetCodeWeekTwoApril2020(); 
    }

}
