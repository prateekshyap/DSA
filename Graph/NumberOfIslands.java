/*https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1*/

//using DFS
class Solution {
    char[][] grid;
    int r, c;
    public int numIslands(char[][] grid) {
        int count = 0;
        this.grid = grid;
        this.r = grid.length;
        this.c = grid[0].length;

        //check for each cell
        for (int i = 0; i < r; ++i)
            for (int j = 0; j < c; ++j)
                if (this.grid[i][j] == '1') //if we are still left with unvisited cells
                {
                    runDFS(i, j); //run DFS on it
                    ++count; //increment the count
                }
        return count;
    }
    public void runDFS(int row, int col)
    {
    	//if we consider the diagonals
        int rows[] = new int[] { -1, -1, -1, 0, 0, 1, 1, 1 };
        int cols[] = new int[] { -1, 0, 1, -1, 1, -1, 0, 1 };
    
    	//if we don't consider diagonals then remove the comment here
        /*int rows[] = new int[] {-1, 0, 0, 1};
        int cols[] = new int[] {0, -1, 1, 0};*/
        
        // Mark this cell as visited
        grid[row][col] = '0';
 
        // Recur for all connected neighbours
        for (int k = 0; k < 8; ++k) //replace 8 with 4 for the other case
            if ((row + rows[k] >= 0) && (row + rows[k] < r) && (col + cols[k] >= 0) && (col + cols[k] < c) && (grid[row + rows[k]][col + cols[k]] == '1'))
                runDFS(row + rows[k], col + cols[k]);
    }
}