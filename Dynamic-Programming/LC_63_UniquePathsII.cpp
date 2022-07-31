/*
https://leetcode.com/problems/unique-paths-ii/
63. Unique Paths II

*/


class Solution {
public:
    int uniquePathsWithObstacles_1(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        obstacleGrid[0][0] = 1;
        
        for(int r=1; r<m; r++)
        {
            if(obstacleGrid[r][0]==0)
                obstacleGrid[r][0] = obstacleGrid[r-1][0] ;
            else
                obstacleGrid[r][0] = 0;
        }
        for(int c=1; c<n; c++)
        {
            if(obstacleGrid[0][c]==0)
                obstacleGrid[0][c] = obstacleGrid[0][c-1];
            else
                obstacleGrid[0][c] = 0;
        }
           
        
        for(int r=1; r<m; r++)
        {
            for(int c=1; c<n; c++)
            {
                if(obstacleGrid[r][c]==0)
                    obstacleGrid[r][c] = obstacleGrid[r-1][c] + obstacleGrid[r][c-1];
                else
                    obstacleGrid[r][c]=0;
            }
        }
        
        // for(int r=0; r<m; r++)
        // {
        //     for(int c=0; c<n; c++)
        //     {
        //         cout<< obstacleGrid[r][c]<<" ";
        //     }
        //     cout<<endl;
        // }
        
        return obstacleGrid[m-1][n-1];
    }
    
     int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0;
        
        vector<vector<int>> dp(2, vector<int>(n, 0));
        dp[0][0] = 1;
        int ind=0;
        
        for(int c=1; c<n; c++)
        {
            if(obstacleGrid[0][c]==0)
                dp[0][c] = dp[0][c-1] ;
            else
                break;
        }
           
        
        for(int r=1; r<m; r++)
        {
            ind = 1-ind;
            for(int c=0; c<n; c++)
            {
                if(obstacleGrid[r][c]==0)
                    dp[ind][c] = dp[1-ind][c] + ((c==0) ? 0 : dp[ind][c-1]);
                else
                    dp[ind][c] = 0;
            }
        }
        
        // for(int r=0; r<2; r++)
        // {
        //     for(int c=0; c<n; c++)
        //     {
        //         cout<< dp[r][c]<<" ";
        //     }
        //     cout<<endl;
        // }
        
        return dp[ind][n-1];
    }
};