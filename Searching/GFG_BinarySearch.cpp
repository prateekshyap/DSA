/*
https://practice.geeksforgeeks.org/problems/binary-search/1#
*/
// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++

class Solution{
public:
//iterative
    int binarysearch(int arr[], int n, int k){
        
        // return bs_rec( arr, k, 0, n-1);
        
        int low=0;
        int high=n-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(arr[mid]==k)
                return mid;
            else if(arr[mid]>k)
                high=mid-1;
            else
                low=mid+1;
        }
        return -1;
    }//end
    
    int bs_rec(int arr[], int k, int low, int high)
    {
        
        if(low<=high){
        int mid = low + (high-low)/2; 
        if(arr[mid]==k)
            return mid;
        else if(arr[mid]>k)
            return bs_rec( arr, k, low, mid-1);
        else
            return bs_rec( arr, k, mid+1, high);
        }
        return -1;
        
    }//end
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;

    while(t--)
    {
        int N;
        cin>>N;
        int arr[N];
        for(int i=0;i<N;i++)
            cin>>arr[i];
        int key;
        cin>>key;
        Solution ob;
        int found = ob.binarysearch(arr,N,key);
        cout<<found<<endl;
    }
}

  // } Driver Code Ends