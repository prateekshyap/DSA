/*
https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1#
Subarrays with equal 1s and 0s 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends

class Solution{
  public:
    //Function to count subarrays with 1s and 0s.
    long long int countSubarrWithEqualZeroAndOne(int arr[], int n)
    {
        //
        unordered_map<int, int> prefix;
        prefix[0] = 1;
        int sum = 0;
        long long int count = 0;
        
        for(int i=0; i<n; i++)
        {
            sum += arr[i]==0? -1 : 1;
            
            if(prefix.find(sum) != prefix.end())
            {
               count += prefix[sum] ;
            }
            
            prefix[sum]++;
        }
        return count;
    }//end
};

// { Driver Code Starts.

int main()
{
	int t;
	cin>>t;
	while(t--)
	{
	int n,i;
	cin>>n;
	int arr[n];
	for(i=0;i<n;i++)
	cin>>arr[i];
	Solution obj;
	cout<< obj.countSubarrWithEqualZeroAndOne(arr, n)<<"\n";
	}
	return 0;
}
  // } Driver Code Ends