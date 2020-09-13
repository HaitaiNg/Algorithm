/*  Given an image represented by an NxN matrix, where each
pixel is 4 bytes, write a method to rotate the image by 90 degrees

Algorithm:
perform a circular rotation on each layer, moving the top edge
to the right edge, the right edge to the bottom edge,
the bottom edge to the left edge, and the left edge to the top
(clockwise rotation)

*/

//Algorithm is O(n^2) which is the best we can do since
//any algorithm must touch all N^2 elements 
boolean rotate(int[][] matrix)
{
  if(matrix.length == 0 || matrix.length != matrix[0].length) return false;
  int n = matrix.length;
  for(int layer = 0; layer < n/2; layer++)
  {
    int first = layer;
    int last = n - 1 - layer;
    for(int i = first; i < last; i++)
    {
      int offse = i - first;
      int top = matrix[first][i]; // save top
      // left -> top
      matrix[first][i] = matrix[last - offset][first];
      // bottom -> left
      matrix[last - offset][first] = matrix[last][last - offset];
      // right -> bottom
      matrix[last][last - offset] = matrix[i][last];
      // top -> right
      matrix[i][last] = top; // right <- saved top
    }
  }
}
