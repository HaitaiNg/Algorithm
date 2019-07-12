using namespace std;

// O(2^n) time | O(n) space
int getNthFib(int n) {
  if(n > 2)
	{
		return getNthFib(n-1) + getNthFib(n-2);
	}
		return n - 1;
}


//O(n) time | O(1) space`
int getNthFib(int n)
{
  int lastTwo[] = {0, 1};
  int counter = 3;
  while(counter <= n)
  {
    int nextFibonacciNumber = lastTwo[0] + lastTwo[1];
    lastTwo[0] = lastTwo[1];
    lastTwo[1] = nextFibonacciNumber;
    counter++;
  }
  return n > 1 ? lastTwo[1] : lastTwo[0];
}
