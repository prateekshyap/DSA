/*
https://practice.geeksforgeeks.org/problems/count-pairs-with-given-sum5022/1#
Count pairs with given sum 
*/
// { Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution{   
public:
    int getPairsCount(int arr[], int n, int k) {
        unordered_map<int,int> um;
        int cnt_pairs=0;
        
        for(int i=0;i<n; i++)
        {
            int diff = k-arr[i];
            if(um.find(diff) != um.end())
            {
                cnt_pairs+=um[diff];
            }
            
            um[arr[i]]++;
        }
        // for(auto x: um)
        //     cout<<"["<<x.first<<"|"<<x.second<<"], ";
            
        return cnt_pairs;
    }
    

};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        int arr[n];
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.getPairsCount(arr, n, k);
        cout << ans << "\n";
    }
    
    return 0;
}  // } Driver Code Ends