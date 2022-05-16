/*
https://practice.geeksforgeeks.org/problems/number-of-paths0926/1#
Number of paths
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
 

 // } Driver Code Ends

int rows, cols;
long long pathsCnt=0;

void countPaths(int r, int c)
{
    if(r==rows-1 && c==cols-1)
        pathsCnt++;
    else if(r==rows-1) // downmost
        countPaths(r, c+1);
    else if(c==cols-1) //rightmost
        countPaths(r+1, c);    
    else {
        countPaths(r, c+1); //right
        countPaths(r+1, c); //down
    }
}
long long  numberOfPaths(int m, int n)
{
    //2-D DP
    // long long dp[m][n];
    // for(int c=0; c<n; c++)
    //     dp[0][c]=1;
    // for(int r=0; r<m; r++)
    //     dp[r][0]=1;
    // for(int i=1; i<m; i++)
    //  {
    //      for(int j=1; j<n; j++)
    //         dp[i][j] = dp[i][j-1] + dp[i-1][j];
    //  }
     
    //  return dp[m-1][n-1];
    
    
    //1-D DP
    // long long dp[n];
    // for(int r=0; r<n; r++)
    //     dp[r]=1;
    
    // for(int r=1; r<m; r++)
    //  {
    //      for(int c=1; c<n; c++)
    //         dp[c] = dp[c] + dp[c-1];
    //  }
     
    //  return dp[n-1];
     
     //Backtracking
     
     rows = m;
     cols = n;
     pathsCnt=0;
     countPaths(0,0);
     return pathsCnt;
}

// { Driver Code Starts.

 
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n,m;
		cin>>m>>n;
	    cout << numberOfPaths(m, n)<<endl;
	}
    return 0;
}  // } Driver Code Ends