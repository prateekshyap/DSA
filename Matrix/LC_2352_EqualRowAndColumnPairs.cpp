/*
https://leetcode.com/problems/equal-row-and-column-pairs/
2352. Equal Row and Column Pairs

*/

class Solution {
public:
    
    int equalPairs(vector<vector<int>>& grid) {
        // return equalPairsBRUTEFORCE(grid);
        int n = grid.size();
        map<vector<int>, int> s;
        int pairs=0;
        
        /*
        vector<vector<int>> gridtrans(n, vector<int>(n));
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
                gridtrans[i][j] = grid[j][i];
        }
        for(auto x: grid)
            s[x]++;
        
        for(auto x: gridtrans){
            if(s.find(x) != s.end())
                pairs += s.count(x);
        }
        */
        
        for(int col=0; col<n; col++)
        {
            vector<int> v;
            for(int row=0; row<n; row++)
                v.push_back(grid[row][col]);
            s[v]++;
        }
        for(auto &x: grid)
        {
            pairs += s[x];
        }
        
        return pairs;
    }
    
    int equalPairsBRUTEFORCE(vector<vector<int>>& grid) {
        int n = grid.size();
        int pairs=0;
        
        for(int row=0; row<n; row++)
        {
            for(int col=0, k=0; col<n; col++)
            {
                for(k=0; k<n; k++)
                {
                    if(grid[row][k] != grid[k][col])
                        break;
                }
                pairs += (k==n);
            }
        }
        return pairs;
    }
};