/* Singly linked list.
   Use three pointers.

   One pointer is a runner. Runner pointer is
   (n) spaces ahead, where n is the nth node we want to remove from the end.

   One pointer is located at position (n - 1)

   = ( i - 1 ) , (i , (n + i)
   Remove nth node
   Time = O(n) // One traversal
   Space = O(1)
 */

class LinkedList{
public:
  int value;
  LinkedList* next;
  LinkedList(int value);
  void addMany(vector<int> values);
  vector<int> getNodesInArray();
};

//O(n) time | O(1) spaces
void removeKthNodeFromEnd(LinkedList* head, int k)
{
  int counter = 1;
  LinkedList* first = head;
  LinkedList* second = head;
  while(counter <= k)
  {
    second = second->next;
    counter++;
  }

 // head node edge case
  if(second == NULL)
  {
    // first target is pointing to the node you want to remove
    head->value = head->next->value;
    // point to two nodes after 
    head->next = head->next->next;
    return;
  }

  while(second->next != NULL)
  {
    second = second->next;
    first = first->next;
  }
  first->next = first->next->next;
}
