Linked List Notes:
Every node has a pointer to the next node
Doubly linked list to the next node / previous node
Head = beginning of the linked list (only 1 pointer to the next node)
Tail = final node (only 1 pointer to the previous node)
Sorting algorithm for a linked list with minimum time complexity: mergesort
Arrays have better cache locality that can make them better in terms of
performance.
Easy to insert / remove in a linked list. Random access takes linar time
since you have to iterate through all the nodes.
The size of an array has to be pre-determined. Linked Lists can
adjust their size at any runtime.

The process of stepping through a linked list can be thought as being analogous
to a for loop. We initialize a temporary pointer with the list head
We continue iterating until the pointer equals nullptr
With each step we set the pointe to point to the next object

for(Node *ptr = head(); ptr != nullptr; ptr = ptr->next() )
 Be careful of removing the front node in a linked list. Sometimes
you may have problems deleting it properly

STACKS: LIFO
Stacks: parsing code (matching parenthesis, XML), tracking function calls,
dealing with undo / redo operations, reverse-polish calculators,
assembly language. Can be implemented using a singly liked
list or one-ended array
Stack data structure applications
Managing function calls, stock span problem, artihmetic expression evaluation
If a stack is implemented using a linked list, to keep it LIFO ( if nodes)
are appended to the beginning (push), then to remove nodes (pop) must occur
at the beginning of the linked list
If nodes are pushed at the end (push), then nodes have to be removed from the end
(pop)

Depth first search: Create a stack and push the root node onto the stack
while the stack is not empty:
  pop the top node
  push all of the children of that node to the top of the stack in reverse
  order
runtime I(n)
the object on the stack are all unvisited siblings from the root to be
current Node. if each node has a maximum of two children,
the memory required is O(h):
the height of the tree
Depth first traversals are used whenever the parent needs information
about all its children or descendants, or the children require information
about its parents or ancestors

QUEUE: FIFO
Breadth first search, Circular arrays


Selection Sort
Scan the array to find the smallest element
swap it with the first element
Starting with the second element,
scan the elements to the right of it and
find the smallest
swap it with the second element

Pseudo code: O(n^2) on all inputs, O(n) swaps
for i <- 0 to n -2 do
  min <- i
  for j <- i + 1 to n - 1 do
    if a[j] < a[min] min <- j
  swap A[i] and A[min]

  O(n^2) : insertion, selection, bubble
  O(nln(n)) : heap sort, quicksort, merge sort

  Merge sort algorithm is defined recursively:
  - if the list size 1, it is sorted, we are done
  - otherwise:
    -divide an unsorted list into two sub-lists
    -sort each sub-list recursively using merge sort
    -and merge the two sorted sub-lists into a single sorted list

    Divide an unsorted list into two equal or nearly equal sub lists
    Sorts each of the sub lists by calling itself recursively and then
    merges the two sub lists together to form a sorted list

  Perfect binary Trees
  Number of Nodes: 2^(h+1) - 1
  number of leaf nodes: 2^(h)
  Height : log(n + 1 ) - 1

Binary search trees:
  Given a node:
    All objects in the left sub-tree are less than the nodes
    All objects in the right sub-tree are greater than the nodes
    Both Subtrees are also binary search trees

    Tree traversals:
    In-order: left -> root -> right
    Pre-order: root -> left -> right
    Post-order: left -> right -> root

Binary Min Heap:
  Given a node,
      all strict descendants are greater than the node,
      and both sub-trees are also binary heaps
