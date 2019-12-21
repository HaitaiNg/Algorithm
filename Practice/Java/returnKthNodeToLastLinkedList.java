
/* recurses through the linked list. Hit the end */

int printKthToLast(LinkedListnode head, int k)
{
  if(head == null)
  {
    return 0;
  }
  int index = printKthToLast(head.next, k) + 1;
  if(index == k)
  {
    System.out.println(k +  "th to last node is " + head.data);
  }
  return index;
}


/* Using two pointers. Place them k nodes apart in the linked list by putting
p2 at the beginning and moving p1 k nodes into the list.
p1 will hit the end of the linked list after LENGTH - k steps.
At that point LENGTH - k nodes into the list, or k nodes from the end

 This algorithm takes O(n) time and O(1) space 
*/

LinkedListNode nthTolast(LinkedListNOde head, int k)
{
  LinkedListNode p1 = head;
  LinkedListNode p2 = head;
  // move p1 k nodes into the list
  for(int i = 0; i < k; i++)
  {
    if(p1 == null) return null; //out of bounds
    p1 = p1.next;
  }
  // Move them at the same pace. When p1 hits the end, p2 will be at the right
  // element
  while( p1 != null)
  {
    p1 = p1.next;
    p2 = p2.next;
  }
  return p2;
}
