/*
https://practice.geeksforgeeks.org/problems/pair-with-largest-sum-which-is-less-than-k-in-the-array/1/#
Pair with largest sum which is less than K in the array 
*/

// { Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// User function Template for C++

// arr[]: Input array
// n: Number of elements in the array
// k: Find a pair with sum less than k
pair<int, int> Max_Sum(int arr[], int n, int k) {
    sort(arr, arr+n);

    int i=0;
    int j=n-1;
    int maxsum=0;
    int start=0, end=0;
    
    while(i<j)
    {
        int cursum = arr[i]+arr[j];
        if(cursum < k)
        {
            if(maxsum < cursum)
            {
                maxsum = cursum;
                start = i;
                end = j;
            }
            
            i++;
        }
        else
            j--;
    }

    if(start == 0 && end == 0)
        return {0,0};
        
    return {arr[start], arr[end]};
}


// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        int arr[n + 5];
        for (int i = 0; i < n; i++) cin >> arr[i];
        pair<int, int> p = Max_Sum(arr, n, k);
        cout << p.first << " " << p.second << endl;
    }

    return 0;
}
  // } Driver Code Ends