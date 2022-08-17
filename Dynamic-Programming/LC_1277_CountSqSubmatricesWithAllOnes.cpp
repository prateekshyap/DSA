/*
https://leetcode.com/problems/count-square-submatrices-with-all-ones/
1277. Count Square Submatrices with All Ones

*/

class Solution {
public:
    int cnt=0;
    vector<vector<int>> dp;
    int countSquares(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        
        // dp.resize(m, vector<int>(n, -1));
        // solve(m-1, n-1, mat);
        
        for(int i=0; i<m; i++)
            cnt+=mat[i][0];
        for(int j=1; j<n; j++)
            cnt+=mat[0][j];
        
        for(int i=1; i<m; i++)
        {
            for(int j=1; j<n; j++)
            {
                if(mat[i][j] == 1)
                {
                    int minx = min({mat[i-1][j], mat[i][j-1], mat[i-1][j-1]});
                    mat[i][j] = 1 + minx;
                    cnt+=mat[i][j];
                }
            }
        }
        // for(int i=0; i<m; i++){for(int j=0; j<n; j++){cout<<mat[i][j]<<" ";}cout<<endl;}
        return cnt;
    }
    
    int solve(int r, int c, vector<vector<int>> & mat)
    {
        if(r<0 or c<0)
            return 0;
        if(dp[r][c] != -1)
            return dp[r][c];
        int up = solve(r-1, c, mat);
        int left = solve(r, c-1, mat);
        int dig = solve(r-1, c-1, mat);
        int minx = min({up, left, dig});
        
        if(mat[r][c] == 0)
            return dp[r][c]=0;
        mat[r][c] = 1 + minx;
        cnt += mat[r][c];
        return dp[r][c]=mat[r][c];
    }
};