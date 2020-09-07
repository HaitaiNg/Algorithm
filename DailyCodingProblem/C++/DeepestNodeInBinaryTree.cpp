/* Find the deepest node in a binary tree
Solution: Use in-order traversal. */
#include <iostream>
#include <cstddef>
using namespace std;

struct Node
{
  int data;
  struct Node *left, *right;
};

//utility function to create a node
Node *newNode(int data)
{
  Node *temp = new Node();
  temp->data = data;
  temp->left = temp->right = NULL;
  return temp;
}

//maxLevel: keeps track of maximum level so far
//res : value of deepest node so far
//level : level of root

void find(Node *root, int level, int &maxLevel, int &res)
{
  if(root != NULL)
  {
    find(root->left, ++level, maxLevel, res);
    //update level and resue
    if(level > maxLevel)
    {
      res = root->data;
      maxLevel = level;
    }
    find(root->right, level, maxLevel, res);
  }
}

//returns value of deepest node
int deepestNode(Node * root)
{
  //initialize result and max level
  int res = -1;
  int maxLevel = -1;
  //update values "res" and "maxLevel"
  //Note that res and maxLen are pased
  //by reference
  find(root, 0, maxLevel, res);
  return res;
}

int main()
{
  Node* root = newNode(1);
  root->left = newNode(2);
  root->right = newNode(3);
  root->left->left = newNode(4);
  root->right->left = newNode(5);
  root->right->right = newNode(6);
  root->right->left->right = newNode(7);
  root->right->right->right = newNode(8);
  root->right->left->right->left = newNode(9);
  cout << deepestNode(root) << "\n";;
}
