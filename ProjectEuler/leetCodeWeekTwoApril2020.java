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

    // 4.9 Backspace String Compare
    public boolean backspaceCompare(String S, String T) { 
        return backSpaceCompareHelper(S).equals(backSpaceCompareHelper(T)); 
   }
   public String backSpaceCompareHelper(String S)
   {
       String s = ""; 
       Stack sStack = new Stack<Character>(); 
       for(int i = 0 ; i < S.length(); i++)
       {
           char character = S.charAt(i); 
           if(character == '#'){
               if(sStack.size() > 0) sStack.pop(); 
           } 
           else
           {
               sStack.add(character); 
           }
       }
       return sStack.toString();
   }

    public static void main(String[] args){
        leetCodeWeekTwoApril2020 object = new leetCodeWeekTwoApril2020(); 
        System.out.println(object.backspaceCompare("ab#c", "ad#c")); //< 4.9 
   }

}
