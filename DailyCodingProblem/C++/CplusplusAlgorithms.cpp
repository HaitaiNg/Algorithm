
int bSearch(int a[],int lo,int hi,int X)
{
  int m = (lo + hi) /2;
  if(lo > hi) return -1; // base 1 if(a[m] == X) return m; // base 2 if(a[m] > X)
    return bsearch(a,lo,m-1,X);
  else
    return bsearch(a,m+1,hi,X);
}



// Computes the greatest common denominator using Euclid's Algorithm
int gcd(int x, int y)
{
  if(x % y == 0){ return y};
  else
  {
  return gcd(y , x % y);
  }
}

//Computes the factorial
int factorial(int n)
{
  if( n == 0) return 1;
  else
  {
    return n * factorial(n-1);
  }
}


//Computes the sum of inteeger array of given size recursively
int arraySum(int array[], int size)
{
  if(array.size() == 0)
  {
    return 0;
  }
  else
  {
    return arraySum(array,size - 1) + array[ size - 1];
  }
}

int arraySum(int array[], int size);
int main()
{
  const int MAX_SIZE = 50;
  int arr[MAX_SIZE];
  int size;

  cout << "Program computes the sum of a list of integer numbers";
  cout << "\n How many numbers are in your list? : ";
  cin >> size;
  if(size > MAX_SIZE)
  {
    cout << "Input is to large. Max number is " + MAX_SIZE;
    exit(1);
  }

  cout << "Enter the list of numbers, separated by spaces : \n";
  for(int i = 0; i < size; i++)
  {
    cin >> arr[i];
  }

  //Print the sum of integer array
  cout << "The sum of all numbers is : " + arraySum(arr, size);
  return 0;
}
