/*https://leetcode.com/problems/as-far-from-land-as-possible/*/

//BFS
class Data implements Comparable<Data>
{
    int r, c;
    Data(int r, int c)
    {
        this.r = r;
        this.c = c;
    }
    
    @Override
    public int compareTo(Data d)
    {
        return 0;
    }
}

class Solution {
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length, i, j;
        Queue<Data> queue = new LinkedList<Data>();
        
        int len, r, c, row, col;
        Data d;
        int[][] result = new int[m][n];
        for (i = 0; i < m; ++i) for (j = 0; j < n; ++j) result[i][j] = Integer.MAX_VALUE;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        for (i = 0; i < m; ++i)
        {
            for (j = 0; j < n; ++j)
            {
                if (grid[i][j] == 1) //if land
                {
                    queue.add(new Data(i,j)); //add to queue
                    result[i][j] = 1; //mark as land in result
                }
            }
        }
        while (!queue.isEmpty()) //till queue becomes empty
        {
            len = queue.size(); //store queue length
            for (i = 0; i < len; ++i) //for each element for the length
            {
                d = queue.poll(); //poll a data from queue
                row = d.r; col = d.c; //store row and column
                if (visited[row][col]) continue; //if visited, continue
                visited[row][col] = true; //mark as visited
                for (j = 0; j < 4; ++j) //for each position adjacent to the current cell
                {
                    r = row+pos[j][0];
                    c = col+pos[j][1];
                    if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0) //if it is water
                    {
                        result[r][c] = Math.min(result[r][c],result[row][col]+1); //store the minimum distance
                        queue.add(new Data(r,c)); //add to queue
                    }
                }
            }
        }
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                if (result[i][j] > max) max = result[i][j]; //get maximum from each cell
        return max == Integer.MAX_VALUE ? -1 : (max == 1 ? -1 : max-1);
    }
}

//efficient
class Solution {
    public int maxDistance(int[][] grid) {
        int i, j, n = grid.length, m = grid[0].length, res = 0;

        //top down
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < m; ++j)
            {
                if (grid[i][j] == 1) continue;
                grid[i][j] = 201; //201 here cuz as the despription, the size won't exceed 100.
                if (i > 0) grid[i][j] = Math.min(grid[i][j], grid[i-1][j]+1);
                if (j > 0) grid[i][j] = Math.min(grid[i][j], grid[i][j-1]+1);
            }
        }
        
        //bottom up
        for (i = n-1; i > -1; --i)
        {
            for (j = m-1; j > -1; --j)
            {
                if (grid[i][j] == 1) continue;
                if (i < n-1) grid[i][j] = Math.min(grid[i][j], grid[i+1][j]+1);
                if (j < m-1) grid[i][j] = Math.min(grid[i][j], grid[i][j+1]+1);
                res = Math.max(res, grid[i][j]); //update the maximum
            }
        }
        
        return res == 201 ? -1 : res-1;
    }
}