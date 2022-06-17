/*
https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1/#
Count the number of possible triangles 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution
{
    public:
    //Function to count the number of possible triangles.
    int findNumberOfTriangles(int arr[], int n)
    {
       int ans=0;
       
       sort(arr, arr+n);
       
       int l, r;
    //   for(int i=n-1; i>=2; i--)
    //   {
    //       l=0;
    //       r=i-1;
    //       while(l<r)
    //       {
    //           if(arr[l] + arr[r] > arr[i])
    //           {
    //               ans+=r-l;
    //               r--;
    //           }
    //           else
    //                 l++;
    //       }
    //   }
       
       for(int i=0; i<n-2; i++)
       {
           for(int j=i+1; j<n-1; j++)
           {
               int th = j+1;
               while(th<n && arr[i]+arr[j] > arr[th]) ++th;
               ans += th-1-j;
           }
       }
       
       return ans;
    }
};


// { Driver Code Starts.

int main()
{
    int T;
    cin>>T;
    while(T--)
    {
        int n;
        cin>>n;
        int arr[n];
        for(int i=0; i<n; i++)
            cin>>arr[i];
        Solution ob;
        cout<<ob.findNumberOfTriangles(arr,n) <<endl;
    }
    return 0;
}  // } Driver Code Ends