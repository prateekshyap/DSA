/*
2373. Largest Local Values in a Matrix
https://leetcode.com/problems/largest-local-values-in-a-matrix/
*/

class Solution {
public:
    vector<vector<int>> largestLocal(vector<vector<int>>& grid) {
        int n = grid.size(); 
        vector<vector<int>> ans(n-2, vector<int>(n-2)); 
        int mx=0; 
        
        for(int i=0; i<n-2; i++)
        {
            for(int j=0; j<n-2; j++)
            {
                mx = 0;
                for(int r=i; r<i+3; r++)
                {
                    // cout<<grid[r][j]<<" "<<grid[r][j+1]<<" "<<grid[r][j+2]<<") "<<endl;
                    mx = max({mx, grid[r][j], grid[r][j+1], grid[r][j+2]});
                }
                // cout<<i<<" --"<<j<<" --"<<mx<<") ";
                ans[i][j] = mx;
            }
        }
        return ans;
    }
};