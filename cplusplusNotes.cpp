In C++, it is not possible to pass the entire block of memory represented by an
array to a function directly as an argument.
But what can be passed instead is its address. In practice, this has
almost the same effect, and it is a much faster and more efficient operation.

To accept an array as parameter for a function, the parameters can be declared
as the array type, but with empty brackets, omitting the actual size of the array
void procedure (int arg[])
int myarray [40];
procedure( myarray);

Any command starting with a # in the first column is not a C++ / C statement
rather it is a preprocessor statement.
The preprocessor performed very basic text-based or lexical substitutuions
Output is sent tothe compiler
Sequence is : file (filename.cpp) -> preprocessor -> compiler (g++)

Templates: Abstract way to implement algorithms:
increases the reusability (one of the main reasons of OOP);
Templates can be used with any data structures

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
//-------------------- \\
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

//-------------------- \\

int main() {
    int a; long b; char c; float d; double e;
    scanf("%i %li %c %f %lf", &a, &b, &c, &d, &e);
    printf("%i\n%li\n%c\n%.03f\n%.09lf\n", a, b, c, d, e);
    return 0;
}


These are automatically added to every class:
copy constructor, assignment operator, a constructor without any parameters
Compiler creates a default constructor, copy constructor,
and an assignment operator
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

Objects of a class do not share non static members. Every object has
its own copy. Every object maintains a copy of non-static
data members. Static members are shared among obkects. All
objects share codes of al examples.

A member function can always access the data in (the class of which it is a
member) in C++. A member function can access it's class member variables
irrespective of the access specifier in which the member variable is declared.
So a member function can always access the data in the class of which it is
a member

Inline functions are useful when function is small and we want to
avoid function call overhead
Destructors can be private

Virtual function in C++ must be declared in public sections of class
Virtual function should be accessed using pointers
Virtual function is defined in base class
Virtual functions cannot be static
In C++ polymorhism requires: inheritance, virtual functions and references
Polymorphism means having many forms. Polymorphism occurs when there
is a hierarchy of classes and they are related by  which
include virtual functions and references

Method over-riding can be prevented by using final as a modifier
at the start of the method declaration

#includ <iostream>
using namespace std;
int x = 1;
void fun()
{
  int x = 2;
  {
    int x = 3;
    cout << ::x << endl;
  }
}
int main()
{
  fun();
  /* The value of ::x is 1. The scope resolution operator when
   used with a variable name, always refers to global variable.*/
  return 0;
}
// ------------------ \\
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

// Invalid tring position, class std::out_of_range exception is thrown
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
Linked list: faster than vector for adding new elements \ Slower than vector
for accessing elements

What is a lambda? represent an operation or function object
Compiler generates an anonymous function object:
overrides (operator - the function call)
	parameters are the () of the lambda
	return type is after the -> of the lambda

Lambdas make for_each and other standard library functions suddenly usable
Open the doors for interesting parallel and functional work
Parallel for_eaches on the CPU and GPU, take the exact same parameters
and you can parallelize across the CPU / GPU.
C++11 Lambdas offer more control than other languages
	/ capture by value or reference
	/C++ is all about power and performance.

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
// ----------------------- \\
#include <iostream>
using namespace std;

class Test
{
    static int x;
public:
    Test() { x++; }
    static int getX() {return x;}
};

int Test::x = 0;

int main()
{
    cout << Test::getX() << " ";
    Test t[5];
    cout << Test::getX();
    // output - 0 5
    // static functions can be called without any object.
    // The call to Test::GetX() is fine. Since x is initialized as 0, the first
    // call to getX(0 returns 0. When an array of 5 objects is created,
  // the constructor is called 5 times. So X is incremented to 5 before the next call
 //to get X )
}

#include <iostream>
using namespace std;

class Player
{
private:
    int id;
    static int next_id;
public:
    int getID() { return id; }
    Player()  {  id = next_id++; }
};
int Player::next_id = 1;

int main()
{
  Player p1;
  Player p2;
  Player p3;
  cout << p1.getID() << " ";
  cout << p2.getID() << " ";
  cout << p3.getID();
  return 0;

  // output = 1 2 3
  /* if a member variable is delcared as static, all objects of that class
  have access to a single instance of that variable. Static variables
  are sometimes called class variables, class fields, or class-wide
  fields because they do not belong to a specific object;
  They blong to the class.

  //Static methods can only access static members (data and methods)
  //static members are accessible in non-static functions, so no
  // problem with accessing count in fun(). Also note that
  // fun() returns the same object by reference
  */
}


#include<iostream>
using namespace std;

class Test
{
private:
    static int count;
public:
    Test& fun();
};

int Test::count = 0;

Test& Test::fun()
{
    Test::count++;
    cout << Test::count << " ";
    return *this;
}

int main()
{
    Test t;
    t.fun().fun().fun().fun(); // 1 2 3 4
    return 0;
}

// ---------------- \\

#include <iostream>
using namespace std;
union A
{
  int a;
  unsigned int b ;
  A() { a = 10; }
  unsigned int getB() { return b; }
};
int main()
{
  A obj;
  cout << obj.getB(); // output = 10
  return 0;
}

/* Like struct and class, union can have methods. Like struct and
unlike class, members of union are public by default. Since
data members of union share memory, the value of b becomes same as a
*/

Inline functions do type checking for parameters, macros do not
Macros are processed by pre-processor and inline functions are
processed in larger stages of compilation
macros cannot have return statement, inline functions can
macros are not prone to bugs and errors, inline functions are not.

How can we make a C++ class such that objects of it can only be created using
new operator? If user tries to create an object directly,
the program produces compiler error.

// Objects of test can only be created using new
class Test
{
private:
    ~Test() {}
friend void destructTest(Test* );
};

// Only this function can destruct objects of Test
void destructTest(Test* ptr)
{
    delete ptr;
}

int main()
{
    // create an object
    Test *ptr = new Test;

    // destruct the object
    destructTest (ptr);

    return 0;}


--------------------------------------
#include <iostream>
#include <vector>
using namespace std;

class a
{
public :
    ~a()
    {
        cout << "destroy";
    }
};
int main()
{
   vector <a*> *v1  = new vector<a*>;
   vector <a> *v2  = new vector<a>;
   return 0;
}
// no destructor call

------------------------------------
#include <iostream>
using namespace std;
int x[100];
int main()
{
  cout << x[99] << endl; // 0
  // In C++ all uninitalized global variables are initialized to 0 ß
}

------------------------------------
The associativity of which of the following operators is left
to Right in C++? Array element access
A member function can always access the data in the class of which it is member
(in C++)

A memeber function can access it's class member variables, irrespective of the
access specifier in which the member variable is declared. So a member function
can always access the data in the class of which it is a member

----------------

#include <iostream>
using namespace std;
class A
{
protected:
    int x;
public:
    A() {x = 0;}
    friend void show();
};

class B: public A
{
public:
    B() : y (0) {}
private:
    int y;
};

void show()
{
    A a;
    B b;
    cout << "The default value of A::x = " << a.x << " ";
    cout << "The default value of B::y = " << b.y;
}

/* Compiler error in show() because y is private in class B
Please note that show() is a friend of class A, so there should not be any compiler error in accessing any member of A in show(). Class B is inherited from A, the important point to note here is friendship is not inherited. So show() doesn't become a friend of B and therefore can't access private members of B. */

If a function is friend of class:
A function can only be declared a friend by a friend itself
Friend functions are not members of a class, they are associated with it
It can have access to all members of the class, even priate ones

Friend of class can be member of some other class but Friend functions
are not the members of a particular class

All member functions of the class granted friendship
have unrestricted access to the members of the class granting
the friendship

When a class grants friend status to another class then
all member functions of the class granted friendship have
unrestircted access to the members of the class granting the frienship
Class friendship is not recprocal to each other

How can we restrict dynamic allocation of objects of a class using new?
By making an empty private new and new[] operators

If we declare new and [] new operators, then the objects cannot be created anywhere (within the class and outside the class) See the following example. We can not allocate an object of type Test using new.
#include <stdlib.h>
#include <stdio.h>
#include <iostream>

using namespace std;

class Test {
private:
    void* operator new(size_t size) {}
    void* operator new[](size_t size) {}
};

int main()
{
    Test *obj = new Test;
    Test *arr = new Test[10];
    return 0;
}

Following operators cannot be overloaded
. (member access or dot operator)
?: (ternary or conditional operator)
:: (scope resolution operator)
.* (pointer-to-member operator)

Which of the following operators are overloaded by default by the compiler in
every user defined class een if user has not written?
1) comparison operator ( == )
1) assignment operator ( = )

Assign operator is by default available in all user defined classes even if user has not implemented. The default assignement does shallow copy. But comparison operator "==" is not overloaded.

cout is an object of ostream class which is a compiler defined class. When we do "cout << obj" where obj is an object of our class, the compiler first looks for an operator function in ostream, then it looks for a global function. One way to overload insertion operator is to modify ostream class which may not be a good idea. So we make a global method. Following is an example.

#include <iostream>
using namespace std;

class Complex
{
private:
    int real;
    int imag;
public:
    Complex(int r = 0, int i =0)
    {
        real = r;
        imag = i;
    }
    friend ostream & operator << (ostream &out, const Complex &c);
};

ostream & operator << (ostream &out, const Complex &c)
{
    out << c.real;
    out << "+i" << c.imag;
    return out;
}

int main()
{
    Complex c1(10, 15);
    cout << c1;
    return 0;
}


How doe a C++ compiler differ between overloaded postfix and prefix
operators?
A postfix ++ has a dummy parameter

Virutal functions are functions that can be overridden in derived class
with the same signature
Virtual functions enable run-time polymorphim in a
inheritance hierarchy
If a function is "virtual" in the base class, the most deri-ved
class's implementation of the function is called according to the
actual type of the object referred to, regardless of the declared type
of pointer or reference. In non-virutal functions,
the functions are called according to the type of reference or poiinter

include<iostream>
using namespace std;

class Base
{
public:
    virtual void show() { cout<<" In Base n"; }
};

class Derived: public Base
{
public:
    void show() { cout<<"In Derived n"; }
};

int main(void)
{
    Base *bp = new Derived;
    bp->show(); // In dericed

    Base &br = *bp;
    br.show(); // In derived

    return 0;
}
// since show is virtual in base class, it is called
//according to the type of object being referred or pointed, rather than
// the type of pointer pr reference


if a class has a pure virtual function, then the class becomes abstract
class and an instance of this class cannot be created.



#include<iostream>
using namespace std;

class Base
{
public:
    virtual void show() = 0;
};

int main(void)
{
    Base b; //< There is a compiler error in line "base B"
    Base *bp;
    return 0;
}

Since base B has a pure virtual function, it becomes an abstract class
and an instance of it cannot be created.


#include<iostream>
using namespace std;
class Base
{
public:
    virtual void show() = 0;
};

class Derived : public Base { };

int main(void)
{
    Derived q; //< Compiler error: derived is abstract
    return 0;
}
If we do not override the pure virtual function in derived class ,
then derived class also becomes an abstract class

#include<iostream>
using namespace std;

class Base
{
public:
    virtual void show() = 0;
};

class Derived: public Base
{
public:
    void show() { cout<<"In Derived n"; }
};

int main(void)
{
    Derived d;
    Base &br = d;
    br.show(); // "in Derived"
    return 0;
}

A constructor cannot be virtual. Making a constructor does not make snese as
a constructor is responsible for creating an object
and it cannot be delegated to any other object by virtual keyword means

#include<iostream>
using namespace std;
class Base  {
public:
    Base()    { cout<<"Constructor: Base"<<endl; }
    virtual ~Base()   { cout<<"Destructor : Base"<<endl; }
};
class Derived: public Base {
public:
    Derived()   { cout<<"Constructor: Derived"<<endl; }
    ~Derived()  { cout<<"Destructor : Derived"<<endl; }
};
int main()  {
    Base *Var = new Derived();
    delete Var;
    return 0;
}

Constructor: Base
Constructor: Derived
Destructor : Derived
Destructor : Base

Static functions cannot be virtual. Static functions are class specific
and may not be called on objects.



#include <iostream>
using namespace std;

class A
{
public:
    virtual void fun();
};

class B
{
public:
   void fun();
};

int main()
{
    int a = sizeof(A), b = sizeof(B);
    if (a == b) cout << "a == b";
    else if (a > b) cout << "a > b";
    else cout << "a < b";
    return 0;
}

// Output ( A > b)
Class A has a VPTR which is not there in class B. In a typical implementation of virtual functions, compiler places a VPTR with every object. Compiler secretly adds some code in every constructor to this.


#include <iostream>
using namespace std;

class A
{
public:
    virtual void fun() { cout << "A::fun() "; }
};

class B: public A
{
public:
   void fun() { cout << "B::fun() "; }
};

class C: public B
{
public:
   void fun() { cout << "C::fun() "; }
};

int main()
{
    B *bp = new C;
    bp->fun();
    return 0;
} // A::fun()

The important thing to note here is B::fun() is virtual even if we have not uses virtual keyword with it. When a class has a virtual function, functions with same signature in all descendant classes automatically become virtual. We don't need to use virtual keyword in declaration of fun() in B and C. They are anyways virtual.

A base class function can be accessed with scope resolution operator even if the function is virtual.

#include <iostream>
using namespace std;
int main()
{
    const char* p = "12345"; // pointer to a constant
    const char **q = &p; // pointer to a pointer
    *q = "abcde"; // changes p to point to "abcde"
    const char *s = ++p; // assigns addresses of literal 'bcde" to s
    p = "XYZWVU";
    cout << *++s; // c
    return 0;
}

In C++, const qualifer can be applied to: member functions of a class;
function arguments; to a class data member which is declared as static;
reference variables. When a function is declaread as const, it
cannot modify data members of its class. When we do not want to
modify an argument and pass it as reference or pointer, we use const qualifier
so that the argument is not accidentally modified in function

Class data members members can be declaread as both const and static for
class wide constants.

#include <iostream>
using namespace std;
class Point
{
    int x, y;
public:
 Point(int i = 0, int j =0)
   { x = i; y = j;  }
   int getX() const { return x; }
   int getY() {return y;}
};

int main()
{
    const Point t;
    cout << t.getX() << " ";
    cout << t.gety(); //< there is compiler error. A const object can only call
                      // const functions
    return 0;
}


// --------------- \\
#include <stdio.h>
int main()
{
   const int x;
   x = 10;
   printf("%d", x);
   return 0;
   /* Compiler error: one cannot change the value of 'const' variable
   except at the time of initialization. Compiler does check this */
}x

// ------------ \\
#include <iostream>
int const s = 9;
int main()
{
  std::cout << s;
  return 0;
}

Template is a feature of C++ that allows us to write one code
for different data types
We can write one function that can be used for all data types including
user defined types. Like sort(), max(), min()
We can write one class or struct that can be used for all data types
including user defined types. Like linked lists, stack, queue

#include <iostream>
using namespace std;

template <typename T>
void fun(const T&x)
{
    static int count = 0;
    cout << "x = " << x << " count = " << count << endl;
    ++count;
    return;
}

int main()
{
    fun<int> (1);
    cout << endl;
    fun<int>(1);
    cout << endl;
    fun<double>(1.1);
    cout << endl;
    return 0;
}

/* x = 1 count = 0
   x = 1 count = 1
   x = 1.1 count = 0

   Compiler creates a new instance of a template function for every data type
   So compiler creates two functions in the above example, one for int,
   one for double. Every instance has its own copy of static variable.
   The int instance of function is called twice, so count is incremented for
   the second call
*/

#include <iostream>
using namespace std;

template <class T>
class Test
{
private:
    T val;
public:
    static int count;
    Test()  {   count++;   }
};

template<class T>
int Test<T>::count = 0;

int main()
{
    Test<int> a;
    Test<int> b;
    Test<double> c;
    cout << Test<int>::count   << endl; // 2
    cout << Test<double>::count << endl; // 1
    return 0;
}

/*
  There are two classes created by the template
  Test and test
  Since each count is a static member, every class
  has its own copy of it.
  Also counts get incremented in constructor
*/


Assume that the size of char is 1 byte and size of int is 4 bytes, and there is no alignment done by the compiler.
#include<iostream>
#include<stdlib.h>
using namespace std;

template<class T, class U>
class A  {
    T x;
    U y;
    static int count;
};

int main()  {
   A<char, char> a;
   A<int, int> b;
   cout << sizeof(a) << endl; // 2
   cout << sizeof(b) << endl; // 8
   return 0;
}

//C++ STL
#include <vector>
#include <algorithm> // sort(A.begin(), A.end());
binary_search(A.begin(), A.end(), 3);  //O(log(n))
A.push_back(100);

vector<int>::iterator it = lower_bound(A.begin(), A.end(), 100); //first element binary search
vector<int>::iterator it = upper_bound(A.begin(), A.end(), 100); //last element binary search

auto it = lower_bound(A.begin(), A.end(), 100);

//Sorting in reverse order
bool f(int x, int y)
{
return x > y; }

sort(A.begin(), A.end(), f);

vector<int>::iterator it3;
for(it3 = A.begin(); it3 != A.end(); it3++)
{
	cout << *it3 << "\n";
}

for(int &x: A) //references
{
	x++; // since you are doing by reference. you are modifying the contents of the vector
	cout << x << " ";
}

#include <set>
set<int> s;
s.insert(1);
s.insert(5);
s.insert(-10);

for(int x : S) //set will print in sorted order
{
	cout << x << " ":
}


auto it = s.find(-1);

mapDemo
#include <map>
map<int, int> A;
A[1] = 100;
A[2] = -1;
A[3] = 200;
A[1324213] = 1;

map<char,int > cnt;
string x = "test";
for(char c : x)
{
	cnt[c]++;
}
A.find(key); // log(n)
A.erase(key); // log(n)

Unodered sets have O(1) average time
Set uses less memory than unordered_set to store the same number of elements
For a small number of elements, looksups in a set might be faster than
lookups in an unordered set
Even though many operations are faster in the average case
for unordered_set_ they are often guranted to hae better worse case
complexities for set
The set sorts the element is useful if you want to access them in order
