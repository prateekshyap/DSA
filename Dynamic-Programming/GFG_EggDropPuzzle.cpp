/*
https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1#
Egg Dropping Puzzle 
*/

//GFG---------------------------------------
// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution
{
    public:
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    vector<vector<int>> memo;
    int eggDrop(int n, int k) 
    {
        memo.resize(n+1, vector<int>(k+1, -1));
        return solve(n, k);
    }
    
    int solve(int e, int f)
    {
        if(f==0 || f==1)
            return memo[e][f]=f;
        
        if(e == 1)
            return memo[e][f]=f;
        
        if(memo[e][f] != -1)
            return memo[e][f];
            
        int mn = INT_MAX;
        for(int x=1; x<=f; x++)
        {
            // int ifbreaks = solve(e-1, x-1);
            // int ifnotbreaks = solve(e, f-x);
            // int ops = 1 + max(ifbreaks, ifnotbreaks);
            int ops = 1 + max(solve(e-1, x-1), solve(e, f-x));
            // cout<<e<<" "<<x<<" "<<ops<<") ";
            if(ops < mn)
                mn = ops;
        }
       
        // cout<<e<<" "<<f<<" "<<mn<<") "; 
        // cout<<endl;
        
        return memo[e][f]=mn;
    }
};

// { Driver Code Starts.
int main()
{
    //taking total testcases
    int t;
    cin>>t;
    while(t--)
    {
        //taking eggs and floors count
        int n, k;
        cin>>n>>k;
        Solution ob;
        //calling function eggDrop()
        cout<<ob.eggDrop(n, k)<<endl;
    }
    return 0;
}
  // } Driver Code Ends