/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == NULL) return NULL; 
        ListNode* slow = head;
        ListNode* fast = head; 
        ListNode* tmp = head; 
        int count = 0; 
        
        // Get the length of the list 
        while(tmp)
        {
            tmp = tmp->next;
            count++; 
        }
        
        //Find the offset 
        k = k % count; 
        for(int i = 0; i < k; i++) fast = fast->next; 
        
        // Proceed with rotation 
        while(fast->next){
            slow = slow->next;
            fast = fast->next; 
        }
        fast->next = head; 
        ListNode* result = slow->next; 
        slow->next = NULL;
        return result; 
    }
};