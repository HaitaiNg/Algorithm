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

Sorting algorithm for a linked list with minimum time complexity : mergesort
Arrays have better cache locality that can make them better in terms of
performance.
Easy to insert / delete in a linked list. Random access is now allowed
in a typical linkedl list ( you have to iterate through all nodes)
Size of an array has to be pre-determined. Linked lists can change
their size at any runtime

Automatically added to every class:
copy constructor, assignment operator, a constructor without any parameters
Compiler creates a default constructor, copy constructor, and an assignment operator

Copy constructor is called: when an object of the class is returned by value;
when an object of the class is passed (to a function) by value as an argument
When an object is constructed based on another object of the same class
when compiler generates a temporary object

Copy constructor uses references: A copy construcotr is called
when an object is passed by value. Copy constructor itself is a
function. So if we pass argument by value in a cpy constructor,
a call to copy constructor would be made to call copy constructor
which becomes a non-terminating chain of calls.

Members of a class are private by default
Members of a struct are public by default
When deriving a struct from a class / struct, default access specifier for a
base class /struct is a public and when deriving a class,
default access specifier is private

Difference between compile error and run time error?

Objects of a class do not share non static members. Every object has
its own copy. Every object maintains a copy of non-static
data members. Static members are shared among obkects. All
objects share codes of al examples.

A membe function can always access the data in (the class of which it is a
member) in C++

A member function can access it's class member variables irrespective
of the access specifier in which the member variable is declared. So a member
function can always access the data in the class of which it is a member

Inline functions are useful when function is small and we want to
avoid function call overhead

Destructors can be private

C++
C++ constructors 10/21
References 0/6
Class and object 10/17
Destructors 2/4






#include <iostream>
using namespace std;
class A
{
  int id;
  static int count;
public:
  A()
  {
    count++;
    id = count;
    cout << "constructor for id " << id << endl;
  }
  ~A()
  {
    cout << "destructor for id" << id << endl;
  }
};
int A::count = 0;
int main()
{
  A a[3];
  return 0;
}

// Output
constructor for id 1
constructor for id 2
constructor for id 3
destructor for id 3
destructor for id 2
destructor for id 1

Stack data structure applications
Managing function calls, stock span problem, artihmetic expression evaluation
If a stack is implemented using a linked list, to keep it LIFO ( if nodes)
are appended to the beginning (push), then to remove nodes (pop) must occur
at the beginning of the linked list
If nodes are pushed at the end (push), then nodes have to be removed from the end
(pop)

When you visit a website, the web server
hosting that site could be anywhere in the world.
In order for you to find the location of the
web server, your browser will first connect
to a domain name server (DNS) server
A DNS is like a phone book

If a lambda captures a local by reference, which negative outcome may happen?
The value may go out of scope before lambda uses it
What does the #include directive do?
Locates symbols in target file and allows their use of the current line

When can functions be overloaded?
When there is a diferent number of parmeters and/or types of parameters

If a function returns **this then the return type should be by reference
'\n' vs std::endl  :: std::endl is slower because of the flush


try
    {
  string s1("abc");
  string s2("def");
  s1.append(s2, 4, 3);
  cout << s1 << endl;
    }
  catch (exception &e)
    {
  cerr << "Exception: " << e.what() << endl;
  cerr << "Type: " << typeid(e).name() << endl;
};

// INvalid tring position, class std::out_of_range exception is thrown

std::accumulate(begin(numbers), end(numbers), 0); // 0 is the starting point
//value for the local

What is the name of the function the compiler runs when an object
goes out of scope? destructor
What does the keyword "final" do when applied to a method?
It means that the method can't be overrideen in a derived class

Why would a function take an object by reference (instead by value)
if the function will not change that object?
To save the cost of a copy

What is the purpose of c_str() member function of std::string?
It provides a char* to pass to legacy code tha doesn't know std::string


#include <iostream>
using namespace std;
double x=1.0;
void f()
{
  int y=2;
  {
    float z=3.0f;
    y = (int)z;
  }
  cout << "end of f";
}
int main()
{
  f();
  return 0;
}

// x and y are still in scope at the cout statement


int x = 1;
switch(x)
{
   case 1 : // code
   case 2 : // code
   case 3 : // code
   break;
   default: // code
}

//the code for the first three test cases will execute
//In orer to make an efective case / switch statement, you must include "break"
//statements

Class D is derived from class B. Given the following: catch (const B *)
{} if a type D+ is thrown, what will happen? The exception will be caught


What will the final values of x, y, and z be?
int x = 0; int y = ++x; int z = x++;  // x = 2, y = 1, z = 1

Which errors are more likely to be fixed by #include statements
//Both comiler and linker errors

// ----------------------------------- //
struct Animal
{
  virtual void sound() const { cout << "eek"; }
};
struct Human : Animal
{
  void sound() const { cout << "hello"; }
};
struct Scientist : Human
{
  void sound() const { cout << "greetings"; }
};

//What will the following print?
Animal* animal = new Scientist();
animal->respond();
// The code will output (greetings)

A void pointer can be cast (at your own risk) to: any kind of pointer
Linked list: faster than vector for adding new elements \ Slower than vector for accessing elements


Sexy ass lambda code
vector<double> dv;
transform(v.begin(), v.end(), back_inserter(dv) [](int n) -> double
{
	if(na%2 == 0)
	{
		return n*n*n;
	}
	else{
		return n / 2.0;
	}
}};

What is a lambda? represent an operation or function object
Compiler generates an anonymous function object:
overrides (operator - the function call)
	parameters are the () of the lambda
	return type is after the -> of the lambda
Look up lambdas C++

Lambdas make for_each and other standard library functions suddenly usable
Open the doors for interesting parallel and functional work
Parallel for_eaches on the CPU and GPU, take the exact same parameters
and you can parallelized across the CPU / GPU.
C++11 Lambdas offer more control than other languages
	/ capture by value or reference
	/C++ is all about power and performance.

Simplest way to handle expected errors is to test for them
Deal with them rigth where they are discovered
Sometimes the code that finds the problem cannot deal with it

One approach
Have the function return an indication of trouble
Eg: UpdateTimeSheet() returns true or false
Constructors cannot return anything
That is why some developers use INIT
A try block can have multiple catch statements
Only the first exception will be executed
Catch more specific exceptions first
Catch exceptions by reference


using namespace std;
int _tmain(int argc, _TCHAR* argv[])
{
	try{
		vector<int> v;
		v.push_back(1);
		int j = v.at(99);
	}
	catch (out_of_range& oor)
	{
	}
	catch (exception& e)
	{
		cout << e.what();
	}

	return 0
}

C++ allows you to throw and catch anything
THe standard library includes an exception class that way the
developer does not have to define everything

sd::exception
Has a member function: what() - returns a string
Has a number of derived classes
logic_error:
	-domain_error
	-invalid_argument
	-length_error
	-out_of_range

Unwinding the stack
When an exception is thrown

Unwinding the stack
If in a try, everything local to try goes out of scope:
	destructors go off
	control goes to the catch
If not, everything local to the function goes out of scope
	control returns to where that function was called from
	recurse to "if in a try" above


Compare these situations

//Why is this scenario bad? Potential memory leaks
//what if delete x is not called?
try
{
	auto x = new X(stuff);
	// risky stuff
	delete x;
}
catch ( exception& e)
{
	//react
}


//Better solution
// Stack will call destructor and delete X after
// the exception is thrown
// You want it such that unwinding the stack
// automatically deletes and frees memory leaks
try
{
	auto x = make_sharead<X>(stuff);
	//risky stuff
}
catch (exception& e)
{
	// react
}

Time is used up if an exception is thrown
Otherwise it is very little cost
using exceptions make neater code that runs faster
when everything runs nicely

typedef: used to define your own types

Feature of C++ 2011
TwoNumberSum.cpp:16:12: warning: generalized initializer lists are a C++11 extension [-Wc++11-extensions]
                                return {array[leftPointer], array[rightPointer]};
                                       ^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
TwoNumberSum.cpp:16:12: error: non-aggregate type 'vector<int>' cannot be initialized with an initializer list
                                return {array[leftPointer], array[rightPointer]};
                                       ^~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
TwoNumberSum.cpp:27:10: warning: generalized initializer lists are a C++11 extension [-Wc++11-extensions]
                return {};
                       ^~
TwoNumberSum.cpp:27:10: error: non-aggregate type 'vector<int>' cannot be initialized with an initializer list
                return {};
