/*
Max distance between same elements 
https://practice.geeksforgeeks.org/problems/max-distance-between-same-elements/1#
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution{
    public:
    // your task is to complete this function
    
    int maxDistance(int a[], int n)
    {
      if(n==0) return 0;
      
      unordered_map<int,int> um; // a[i], i lower bound
      int max=0;
      
      um[a[0]]=0;
      
      for(int i=1; i<n; i++)
      {
         int d = 0;
         if(um.find(a[i]) != um.end())
             d = i - um[a[i]];
         else
            um[a[i]] = i;
            
         if(max < d)
            max = d;
      }
      return max;
    }// maxDistance
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
        int arr[n];
        for(int i=0; i<n; i++)
            cin>>arr[i];
        Solution ob;
        cout<<ob.maxDistance(arr,n)<<endl;
    }
    return 0;
}  // } Driver Code Ends