
import java.util.*;

class Program
{
  // In Order Traversal ( left root right)
  // Traverse the left sub tree : InOrder(leftsubtree)
  // Traverse the right sub tree : InOrder(right subtree)
  // O(n) time | O(n) space
  public static ArrayList<Integer> inOrderTraverse(BST tree, ArrayList<Integer> array) {
    if(tree == null)
		{
			return array;
		}
		else
		{
			inOrderTraverse(tree.left, array);
			array.add(tree.value);
			inOrderTraverse(tree.right, array);
		}
		return array;
  }

  // Pre Order Traversal(root left right)
  // Vist the root
  // Traverse the left subtree : PreOrder(left-subtree)
  // Traverse the right subtree : PreOrder(right-subtree)
  public static ArrayList<Integer> preOrderTraverse(BST tree, ArrayList<Integer> array) {
    array.add(tree.value);
		if(tree.left != null)
		{ preOrderTraverse(tree.left, array);
		}
		if(tree.right != null)
		{
		preOrderTraverse(tree.right, array);
		}
		return array;
  }

  // Post Order Traversal(left right root)
  // Traverse the left subtree : PostOrder(left-subtree)
  // Traverse the right subtree: PostOrder(right-subtree)
  // Visit the root

  public static ArrayList<Integer> postOrderTraverse(BST tree, ArrayList<Integer> array) {
  if(tree.left != null)
  {
  postOrderTraverse(tree.left, array);
  }
  if(tree.right != null)
  {
  postOrderTraverse(tree.right, array);
  }
  array.add(tree.value);
  return array;
}

static class BST {
  public int value;
  public BST left;
  public BST right;

  public BST(int value) {
    this.value = value;
    }
  }
}
