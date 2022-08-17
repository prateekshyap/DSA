/*
https://practice.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1#
Matrix Chain Multiplication 
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
    int matrixMultiplication(int N, int arr[])
    {
        int numMat = N-1;
        memo.resize(numMat+2, vector<int>(numMat+2, -1));
        paren.resize(numMat+2, vector<int>(numMat+2, 0));
        /*
        // N is dimension of dimensions matrix
        // N-1 (numMat) is the number of matrices
        // N-2 is the index of last matrix
        solve(0, numMat-1, arr);
        */
        
        for(int i=0; i<numMat; i++)
            memo[i][i] = 0;
        
        for(int len = 2; len<=numMat; len++) // moving diagonally
        {
            for(int i=0; i<numMat-len +1 ; i++) // first matrix index
            {
                int j = i + len - 1; // last matrix index
                
                int val=INT_MAX;
                for(int k=i; k<j; k++)
                {
                    int curval = memo[i][k] + memo[k+1][j] + arr[i]*arr[k+1]*arr[j+1];
                    if(curval < val)
                    {
                        val = curval;
                        paren[i][j] = k;
                    }
                }
                memo[i][j] = val;
            }
        }
        
        
        // for(int i=0; i<numMat; i++)
        // {
        //     for(int j=0; j< numMat; j++)
        //     {
        //         cout<<memo[i][j]<<", "<<paren[i][j]<<"| ";
        //     }
        //     cout<<endl;
        // }
        // print_optimal_parens(0, numMat-1);
        // cout<<endl;
        
        return memo[0][numMat-1];
    }
    
    void print_optimal_parens(int i, int j)
    {
        if(i==j)
            cout<<"A"<<i;
        else
        {
            cout<<"(";
            print_optimal_parens(i, paren[i][j]);
            cout<<".";
            print_optimal_parens(paren[i][j]+1, j);
            cout<<")";
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
        int N;
        cin>>N;
        int arr[N];
        for(int i = 0;i < N;i++)
            cin>>arr[i];
        
        Solution ob;
        cout<<ob.matrixMultiplication(N, arr)<<endl;
    }
    return 0;
}  // } Driver Code Ends