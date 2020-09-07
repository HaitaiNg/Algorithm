/* Given a 2d grid map of 1's (land) and 0s (water), count
the number of islands. An island is surrounded by water and is
formed by connecting adjacent lands horizontally or vertically.

Use Depth First Search, mark the nieghbors as visited once
you visit an unvisited land

Keep a 2d Boolean array called Visisted and everytime you
visit a land which is not visisted, you increment the count of islands
and mark all neighbors visited.

Time complexity is O(n^2) 
*/

public class NumberOfIslands
{
  private int h;
  private int w;


  public int numIslands(char[][] grid)
  {
    h = grid.length;
    if(h==0) return 0;
    w = grid[0].length;
    boolean[][] visited = new boolean[h][w];
    int islandCount = 0;
    for(int i = 0; i < grid.length; i++)
    {
      for(int j = 0; j < grid[0].length; j++)
      {
        if(!visited[i][j] && grid[i][j] == '1')
        {
          markNeighbors(grid, visited, i, j);
          ++islandCount;
        }
      }
    }
    return islandCount;
  }

  private void markNeighbors(char[][] grid, boolean[][] visited, int x, int y)
  {
    if(x<0 || x>=h || y<0 || y>w || visited[x][y] || grid[x][y] != '1')
      return;
      visited[x][y] = true;
      markNeighbors(grid, visited, x+1, y);
      markNeighbors(grid, visited, x-1, y);
      markNeighbors(grid, visited, x, y+1);
      markNeighbors(grid, visited, x, y-1);
  }



  public static void main(String[] args)
  {
    char[][] grid = {{ '1','1','1'}, {'1','0','0'},
  {'1','0','1'}};
  System.out.println("Number of islands " + new NumberOfIslands().numIslands(grid));
  }
}
