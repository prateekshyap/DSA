/*
https://leetcode.com/problems/edit-distance/
72. Edit Distance

https://practice.geeksforgeeks.org/problems/edit-distance3702/1/

*/

class Solution {
public:
    vector<vector<int>> dp;
    string w1, w2;
    int memo(int i, int j)
    {
        if(i<0)
            return j+1;
        if(j<0)
            return i+1;
        
        if(dp[i][j] !=-1)
            return dp[i][j];
        
        if(w1[i] == w2[j])
            return dp[i][j] = memo(i-1, j-1);
        else
            return dp[i][j] = 1+ min({memo(i-1, j-1), memo(i-1, j), memo(i, j-1)});
    }
    
    int minDistance(string word1, string word2) {
        int m = word1.size();
        int n = word2.size();
        w1 = word1;
        w2 = word2;
        dp.resize(m+1, vector<int>(n+1, -1));
        return memo(m-1,n-1);
        
        // return minDistance_wo_recursion(word1, word2);
    }
    
    int minDistance_wo_recursion(string word1, string word2) {
        //unit cost
        int m = word1.size();
        int n = word2.size();
        vector<vector<int>> dist(m+1, vector<int>(n+1, 0));
        
        for(int c=0; c<=n; c++)
            dist[0][c] = c; // if first word is empty then cost of inserting second word depends on his character length
        
        for(int r=0; r<=m; r++)
            dist[r][0] = r; // if second word is empty then cost of deleting first word depends on his charcter length.
        
        for(int r = 1; r<=m; r++)
        {
            for(int c=1; c<=n; c++)
            {
                if(word1[r-1] == word2[c-1])
                    dist[r][c] = dist[r-1][c-1];
                else
                {   // min among, 
                    // if we are at previous char and substitute/replace
                    // if we are at ith char and jth then insert a new char
                    // if we delete a char 
                    dist[r][c] = min({dist[r-1][c-1], dist[r][c-1], dist[r-1][c]}) + 1;
                }
            }
        }
        
        // for(int r=0; r<=m; r++)
        // {
        //     for(int c=0; c<=n; c++)
        //     {
        //         cout<<dist[r][c]<<" ";
        //     }
        //     cout<<endl;
        // }
            
        
        return dist[m][n];
    }//end
};