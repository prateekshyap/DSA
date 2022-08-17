/*
https://leetcode.com/problems/unique-binary-search-trees/
96. Unique Binary Search Trees

https://practice.geeksforgeeks.org/problems/unique-bsts-1587115621/1
*/

class Solution {
public:
    int numTrees(int n) {
        
        // t(n) = sum_{i=1 to n} t(i-1)*t(n-i)
        // memo.resize(n+1, -1);
        // countbst(n);
        // return memo[n];
        
        /*
        vector<int> dp(n+1);
        dp[0]=1; // one bst with zero node, empty bst
        dp[1]=1; // one bst with one node, structurally unqiue;
        
        // for each node in root index, number of bst in left subtree * number of bst in right subtree
        for(int root=2; root<=n; root++)
        {
            for(int left=1; left<=root; left++)
                dp[root] += dp[left-1]*dp[root-left];
        }
        return dp[n];
        */
        
        // return ncr(2*n,n)/(n+1);
        long ans=1;
        for(int i=0; i<n; i++)
            ans*= (4*i+2)/(i+2.);
        return ans;
    }
    
    long ncr(int n, int r)
    {
        long ans=1;
        for(int i=0; i<r; i++)
        {
            ans*=(n-i);
            ans/=(i+1);
        }
        return ans;
    }
    
    vector<int> memo;
    int countbst(int n)
    {
        if(n==0 or n==1)
            return memo[n]=1;
        if(memo[n]!=-1)
            return memo[n];
        
        int cnt=0;
        for(int i=1; i<=n; i++)
            cnt+= countbst(i-1)*countbst(n-i);
        
        return memo[n]=cnt;
    }
};


//GFG -------------------
//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution
{
    const int mod = 1e9+7;
    public:
    //Function to return the total number of possible unique BST. 
    int numTrees(int n) 
    {
       vector<long> dp(n+1);
        dp[0]=1; // one bst with zero node, empty bst
        dp[1]=1; // one bst with one node, structurally unqiue;
        
        // for each node in root index, number of bst in left subtree * number of bst in right subtree
        for(int root=2; root<=n; root++)
        {
            for(int left=1; left<=root; left++)
                dp[root] = (dp[root] + ((dp[left-1]%mod)*(dp[root-left]%mod))%mod)%mod;
        }
        return dp[n]%mod;
    }
};

//{ Driver Code Starts.
#define mod (int)(1e9+7)
int main(){
    
    //taking total testcases
    int t;
    cin>>t;
    while(t--){
        
        //taking total number of elements
        int n;
        cin>>n;
        Solution ob;
        //calling function numTrees()
        cout<<ob.numTrees(n)<<"\n";
    }
}	
// } Driver Code Ends