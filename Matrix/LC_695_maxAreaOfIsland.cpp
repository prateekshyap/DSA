/*
https://leetcode.com/problems/max-area-of-island/
695. Max Area of Island

*/

class Solution {
public:
    int m, n;
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        int maxarea=0;
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==1)
                {
                    int newarea = dfs(i, j, grid);
                    if(newarea>maxarea)
                        maxarea = newarea;
                }
            }
        }
        return maxarea;
    }
    
    int dfs(int i, int j, vector<vector<int>> & grid)
    {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        return 1 + dfs(i, j+1, grid) + dfs(i, j-1, grid) + dfs(i+1, j, grid) + dfs(i-1, j, grid);
    }
};