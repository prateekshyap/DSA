/*
https://practice.geeksforgeeks.org/problems/subarray-with-0-sum-1587115621/1#
Subarray with 0 Sum
*/
// { Driver Code Starts
// A C++ program to find if there is a zero sum
// subarray
#include <bits/stdc++.h>
using namespace std;



 // } Driver Code Ends
class Solution{
    public:
    //Complete this function
    //Function to check whether there is a subarray present with 0-sum or not.
    bool subArrayExists(int arr[], int n)
    {
       unordered_map<int,int> um;
       int sum = 0;
       um[0]=-1; // if sum ==0
       
       for(int i=0; i<n; i++)
       {
           sum += arr[i]; // sum till current ith element
           
           if(arr[i]==0 || um.find(sum)!=um.end()) return true;
           
           um[sum]++;
           
       }
       return false;
    }//end
};

// { Driver Code Starts.
// Driver code
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	    int n;
	    cin>>n;
	    int arr[n];
	    for(int i=0;i<n;i++)
	    cin>>arr[i];
	    Solution obj;
	    	if (obj.subArrayExists(arr, n))
		cout << "Yes\n";
	else
		cout << "No\n";
	}
	return 0;
}  // } Driver Code Ends