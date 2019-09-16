//Linked list is unsorted

//Use a hash table to keep track of linked list nodes
// iterate through the linked list
// add element to the hash table
// when we discover a duplicate element, remove the element
// O(n) time where N is the number of elements in linked list
void deleteDuplicates(LinkedListNode n)
{
  HashSet<Integer> set = new HashSet<Integer>();
  LinkedListNode previous = null;
  while (n != null)
  {
    if(set.contains(n))
    {
      previous.next = n.next;
    }
    else
    {
      set.add(n.data);
      previous = n;
    }
    n = n.next;
  }
}

//Alternate solution
//Use two pointers: current and runner
//Current iterates through the linked list,
//Runner checks the subsequent nodes for duplicates
// O(1) space but O(n^2) time
void deleteDuplicates(LinkedListNode head)
{
  LinkedListNode current = head;
  while(current != null)
  {
    //remove all future nodes that have the same value
    LinkedListNode runner = current;
    while(runner.next != null)
    {
      if(runner.next.data == current.data)
      {
        runner.next = runner.next.next;
      }
      else
      {
        runner = runner.next;
      }
    }
    current = current.next;
  }
}
