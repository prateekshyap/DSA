/*
https://leetcode.com/problems/maximal-square/
221. Maximal Square
https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
*/

class Solution {
public:
    
    int area=0;
    vector<vector<int>> dp;
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        dp.resize(m, vector<int>(n, 0));
        // solve(m-1, n-1, matrix);
        for(int i=0; i<m; i++){
            if(matrix[i][0] == '1')
            {
                dp[i][0] = matrix[i][0]-'0';
                area = 1;
            }
        }
       for(int j=0; j<n; j++){
           if(matrix[0][j] == '1')
            {
                dp[0][j] = matrix[0][j]-'0';
                area = 1;
            }
        }
        for(int i=1; i<m; i++){ 
            for(int j=1; j<n; j++){
                if(matrix[i][j] == '1')
                {
                    dp[i][j] = 1 + min({dp[i-1][j], dp[i-1][j-1], dp[i][j-1]});
                    area = max(area, dp[i][j]);
                }
            }
        }
        
        // for(int i=0; i<m; i++){ for(int j=0; j<n; j++){ cout<<dp[i][j]<<" "; }cout<<"\n";}
        return area*area;
    }
    
    int solve(int r, int c, vector<vector<char>>& mat)
    {
        if(r<0 or c<0) return 0;
        
        int curcell = mat[r][c]-'0';
        if(dp[r][c] != -1) return dp[r][c];
        
        if(r==0 and c==0) {
            if(curcell > area) area = curcell;
            return dp[r][c] = curcell;
        }
        
        int up = solve(r-1, c, mat);
        int dig = solve(r-1, c-1, mat);
        int left = solve(r, c-1, mat);
        int minx = min({up, left, dig});
        
        if(curcell == 0)
            return dp[r][c] = curcell;
        
        curcell = 1 + minx;
        area = max(area, curcell);
        return dp[r][c] = curcell;
    }
};



class Solution{
public:
    int maxSquare(int m, int n, vector<vector<int>> mat){
        int area=0;
        for(int i=0; i<m; i++){ 
            for(int j=0; j<n; j++){
                if(i==0 or j==0)
                   area = max(area, mat[i][j]); 
                else if(mat[i][j] == 1)
                {
                    mat[i][j] = 1 + min({mat[i-1][j], mat[i-1][j-1], mat[i][j-1]});
                    area = max(area, mat[i][j]);
                }
            }
        }
        
        return area;
    }
};
