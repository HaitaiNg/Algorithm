class BST {
  public:
    int value;
    BST* left;
    BST* right;

    BST(int val);
    BST& insert(int val);
};
bool BSTVerification(BST* tree, int min, int max);
bool BSTVerification(BST* tree, int min, int max)
{
	if((tree->value < min) || (tree->value >= max))
	{
		return false;
	}
	if((tree->left != NULL) && !(BSTVerification(tree->left, min, tree->value)))
	{
		return false;
	}
	if((tree->right != NULL) && !(BSTVerification(tree->right, tree->value, max)))
	{
		return false;
	}
	return true;
}

// O(n) time | O(d) space
bool validateBst(BST* tree) {
  return BSTVerification(tree, INT_MIN, INT_MAX);
}
