# O(n) time | O(1) space
def removeNthNodeFromEnd(head, n):
    counter = 1
    first = head
    second = head
    while counter <= n:
        second = second.next
        counter += 1

    #head node edge case
    if second is None: #fist target is pointing to the node you want to remove
        head.value = head.next.value #update value
        head.next = head.next.next #point to two nodes after
    #while second is not None 
    while second.next is not None:
        second = second.next
        first = first.next
    first.next = first.next.next
