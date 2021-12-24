/*https://leetcode.com/problems/count-servers-that-communicate/*/

class Solution {
    public int countServers(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int row[] = new int[r];
        int col[] = new int[c];
        int count = 0;
        
        for (int i = 0; i < r; ++i)
        {
            int sum = 0;
            for (int j = 0; j < c; ++j)
            {
                count += grid[i][j];
                sum += grid[i][j];
            }
            row[i] = sum;
        }
        
        for (int i = 0; i < c; ++i)
        {
            int sum = 0;
            for (int j = 0; j < r; ++j)
            {
                sum += grid[j][i];
            }
            col[i] = sum;
        }
        
        int ans = 0;
        for (int i = 0; i < r; ++i)
        {
            for (int j = 0; j < c; ++j)
            {
                if (row[i] == 1 && col[j] == 1 && grid[i][j] == 1)
                {
                    ans++;
                }
            }
        }
        return count - ans;
    }
}