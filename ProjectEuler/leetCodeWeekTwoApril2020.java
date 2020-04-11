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
        //Two pointer approach 
        ListNode A = head; 
        ListNode B = head; 
        while(B != null)
        {
            B = B.next;
            if(B == null) return A; 
            A = A.next;
            B = B.next; 
        }
        return A; 

        // Naive implementation and solution 
        // ListNode copyOfCurrentHead = head; 
        // int numberOfNodes = 0; 
        // while(copyOfCurrentHead.next != null){
        //     numberOfNodes++; 
        //     copyOfCurrentHead = copyOfCurrentHead.next; 
        // }
        // if(numberOfNodes % 2 == 0)
        // {
        //     numberOfNodes = numberOfNodes / 2; 
        // }else
        // {
        //     numberOfNodes = numberOfNodes / 2  + 1;             
        // }
        // while(numberOfNodes > 0){
        //     head = head.next; 
        //     number,OfNodes--; 
        // }
        // return head; 
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

   //4.10 Min Stack 
   public class MinStack{
       ArrayList<Integer> stack; 
       public MinStack() {
           stack = new ArrayList<Integer>() ;   
        }
        public void push(int x) {
            stack.add(x); 
        }
        public void pop() {
            stack.remove(stack.size() - 1); 
        }
        public int top() {
            return stack.get(stack.size() - 1); 
        }
        public int getMin() {
            int min = stack.get(0);
            for(int s : stack){
                if(s < min) min = s; 
        }
            return min; 
        }
   }



   // 4.11 Diameter of a binary tree 
   
   public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
        }
        int ans; 
   
   public int diameterOfBinaryTree(TreeNode root) {
       ans = 0;
       ans = 1; 
       depth(root);
       return ans - 1; 
   }
       public int depth(TreeNode node) {
       if (node == null) return 0;
       int L = depth(node.left);
       int R = depth(node.right);
       ans = Math.max(ans, L+R+1);
       return Math.max(L, R) + 1;
   }


    public static void main(String[] args){
        leetCodeWeekTwoApril2020 object = new leetCodeWeekTwoApril2020(); 
        System.out.println(object.backspaceCompare("ab#c", "ad#c")); //< 4.9 
   }

}
