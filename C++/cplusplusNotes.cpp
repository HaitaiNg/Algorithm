C++ is a compiled language. It is translated
into machine langauge that can be understood directly
by the system.

#include <iostream>
using namespace std;

int main()
{
int a, b;
a = 10;
b = 4;
a = b;
b = 100;
std::cout << a << "  " << b << endl;  // a = 4, b = 100
}

 y /= x; // y = y/x;

Conditional ternary operator (?)
7 == 5 ? 1 : 0
condition ? result1 (true) : result 2 (false)

int i ;
float f = 3.14;
i = (int) f;

The standard header <sstream> defines a type called stringstream
 that allows a string to be treated as a stream, and thus
 allowing extraction or insertion operations from/to strings in
 the same way as they are performed on cin and cout. This feature
 is most useful when converting strings to numerical values

 string myStr("1024");
 int myInt;
 stringstream(myStr) >> myInt;

 ex:

 //stringstream
 #include <iostream>
 #include <string>
 #include <sstream>

 using namespace std;
 int main()
 {
  string myStr;
  int myInt;
  float myFloat:
  std::cin >> myStr >> myInt >> myFloat;
  stringstream(myStr) >> myInt;
 }


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
 cout << a << b << c; // a = 20, b = 10, c = 300
 return 0;
 }

 Arguments by reference do not require a copy. The function
 operates directly on (aliases of) the strings passed
 as arguments and, at most, it might mean the transfer of
 certain pointers to the function
 On the flip side, functions with reference parameters are
 generally perceived as functions that modify arguments passed
 because that is why reference parameters are actually for.

 A :: string concatenate (string a, string b) {return a + b;}
 B :: string concatenate (string& a, string& b) {return a+b;}
 C :: string concatenate (const string& a, const string& b) {return a+b;}

 B will modify the arguments A and B
 C will not modify the reference parameters in the function, By qualifying
 them as const, the function is forbidden to modify the values of netiher a
 nor b, but can actually access their values as references (aliases of the
 arguments), without having to make actual copies of the strings.
 const references provide functionality similar to passing arguments by
 value, but with an increased efficiency for parameters of
 large types.

 #factorial
 #include<iostream>
 using namespace std;

 long factorial(int n)
 {
  if(n >= 1)
  {
  return a * factorial(n-1)
  }
  else
  {
  return 1;
  }
 }

int main()
{
  factorial(5);
}

Overloaded functions: two different funtions can have
the same name but their parameters are different

int foo[5] = {1,2,3,4,5};
int baz[5] = {};
int ccc = {10,20,30 }; // compiler will convert this to : {10,20,30,0,0};
int foo [] = {1,2,3,4,5}; //compiler will automatically determine the size for you

sexier way of creating arrays:
int foo {10,20,30,40};

In C++, it is syntactically correct to exceed the valid range of indices for an array. This can create problems, since accessing out-of-range elements do not cause errors on compilation, but can cause errors on runtime. The reason for this being allowed will be seen in a later chapter when pointers are introduced.

At some point, we may need to pass an array to a function as a parameter. In C++, it is not possible to pass the entire block of memory represented by an array to a function directly as an argument. But what can be passed instead is its address. In practice, this has almost the same effect, and it is a much faster and more efficient operation.

To accept an array as parameter for a function, the parameters can be declared as the array type, but with empty brackets, omitting the actual size of the array. For example:
void procedure (int arg[])
int myarray [40];
procedure( myarray);


Linked List notes.
Every node has a pointer to the next node
Doubly Linked List to the next node / previous node
head = beginning of the linkedd List (only 1 pointer to the next node)
tail = final node (only 1 pointer to the previous node)

Stacks and Queues: the whole organization is based on when the elements were placed in that structure (abstract data structure)
Stacks : LIFO
Queues: FIFO
Implementation Independent data structures: stack, tree, queue, sorted list, graph

Any command starting with a # in the first column is not a C++ / C statement
rather it is a preprocessor statement. The preprocessor performed very basic text-based or lexical substitutuions
Output is sent tothe compiler
Sequence is : file (filename.cpp) -> preprocessor -> compiler (g++)

Templates: Abstract way to implement algorithms: increases the reusability (one of the main reasons of OOP);
Templates can be used with any data structures

Unit for measuring running time: using basic operations
Basic operation is the operation contributing the most to the total running runtime

Selection Sort
-Scan the array to find the smallest element and swap it with the first element
-Starting with the second element, scan the elements to the right of it and find the smallest
and swap it with the second element

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

    
