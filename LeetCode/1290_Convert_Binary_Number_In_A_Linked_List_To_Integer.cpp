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
    int getDecimalValue(ListNode* head) {
        int num = head->val; 
        while(head->next != NULL)
        {
            num = (num << 1) | head->next->val; 
            head = head->next; 
        }
        return num; 
    }
};

// Above solution is more optimal as it uses bit shifting. Bottom
// solution is more naive and is my own solution 

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
    int getDecimalValue(ListNode* head) {
        string s = ""; 
        while(head != NULL)
        {
            s += to_string(head->val); 
            if(head->next != NULL) head = head->next; 
            else break;
        }        
        return std::stoi(s, nullptr, 2); 
    }
};