#include <vector>
using namespace std;

class BinaryTree
{
public:
  int value;
  BinaryTree *left;
  BinaryTree *right;
  BinaryTree(int value);
  void insert(vector<int> values, int i = 0);
  void invertedInsert(vector<int> values, int i = 0);
};

void swapLeftAndRight(BinaryTree* tree);

void invertBinaryTree(BinaryTree* tree)
{
  if(tree == NULL)
  {
    return;
  }
  swapLeftAndRight(tree);
  invertBinaryTree(tree->left);
  invertBinaryTree(tree->right);
}

void swapLeftAndRight(BinaryTree* tree)
{
  BinaryTree* left = tree->left;
  tree->left = tree->right;
  tree->right = left;
}
