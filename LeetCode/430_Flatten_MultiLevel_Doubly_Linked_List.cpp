/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

/*
stack = [ 4,5,6, null, 9, 10, null]
1---2---3-- 7---8---11--12--NULL
iterative pop the item of stack and append to list 
            
*/ 

class Solution {
public:
    Node* flatten(Node* head) {
        Node* temp = head ;
        std::stack<Node*> stackk; 
        while(head)
        {
            if(head->child){
                if(head->next){
                    stackk.push(head->next); 
                }
                head->next = head->child;
                head->next->prev = head; 
                head->child = NULL; 
            }
            else if(head->next == NULL && stackk.size() > 0){
                head->next = stackk.top(); 
                stackk.pop(); 
                head->next->prev = head; 
            }
            else{
                
            }
            head = head->next; 
        }
        return temp; 

    }
};