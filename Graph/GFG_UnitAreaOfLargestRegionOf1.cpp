/*
https://practice.geeksforgeeks.org/problems/length-of-largest-region-of-1s-1587115620/1
Unit Area Of Largest Region of 1s
*/

class Solution
{
     int m, n;
    public:
    //Function to find unit area of the largest region of 1s.
    int findMaxArea(vector<vector<int>>& grid) {
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
    
    vector<pair<int,int>> dirs = {
      {-1, 1}, {1, 0}, {1, 1},
      {0, -1}, {0, 1},
      {-1, -1}, {-1, 0}, {1, -1}
    };
    
    int dfs(int i, int j, vector<vector<int>> & grid)
    {
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] != 1)
            return 0;
        grid[i][j] = 2;
        int cnt=1;
        for(auto d: dirs)
        {
            cnt+= dfs(i+d.first, j+d.second, grid); 
        }
        return cnt;
    }
};