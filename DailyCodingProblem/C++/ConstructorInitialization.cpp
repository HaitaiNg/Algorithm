#include <iostream>
#include <algorithm>

using namespace std;

class DoYouKnowConstructors
{
  public:
    int x;
  public:
    DoYouKnowConstructors(int xx) : x(xx) {}
    DoYouKnowConstructors(const DoYouKnowConstructors& y) { x = y.x ; x++; }
    void operator =(const DoYouKnowConstructors& testOne) { x = testOne.x; x--;}
};

int main()
{
  DoYouKnowConstructors a(4);
  DoYouKnowConstructors b = a;
  cout << b.x << endl;
  return 0;
}
