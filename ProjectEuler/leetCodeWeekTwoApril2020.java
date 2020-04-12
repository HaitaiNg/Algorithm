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


   // 4.12 Last Stone Weight 
   public int lastStoneWeight(int[] stones) {
       Arrays.sort(stones); 
       if(stones.length == 0) return 0; //< base case 
       if(stones.length == 1) return stones[0]; //< base case 
      
       int rightPointer = stones[stones.length - 1]; 
       int leftPointer = stones[stones.length - 2];
       int difference = rightPointer - leftPointer;

       stones = removeTheElement(stones, rightPointer);
       stones = removeTheElement(stones, leftPointer); 
       if(difference != 0)
       {
            stones = addElement(stones.length, stones, difference); 
       }
       return lastStoneWeight(stones);
   }   

   public static int[] removeTheElement(int[] arr, 
                                          int index ) 
    { 
        // Create another array of size one less 
        int[] anotherArray = new int[arr.length - 1]; 
        // Copy the elements except the index 
        // from original array to the other array 
        for (int i = 0, k = 0; i < arr.length - 1; i++) { 
            anotherArray[k++] = arr[i]; 
        } 
        // return the resultant array 
        return anotherArray; 
    } 
      // Function to add x in arr 
      public int[] addElement(int n, int arr[], int x) 
      { 
          int i; 
    
          // create a new array of size n+1 
          int newarr[] = new int[n + 1]; 
    
          // insert the elements from 
          // the old array into the new array 
          // insert all elements till n 
          // then insert x at n+1 
          for (i = 0; i < n; i++) 
              newarr[i] = arr[i]; 
    
          newarr[n] = x; 
    
          return newarr; 
      } 




    public static void main(String[] args){
        leetCodeWeekTwoApril2020 object = new leetCodeWeekTwoApril2020(); 
        // object.backspaceCompare("ab#c", "ad#c"); //< 4.9
        // object.lastStoneWeight(new int[] {2,7,4,1,8,1}); //< 4.12 Solution : 1 
   }

}
