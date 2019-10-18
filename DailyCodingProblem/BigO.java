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
