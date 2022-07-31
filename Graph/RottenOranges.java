/*https://leetcode.com/problems/rotting-oranges/*/
/*https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] DIRS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int step = 0, freshCounter = 0;
		Queue<int[]> queue = new LinkedList<>(); 
        for (int i = 0; i < grid.length; ++i)
        {
            for (int j = 0; j < grid[0].length; ++j)
            {
                if (grid[i][j] == 2) //if the current orange is rotten
                    queue.add(new int[] {i, j}); //add it to queue
                if (grid[i][j] == 1) //if it is fresh
                    ++freshCounter; //increase the count
            }
        }
        
        if (freshCounter == 0) //if nothing is fresh, return 0
            return  0;
        
        
        while(!queue.isEmpty()) //till the queue is exhausted
        {
            int size = queue.size(); //get the size
            
            for (int i = 0; i < size; ++i) //for each adjacent orange
            {
                int[] cur = queue.poll(); //get the oranges
                for (int[] dir : DIRS) //for each direction
                {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == 1) //if the orange is present and fresh as well
                    {
                        grid[x][y] = 2; //rot it
                        queue.add(new int[]{x,y}); //add it to queue
                        --freshCounter; //decrease the count
                    }
                }
            }
            
            ++step; //increase step
            
            if(freshCounter == 0) //if nothing is fresh
                return step; //return
            
        }
        return -1;
    }
}

class Solution
{
    int max, m, n;
    boolean[][] visited;
    int[][] rotTime;
    int[][] pos = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        max = -1;
        m = grid.length; n = grid[0].length;
        rotTime = new int[m][n];
        int i, j;
        for (i = 0; i < m; ++i) for (j = 0; j < n; ++j) rotTime[i][j] = Integer.MAX_VALUE;
        visited = new boolean[m][n];
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                if (grid[i][j] == 2)
                    dfs(grid,i,j,0);
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                if (grid[i][j] == 1 && rotTime[i][j] > max) max = rotTime[i][j];
        return max == Integer.MAX_VALUE ? -1 : max;
    }
    public void dfs(int[][] grid, int row, int col, int timer)
    {
        visited[row][col] = true;
        if (timer < rotTime[row][col]) rotTime[row][col] = timer;
        
        int r, c;
        
        for (int i = 0; i < 4; ++i)
        {
            r = row+pos[i][0];
            c = col+pos[i][1];
            if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c] && grid[r][c] == 1)
                dfs(grid,r,c,timer+1);
        }
        visited[row][col] = false;
    }
}