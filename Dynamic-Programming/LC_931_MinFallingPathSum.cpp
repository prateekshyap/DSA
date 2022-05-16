/*
https://leetcode.com/problems/minimum-falling-path-sum/
931. Minimum Falling Path Sum

*/

class Solution {
public:
    int rows, cols;
    vector<vector<int>> dp;
    int minFallingPathSum(vector<vector<int>>& matrix) {
        
         rows = matrix.size();
         cols = matrix[0].size();
        
        int minPath = INT_MAX;
        // dp.resize(rows+1, vector<int>(cols+1, -1));
        // for(int c=0; c<cols; c++)
        // {
        //     // minPath = min(minPath, TopToBottom(0, c, matrix));
        //     minPath = min(minPath, BottomToTop(rows-1, c, matrix));
        // }
        
        
        // With Extra Space
         dp.resize(rows, vector<int>(cols, -1));
         // From first row to last
         for(int c=0; c<cols; c++)
          {
            dp[0][c]=matrix[0][c];
          }

         for(int r=1; r<rows; r++)
          {
              for(int c=0; c<cols; c++)
              {
                  int leftUpDig = ((c==0) ? INT_MAX : dp[r-1][c-1]);
                  int up = dp[r-1][c];
                  int rightUpDig = ((c==cols-1) ? INT_MAX: dp[r-1][c+1]);
                  dp[r][c] = matrix[r][c]+min({leftUpDig, up, rightUpDig});
                  // if(r==rows-1) // last row
                  //   minPath = min(minPath, dp[r][c]);
              }
          }
        
        for(int c=0; c<cols; c++)
          {
             if(dp[rows-1][c] < minPath)
                 minPath = dp[rows-1][c];
          }
        // for(int r=0; r<rows; r++)
        // {for(int c=0; c<cols; c++)
        // {
        //     cout<<dp[r][c]<<" ";
        // }
        //  cout<<"\n";
        // }
        return minPath;
        
    }// end
    
    int BottomToTop(int r, int c, vector<vector<int>>& M)
    {
        if(c<0 || c>=cols)
            return INT_MAX;
        
        if(r == 0)
            return dp[r][c]=M[r][c];
        
        if(dp[r][c] != -1)
            return dp[r][c];
            
        
        int leftUpDig = BottomToTop(r-1, c-1, M);
        int up = BottomToTop(r-1, c, M);
        int rightUpDig = BottomToTop(r-1, c+1, M);
        
        return dp[r][c] = M[r][c]+ min({leftUpDig, up, rightUpDig});
        // return dp[r][c];
    }
    
    int TopToBottom(int r, int c, vector<vector<int>>& M)
    {
        if(c<0 || c>=cols)
            return INT_MAX;
        
        if(r == rows-1)
            return M[r][c];
        
        if(dp[r][c] != -1)
            return dp[r][c];
            
        
        int leftDig = TopToBottom(r+1, c-1, M);
        int down = TopToBottom(r+1, c, M);
        int rightDig = TopToBottom(r+1, c+1, M);
        
        dp[r][c] = M[r][c]+ min({leftDig, down, rightDig});
        return dp[r][c];
    }
};