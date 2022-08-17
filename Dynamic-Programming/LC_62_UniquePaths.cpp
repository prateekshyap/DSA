/*
https://leetcode.com/problems/unique-paths/
62. Unique Paths

*/

class Solution {
public:
    int uniquePaths(int m, int n) {
//         vector<vector<int>> tab(m, vector<int>(n, 1));
        
//         for(int r=1; r<m; r++)
//         {
//             for(int c=1; c<n; c++)
//             {
//                 tab[r][c] = tab[r-1][c] + tab[r][c-1];
//             }
//         }
        
//         return tab[m-1][n-1];
        
        vector<vector<int>> tab(2, vector<int>(n, 1));
        
        int ind = 0;
        for(int r=1; r<m; r++)
        {
            ind = 1-ind;
            for(int c=1; c<n; c++)
            {
                tab[ind][c] = tab[1-ind][c] + tab[ind][c-1];
            }
        }
        
        return tab[ind][n-1];
    }
};