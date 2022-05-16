/*
https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1
Zero Sum Subarrays 
*/
// { Driver Code Starts
//Initial function template for C++

#include<bits/stdc++.h>
using namespace std;
#define ll long long

 // } Driver Code Ends
//User function template for C++

class Solution{
    public:
    //Function to count subarrays with sum equal to 0.
    ll findSubarray(vector<ll> arr, int n ) {
        
        ll sum=0;
        ll count = 0;
        
        unordered_map<ll,ll> prefix;
        prefix[sum] = 1;
        
        for(int x: arr)
        {
            sum += x;
            
            if(prefix.find(sum) != prefix.end()) count += prefix[sum];
            
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
        int n;
        cin>>n; //input size of array
       
        vector<ll> arr(n,0);
        
        for(int i=0;i<n;i++)
            cin>>arr[i]; //input array elements
        Solution ob;
        cout << ob.findSubarray(arr,n) << "\n";
    }
	return 0;
}  // } Driver Code Ends