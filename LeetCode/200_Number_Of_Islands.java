class Solution {
    public int numIslands(char[][] grid) {
        int h = grid.length; 
        if(h == 0)
        {
            return 0; 
        }
        int w = grid[0].length; 
        boolean[][] visited = new boolean[h][w];
        int islandCount = 0; 
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(!visited[i][j] && grid[i][j] == '1')
                {
                    markNeighbors(grid, visited, i, j, h, w); 
                    islandCount++; 
                }
            }
        }
        return islandCount; 
    }
    
    public static void markNeighbors(char[][] grid, boolean[][] visited, int x, int y, int h , int w)
    {
        if(x < 0 || x >= h || y < 0 || y >= w || visited[x][y] || grid[x][y] != '1')
			return;
		visited[x][y] = true;
		markNeighbors(grid, visited, x + 1, y, h, w);
		markNeighbors(grid, visited, x - 1, y, h, w);
		markNeighbors(grid, visited, x, y + 1, h, w);
		markNeighbors(grid, visited, x, y - 1, h, w);
    }
}