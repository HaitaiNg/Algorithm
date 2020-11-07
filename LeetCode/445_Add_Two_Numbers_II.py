# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l1Stack = [] 
        while l1 != None: 
            l1Stack.append(l1.val) 
            l1 = l1.next 
        l2Stack = [] 
        while l2 != None: 
            l2Stack.append(l2.val) 
            l2 = l2.next 
        
        base = 1
        summ = 0 
        while(l1Stack):
            summ += l1Stack.pop() * base 
            base *= 10 
        base2 = 1 
        while(l2Stack):
            summ += l2Stack.pop() * base2 
            base2 *= 10 
        
        #Create singly linked list :: review concepts in C++ and Python 
        root = ListNode(int(str(summ)[0])) 
        head = root 
        for i in str(summ)[1:]:
            root.next = ListNode(int(i)) 
            root = root.next 
        return head 
                
            