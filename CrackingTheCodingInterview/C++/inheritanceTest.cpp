
#include <iostream>
#include <stdio.h>
using namespace std;

class Box
{
public:
  Box() {toPrint(); }
  ~Box() {toPrint(); }
  virtual void toPrint() { cout << "Box" << endl;}
};
class Triangle : public Box
{
public:
  Triangle() {toPrint(); }
  ~Triangle() {toPrint(); }
  virtual void toPrint() { cout << "Triangle " << endl; }
};


int main(int argc, char **argv)
{
  Box* object = new Triangle();
  delete object;
  return 0;

  // Output will be: Box Triangle Box
}
