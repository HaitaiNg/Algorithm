/*
  One pass algorithm.

  Time complexity is O(L). Two traversals of the list of L nodes
  Space complexity is O(1).

   Use two pointers. The first pointer
  will advance the list by n+1 steps from the beginning,
  while the second pointer starts from the beginning of the list.
  Both pointers are separated by n nodes apart. We
  maintain this constant gap by advancing both pointers
  together until the first pointer arrives
  past the last node.

  The second pointer will be pointing at the nth node
  counting from the last. We relink the next pointer
  of the node referenced by the second pointer to point to The
  node's next next node.

  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode first = dummy;
      ListNode second = dummy;
      // Advances first pointer so that the gap between first and second is n nodes apart
      for (int i = 1; i <= n + 1; i++) {
          first = first.next;
      }
      // Move first to the end, maintaining the gap
      while (first != null) {
          first = first.next;
          second = second.next;
      }
      second.next = second.next.next;
      return dummy.next;
  }
*/



class Program {
	public static int count = 0;
  public static void removeKthNodeFromEnd(LinkedList head, int k) {
		int sizeOfLinkedList = 1;
		LinkedList firstPointer = head;
		LinkedList secondPointer = head;
		while(sizeOfLinkedList <= k)
		{
			secondPointer = secondPointer.next;
			sizeOfLinkedList++;
		}
		if(secondPointer == null)
		{
			head.value = head.next.value;
			head.next = head.next.next;
			return;
		}
		while(secondPointer.next != null)
		{
			secondPointer = secondPointer.next;
			firstPointer = firstPointer.next;
		}
		firstPointer.next = firstPointer.next.next;
  }

  static class LinkedList {
    int value;
    LinkedList next = null;

    public LinkedList(int value) {
      this.value = value;
    }
  }
}
