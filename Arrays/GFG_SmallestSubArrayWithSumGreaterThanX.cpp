/*
Smallest subarray with sum greater than x 
https://practice.geeksforgeeks.org/problems/smallest-subarray-with-sum-greater-than-x5651/1#
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
  public:

    int smallestSubWithSum(int arr[], int n, int x)
    {
        int i=0, j=0;
        int cursum =0 ;
        int len=INT_MAX;
        while(j<n)
        {
            cursum += arr[j];
            while(cursum>x)
            {
                len = min(len, j-i+1);
                cursum -= arr[i];
                i++;
            }
            j++;
        }
        return len;
    }
};

// { Driver Code Starts.

int main() {
	// your code goes here
	int t;
	cin>>t;
	while(t--)
	{
		int n,x;
		cin>>n>>x;
		int a[n];
		for(int i=0;i<n;i++)
		cin>>a[i];
		Solution obj;
		cout<<obj.smallestSubWithSum(a,n,x)<<endl;
	}
	return 0;
}  // } Driver Code Ends