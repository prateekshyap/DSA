/*
https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1#
Chocolate Distribution Problem 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    long long findMinDiff(vector<long long> a, long long n, long long m){
    //code
        sort(a.begin(), a.end());
        
        long long i=0;
        long long j=m-1; //m=5 then 0 to 4
        long long diff = a[j]-a[i];
        
        while(m-1+i < n)// m-1+i window m=5 then 0-4 1-5 2-6 3-7 < n 
        {
            diff = min(diff, a[j]-a[i]);
            j++; i++;
        }
        
        return diff;
    }   
};

// { Driver Code Starts.
int main() {
	long long t;
	cin>>t;
	while(t--)
	{
		long long n;
		cin>>n;
		vector<long long> a;
		long long x;
		for(long long i=0;i<n;i++)
		{
			cin>>x;
			a.push_back(x);
		}
		
		long long m;
		cin>>m;
		Solution ob;
		cout<<ob.findMinDiff(a,n,m)<<endl;
	}
	return 0;
}  // } Driver Code Ends