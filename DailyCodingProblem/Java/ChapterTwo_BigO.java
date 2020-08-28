//Run time is O(sqrt(n))
boolean isPrime(int n ){
  for(int x = 2; x <= sqrt(n); x++)
  {
    if(n%x == 0)
    {
      return false;
    }
  }
  return true;
}


//Run time is O(n)
int factorial(int n )
{
  if(n < 0){
    return -1;
  }
  else if (n == 0)
  {
    return 1;
  }
  else
  {
    return n * factorial(n - 1);
  }
}

//This code counts all permutations of a string
//There are n! permutations.
//Total run time is O(n^2 * n!)
void permutations(String str){
    permutation(str, "");
}

void permutation(String str, String prefix)
{
  if(str.length() == 0)
  {
    System.out.println(prefix);
  }
  else
  {
    for(int i = 0; i < str.length(); i++)
    {
      String rem = str.substring(0, i) + str.substring(i + 1);
      permutation(rem, prefix + str.charAt(i));
    }
  }
}

// Powers of Two
// Function prints the power of 2 from 1 through n (exclusive)
// Run time is O(log(n))
int powersOf2(int n)
{
  if(n < 1) return 0;
  else if (n == 1)
  {
    System.out.println(1); return 1;
  }
  else
  {
    int prev = powersOf2(n / 2);
    int curr = prev * 2;
    System.out.println(curr);
    return curr;
  }
}

// Product of a and b
// O(b)
int product(int a, int b)
{
  int sum = 0;
  for(int i = 0; i < b; i++)
  {
    sum += a;
  }
  return sum;
}

//Power of a^b
// O(b)
int power(int a, int b)
{
  if (b < 0) { return 0;}
  else if (b == 0) { return 1;}
  else return a * power(a, b - 1);
}

//Integer division
// O(a / b)
int div(int a, int b)
{
  int count = 0 ;
  int sum = b;
  while (sum <= a)
  {
    sum += b;
    count++;
  }
  return count
}

/*
If a binary sarch tree is not balanced, how long might it take
(worst case) to find an element in it? O(n). N is the number of nodes in the tree
The max time to find an element is the depth of the tree. The tree could
be straight list downwards and have depth n

You are looking for a specific value in a binary tree, but the
tree is not a binary search tree. O(n). Without a proper ordering, you may
have to search all nodes
*/

/* Computes the intersection (the number of elements in common) of two arrays.
It assumes that neither array has duplicates. It computes the intersection
by sorting one array (array b) and then iterating through array
a checking (via binary search) if each value is in b. What is the run time?

O(blog(b) + alog(b)). First sort array b which takes O(b log b) time.
Then for each element in a, we do binary search ( O(log(b))). The
second part takes O(a log(b)) time
*/

int intersection(int[] a, int[] b)
{
  mergesort(b);
  int intersec = 0;
  for(int x: a) {
    if binarysearch(b, x) >= 0){
      intersect++;
    }
  }
  return intersect;
}

/* Compues the square root of a number. If the number is not a perfect
square, then it returns a -1. It does this by successive guessing. If n is
100, it first guesses 50. Too high? Try something lower - half way between
1 and 50

O(log(n)). This algorithm is doing a binary search to find the square root.
Run time is O(log(n))
*/
int sqrt(int n) { return sqrt_helper(n, 1, n); }
int sqrt_helper(int n, int min, int max)
{
  if(max < min) return -1; // mo squae root
  int guess = (min + max) / 2;
  if( guess * guess = n) return guess;
  else if (guess * guess < n)
  {
    return sqrt_helper(n, guess + 1, max); // try higher
  }
  else
  {
    return sqrt_helper(n, min, guess - 1); // try lower
  }
}

/* Computes the square root of a number. If the number is not a perfect square
return -1. It does this by trying increasingly large numbers until it finds the
right value (or is too high).
O(sqrt(n)) */
int sqrt(int n )
{
  for(int guess = 1; guess * guess <= n; guess++)
  {
    if(guess*guess == n) return guess;
  }
  return - 1
}
