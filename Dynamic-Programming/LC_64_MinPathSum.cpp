/*
https://leetcode.com/problems/minimum-path-sum/3
64. Minimum Path Sum

*/

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) 
    {
        
        int m = grid.size();
        int n = grid[0].size();
        
        // vector<vector<int>> tab(grid);
        
        for(int c=1; c<n; c++) // first row
            grid[0][c] += grid[0][c-1]; 
        
        for(int r=1; r<m; r++) // first col
            grid[r][0] += grid[r-1][0]; 
        
        for(int r=1; r<m; r++) 
        {
             for(int c=1; c<n; c++)
             {
                 grid[r][c] += min(grid[r-1][c],grid[r][c-1]); 
             }
        }
            
        return grid[m-1][n-1];
        
    }// end
};