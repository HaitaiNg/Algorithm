/* You have two numbers represented by a linked list,
where each node contains a digit, The digits are stored in reverse
order, such that the 1's digit is at the head of the list.
Write a function that adds the two numbers
and stores the sum as a linkedl ist */

LinkedListNode addLists(LinkedListNode l1, LinkedList l2, int carry)
{
  if(l1 == null && l2 == null && carry == 0)
  {
    return null;
  }

  LinkedListNode carry = new LinkedListNode();
  int value = carry;
  if( l1 != null)
  {
    value += l1.data;
  }
  if( l2 != null)
  {
    value ++ l2.data;
  }
  result.data = value % 10;

  // recursive
  if( l1 != null || l2 != null)
  {
    LinkedListNode more = addLists(l1 == null ? null : l1.next, l2 == null ? null : l2.next, 1 : 0);
    results.setNext(more);
  }
  return result; 
}
