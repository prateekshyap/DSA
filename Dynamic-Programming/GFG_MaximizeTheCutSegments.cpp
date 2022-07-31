/*
https://practice.geeksforgeeks.org/problems/cutted-segments1642/1/#
Maximize The Cut Segments 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;



 // } Driver Code Ends


class Solution
{
    public:
    vector<int> cutparts;
    //Function to find the maximum number of cuts.
    int maximizeTheCuts(int n, int x, int y, int z)
    {
       cutparts.push_back(x);
      cutparts.push_back(y);
       cutparts.push_back(z);
       
       vector<int> memo(n+1, -1);
       solve(n, memo) ;
       return memo[n] == INT_MIN ? 0 : memo[n];
    }
    
    int solve(int len, vector<int>& memo)
    {
        if(len == 0)
            return memo[len]=0;
        
        if(memo[len] != -1)
            return memo[len];
        
        int counts=0;
        
        for(int cut: cutparts)
        {
            if(len>=cut)
            {   
                // cout<<len<<" "<<cut<<"| ";
                counts = max(counts, solve(len-cut, memo)+1);
            }
        }
        if(counts == 0)
            return memo[len] = INT_MIN;
        
        return memo[len] = counts;
    }
    
};

// { Driver Code Starts.
int main() {
    
    //taking testcases
    int t;
    cin >> t;
    while(t--)
    {
        //taking length of line segment
        int n;
        cin >> n;
        
        //taking types of segments
        int x,y,z;
        cin>>x>>y>>z;
        Solution obj;
        //calling function maximizeTheCuts()
        cout<<obj.maximizeTheCuts(n,x,y,z)<<endl;

    }

	return 0;
}  // } Driver Code Ends