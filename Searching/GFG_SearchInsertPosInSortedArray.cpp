/*
https://practice.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1/#
Search insert position of K in a sorted array 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function Template for C++

class Solution{
    public:
    int searchInsertK(vector<int>Arr, int N, int k)
    {
        int low=0;
        int high=N-1;
        
        if(k<Arr[low]) return low;
        if(k>Arr[high]) return N;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(Arr[mid]==k)
                return mid;
            else if(k<Arr[mid])
                high=mid-1;
            else
                low=mid+1;
        }
        return low;
    }
};

// { Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int N;
        cin >> N;
        vector<int>Arr(N);
        for(int i=0;i<N;i++)    
            cin>>Arr[i];
        int k;
        cin>>k;
        Solution obj;
        cout<<obj.searchInsertK(Arr, N, k)<<endl;
    }
    return 0;
}  // } Driver Code Ends