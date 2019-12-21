#include <vector>
using namespace std;

class BST {
  public:
    int value;
    BST* left;
    BST* right;

    BST(int val);
    BST& insert(int val);
};

//left, root, right
// O(n) time | O(n) space
vector<int> inOrderTraverse(BST* tree, vector<int> array) {

  if(tree->left != NULL)
	{
		array = inOrderTraverse(tree->left, array);
	}
	array.push_back(tree->value);
	if (tree->right != NULL)
	{
		array = inOrderTraverse(tree->right, array);
	}
	return array;
}

//root, left, right
// O(n) time | O(n) space
vector<int> preOrderTraverse(BST* tree, vector<int> array) {
  array.push_back(tree->value);
	if(tree->left != NULL)
	{
		array = preOrderTraverse(tree->left, array);
	}
	if (tree->right != NULL)
	{
		array = preOrderTraverse(tree->right, array);
	}
	return array;
}

//left, right, root
// O(n) time | O(n) space 
vector<int> postOrderTraverse(BST* tree, vector<int> array) {
  if(tree->left != NULL)
	{
		array = postOrderTraverse(tree->left, array);
	}
	if(tree->right != NULL)
	{
		array = postOrderTraverse(tree->right, array);
	}
	array.push_back(tree->value);
	return array;
}
