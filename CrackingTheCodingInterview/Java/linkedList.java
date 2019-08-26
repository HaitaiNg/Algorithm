/*
  During the interview ask whether it is a singly linked list
  or a doubly linked list.
  Singly: pointer to the next node
  Doubly: pointers to both the next and the previous node

  Unlike an array, a linked list does not provide constant time
  access to a particular "index" within the list. If you find the
  kth element in the list, you will need to iterate through the k elements

  Major benefit of a linked list: you can add and remove items from
  the beginning of the list in constant time.

*/

class Node
{
  Node next = null;
  int data;

  public Node(int d)
  {
    data = d;
  }

  void appendToTail(int d)
  {
    Node end = new Node(d);
    Node n = this;
    while(n.next != null)
    {
      n = n.next;
    }
    n.next = end;
  }

  // Deleting a node form a singly linked list
  // Find the previous node, and set prev.next = to n.next
  // 1) check for the null pointers
  // 2) update the head or tail pointer

  Node deleteNode(Node head, int d)
  {
    Node n = head;
    if(n.data == d)
    {
      return head.next; // moved head
    }

    while(n.next != null)
    {
      if(n.next.data == d)
      {
        n.next = n.next.next;
        return head; // head did not change
      }
      n = n.next;
    }
    return head;
  }
}

/* Question (2.1) Remove duplicates from an unsorted linked list */

//Iterate through linked list, add element to hash table.
//If there is a duplicate element, remove the element and continue iterating
// O(n) time, where N is the number of elements in the linked list
void deleteDuplicaes(LinkedListNode n)
{
  HashSet<Integer> set = new HashSet<Integer>();
  LinkedListNode previous = null;
  while(n != null)
  {
    if(set.contains(n.data))
    {
      previous.next = n.next;
    }
    else{
      set.add(n.data);
      previous = n;
    }
    n = n.next;
  }
}

//Alterate solution using two pointers (current and runner (checks all
// subsequent nodes for duplicates))
// Code runs in O(1) space | O(n^2) time
void deleteDuplicates(LinkedListNode head)
{
  LinkedListNode current = head;
  while(current != null)
  {
    // removes all future nodes that have the same value
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
