/*
https://practice.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1#
Brackets in Matrix Chain Multiplication 
*/

// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
// User function Template for C++

class Solution{
public:

    vector<vector<int>> memo;
    vector<vector<int>> paren;
    string ans;
    
    string matrixChainOrder(int p[], int n)
    {
        int numMat = n-1;
        memo.resize(numMat+2, vector<int>(numMat+2, -1));
        paren.resize(numMat+2, vector<int>(numMat+2, 0));
        
        solve(0, numMat-1, p);
        print_optimal_parens(0, numMat-1);
        
        return ans;
    }
    
    void print_optimal_parens(int i, int j)
    {
        if(i==j)
            ans.push_back((char)i+'A');
        else
        {
            ans.push_back('(');
            print_optimal_parens(i, paren[i][j]);
            print_optimal_parens(paren[i][j]+1, j);
            ans.push_back(')');
        }
    }
    
    int solve(int i, int j, int *d)
    {
        if(i==j)
            return memo[i][j]=0;
        
        if(memo[i][j] != -1)
            return memo[i][j];
            
        int val = INT_MAX;
        for(int k=i; k<j; k++)
        {
            int curval = solve(i, k, d) + solve(k+1, j, d) + d[i]*d[k+1]*d[j+1];
            if(curval < val)
            {
                val = curval;
                paren[i][j] = k;
            }
        }
        
        return memo[i][j]=val;
    }//int
    
};

// { Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int p[n];
        for(int i = 0;i < n;i++)
            cin>>p[i];
        
        Solution ob;
        cout<<ob.matrixChainOrder(p, n)<<"\n";
    }
    return 0;
}  // } Driver Code Ends