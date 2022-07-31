/*
https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1/#
Gold Mine Problem 
*/

// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:
    int maxGold(int n, int m, vector<vector<int>> M)
    {
        int gold = 0;
        
        for(int c=1; c<m; c++)
        {
            int maxincol = 0;
            for(int r=0; r<n; r++)
            {
                  int left = M[r][c-1];
                  int digdown = r+1>=n ? 0 : M[r+1][c-1];
                  int digup = r-1 <0 ? 0 : M[r-1][c-1];
                  M[r][c] = M[r][c] + max({maxincol, left, digdown, digup});
            }//
        }//
        
        for(int r=0; r<n; r++)
            gold = max(gold, M[r][m-1]);
        
        return gold;
    }//
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n, m;
        cin>>n>>m;
        vector<vector<int>> M(n, vector<int>(m, 0));
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++)
                cin>>M[i][j];
        }
        
        Solution ob;
        cout<<ob.maxGold(n, m, M)<<"\n";
    }
    return 0;
}  // } Driver Code Ends