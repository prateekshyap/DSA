/*
https://practice.geeksforgeeks.org/problems/nth-natural-number/1#
Nth Natural Number 
*/
// { Driver Code Starts
//Initial Template for C++

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++


class Solution{
	public:
	// Convert to BASE 9
	long long findNth(long long N)
    {
        if(N<9) return N;
        long long ans;
        long long rem;
        int power=0;
        long long mult=1;
        
        while(N>0)
        {
            // rem = N%9;
            // ans += rem*pow(10, power++);
            
            // ans += (N%9)*pow(10, power++);
            ans += (N%9)*mult;
            mult *=10;
            
            N = N/9; // quotient
        }
        
        return ans;
    }
};

// { Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		long long n , ans;
		cin>>n;
		Solution obj;
		ans = obj.findNth(n);
		cout<<ans<<endl;
	}
}

  // } Driver Code Ends