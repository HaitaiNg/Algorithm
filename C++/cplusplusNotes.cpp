 // arguments passed by value and reference
  #include <iostream>
 using namespace std;

 void duplicate( int& a, int& b, int& c)
 {
  a *= 2;
  b *= 5;
  c *= 10;
 }

 int main()
 {
 int a = 10, b = 2, c = 30;
 duplicate(a, b c); // a = 20, b = 10, c = 300
 return 0;
 }

In C++, it is syntactically correct to exceed the valid range of indices for an array.
This can create problems, since accessing out-of-range elements do not cause errors on compilation,
 but can cause errors on runtime. The reason for this being allowed will be seen in a later chapter when pointers are introduced.

At some point, we may need to pass an array to a function as a parameter.
In C++, it is not possible to pass the entire block of memory represented by an array to a function directly as an argument.
But what can be passed instead is its address. In practice, this has almost the same effect, and it is a much faster and more efficient operation.

To accept an array as parameter for a function, the parameters can be declared as the array type, but with empty brackets, omitting the actual size of the array. For example:
void procedure (int arg[])
int myarray [40];
procedure( myarray);


Linked List notes.
Every node has a pointer to the next node
Doubly Linked List to the next node / previous node
head = beginning of the linkedd List (only 1 pointer to the next node)
tail = final node (only 1 pointer to the previous node)

Stacks : LIFO
Queues: FIFO

Any command starting with a # in the first column is not a C++ / C statement
rather it is a preprocessor statement.
The preprocessor performed very basic text-based or lexical substitutuions
Output is sent tothe compiler
Sequence is : file (filename.cpp) -> preprocessor -> compiler (g++)

Templates: Abstract way to implement algorithms:
increases the reusability (one of the main reasons of OOP);
Templates can be used with any data structures

Selection Sort
Scan the array to find the smallest element and swap it with the first element
Starting with the second element, scan the elements to the right of it and
find the smallest and swap it with the second element

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

    bool List: empty() const {return (list_head == nullptr);}
if you tried to access a member function of a pointer set to nullptr,
we would be accessing restricted memory. OS would terminate program

The proces of stepping through a linked list can be thought as being analogous
to a for loop. We initialize a temporary pointer with the liste head
We continue iterating until the pointer equals nullptr
With each step we set the pointe to point to the next object

for(Node *ptr = head(); ptr != nullptr; ptr = ptr->next() )
 Be careful of removing the front node in a linked list. Sometimes
you may have problems deleting it properly

Stacks: parsing code (matching parenthesis, XML), tracking function calls,
dealing with undo / redo operations, reverse-polish calculators, assembly language
Can be implemented using a singly liked list or one-ended array

XMHTML : a markup language is a means of annotating a document to given context
to the text/ The annotations give information about the structure or
presentation of the text

Nesting indicates that any closing tag must match the most recent opening tag
Strategy for pasing XHTML:
	-read through the xmhtml linearly
	-place the opening tags in a stack
	-when a closing tag is encountered, check that it matches what is on top
	of the stack and oop
Reverse Polish Notation Prefix

Queue: FIFO
Linked List array (Queue is best used for Breadth Frist Search)
Circular arrays

-place the root directory into a Queue
-while the queue is not empty:
  dequeue the directory at the front of the Queue
  enqueue all of its subdirectories into the queue

Depth first traversal:
use a Stack: create a stack and push the root node onto the Stack
while the stack is not empty:
  pop the top Node
  push all of the children of that node to the top of the stack in reverse order
run time is O(n)
the object on the stack are all unvisted siblings from the root to be current Node
if each node has a maximum of two children, the memory required is O(h):
the height of the tree

Depth first traversals are used whenever the parent needs information
about all its children or descendants, or the children require information
about its parents or ancestors

In designing a depth-first traversal: it is necessary to consider:
before the children are traversed, what initializations, operations, and calculations must be performed?
in recursively traversing the children:
  what information must be passed to the children during the recursive call?
  what information must the children pass back, and how must this information be collated?
Once all children have been traversed, what operations and calculations depend on information
collated during the recursive traversals?

Perfect binary Trees
Number of Nodes: 2^(h+1) - 1
number of leaf nodes: 2^(h)
Height : lg(n + 1 ) - 1

lect 9 - lecture 13
Binary search tree:
given a nodes
  all objects in the left sub-tree are less than the nodes
  all objects in the right sub-tree are greater than the nodes
  and both-subtrees are also binary search trees

binary  min heap:
given a node,
  all strict descendants are greater than the node,
  and both sub-trees are also binary heaps

  Review graphs

Breadth first: Queue
depth first : stack
Topological sort

perfect binary tees:
number of nodes: 2^(h + 1) - 1
number of leaf nodes: 2^(h)

Tree traversals:
In-order: left -> root -> right
Pre-order: root -> left -> right
Post-order: left -> right -> root

Double-ended queues are sequence containers
with dynamic sizes that can be expanded or contracted
on both ends (either its front or its back)
Deques are not guaranteed to store all of its
elements in contiguous storage locations:
accessing elements in a deque by offsetting a
pointer to another element causes undefined behavior

A pointer in C is a way to share a memory address among
different contexts (prmarily functions). They
are primarily used whenever a function needs to modify the content
of a variable, of which it doesn't have ownership.
& returns the memory address of a variable
int*p = &val; //asigns the memory address of val to pointer p
To access the content of the memory to which the pointer points,
prepend it with a *. *p will return the value reflected by val
and any modications to it will be reflected at the source


void increment(int *v)
{
  (*v)++;
}

int main()
{
  int a;
  scanf("%d", &a);
  increment(&a);
  printf("%d", a);
  return 0;
}

-----------------

#include <stdio.h>
#include <cmath>

void update(int *a,int *b) {
    int sum = *a + *b;
    int absDifference = *a - *b > 0 ? *a - *b : -(*a - *b);
    *a = sum;
    *b = absDifference;
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;
    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);
    return 0;
}
------------

int main() {
    int a; long b; char c; float d; double e;
    scanf("%i %li %c %f %lf", &a, &b, &c, &d, &e);
    printf("%i\n%li\n%c\n%.03f\n%.09lf\n", a, b, c, d, e);
    return 0;
}
An array is a series of elements of the same type placed in contiguous memory locations that can be individually referenced by adding an index to a unique identifier.

stringstream is used to parse-common stringstream
