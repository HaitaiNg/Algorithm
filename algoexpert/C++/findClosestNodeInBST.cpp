#include <cmath>
#include <float.h>
using namespace std;




/* Find Node in BST
 * Average : O(log(n)) time | O(log(n)) sppace
 * Worst : O(n) time | O(n) space
 */
class BST {
  public:
    int value;
    BST* left;
    BST* right;

    BST(int val);
    BST& insert(int val);
};
int findClosetValueInBst(BST* tree, int target);
int findClosestValueInBstHelper(BST* tree, int target, double closest);

int findClosestValueInBstHelper(BST* tree, int target, double closest)
{
	if( abs(target - closest) > abs(target - tree->value))
	{
		closest = tree->value;
	}

	if(target < tree->value && tree->left != NULL)
	{
		return findClosestValueInBstHelper(tree->left, target, closest);
	} else if (target > tree->value && tree->right != NULL)
	{
		return findClosestValueInBstHelper(tree->right, target, closest);
	}
	return (int) closest;
}

int findClosestValueInBst(BST* tree, int target) {
	return findClosestValueInBstHelper(tree, target, 100000.00);
}
