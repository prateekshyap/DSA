/*
https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1/#
Friends Pairing Problem 
*/
// { Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 

 // } Driver Code Ends
class Solution
{
public:
    const int mod = 1e9+7;
    int countFriendsPairings_(int n) 
    { 
        if(n <= 2) return n;
        
        vector<long> sp(n+1, 0), dp(n+1, 0); //single pair, doible pair
        sp[1] = 1;
        sp[2] = 1;
        dp[2] = 1;
        for(int i=3; i<=n; i++)
        {
            sp[i] = (sp[i-1]+dp[i-1])%mod;
            dp[i] = (sp[i-1]*(i-1)) %mod;
            // cout<<sp[i]<<" "<<dp[i]<<endl;
        }
        return (sp[n]+dp[n]) %mod;
    }
    
    int countFriendsPairings(int n) 
    { 
        if(n <= 2) return n;
        
        long prevsp = 1;
        long sp = 1;
        long dp = 1;
        
        for(int i=3; i<=n; i++)
        {
            prevsp = sp;
            sp = (prevsp+dp)%mod;
            dp = (prevsp*(i-1))%mod;
        }
        return (sp+dp)%mod;
    }
};    
 

// { Driver Code Starts.
int main() 
{
    int t;
    cin>>t;
    while(t--)
    {
    	int n;
    	cin>>n;
    	Solution ob;
    	cout <<ob.countFriendsPairings(n); 
    	cout<<endl;
    }
} 
  // } Driver Code Ends