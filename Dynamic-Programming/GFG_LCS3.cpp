/*
https://practice.geeksforgeeks.org/problems/lcs-of-three-strings0028/1#
LCS of three Strings
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

int LCSof3 (string A, string B, string C, int n1, int n2, int n3);
int main()
{
    int t; cin >> t;
    while (t--)
    {
        int n1, n2, n3; cin >> n1 >> n2 >> n3;
        string A, B, C; cin >> A >> B >> C;
        cout << LCSof3 (A, B, C, n1, n2, n3) << endl;
    }
}
// Contributed By: Pranay Bansal
// } Driver Code Ends



 int dp[100+1][100+1][100+1] = {-1};
 
 
int LCS3Rec(string &A, string &B, string &C, int i, int j, int k)
{
    if(!i || !j || !k)
        return 0;
    else if(dp[i][j][k] != -1) return dp[i][j][k];
    else if((A[i-1] == B[j-1]) && B[j-1] == C[k-1])
        return dp[i][j][k] = 1 + LCS3Rec(A,B,C,i-1,j-1,k-1);
    else 
        return dp[i][j][k] = max({LCS3Rec(A,B,C,i-1,j,k) , LCS3Rec(A,B,C,i,j-1,k) , LCS3Rec(A,B,C,i,j,k-1)});
}

int LCSof3 (string A, string B, string C, int n1, int n2, int n3)
{
    
    // memset(dp,-1,sizeof(dp));
    // return LCS3Rec(A,B,C, n1, n2, n3);
    int dp[n1+1][n2+1][n3+1] = {0};
    
    for(int i=0; i<=n1; i++)
    {
        for(int j=0; j<=n2; j++)
        {
            for(int k=0; k<=n3; k++)
            {
                if(!i || !j || !k)
                    dp[i][j][k] = 0;
                else if((A[i-1] == B[j-1]) && B[j-1] == C[k-1])
                    dp[i][j][k] = 1 + dp[i-1][j-1][k-1];
                else 
                    dp[i][j][k] = max({dp[i-1][j][k] , dp[i][j-1][k] , dp[i][j][k-1]});
            }
        }
    }//for i
    
    return dp[n1][n2][n3];
}
