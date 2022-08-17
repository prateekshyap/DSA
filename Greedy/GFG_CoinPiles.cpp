/*
https://practice.geeksforgeeks.org/problems/coin-piles5152/1/#
Coin Piles 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int minSteps(int a[], int n, int k) {
        sort(a, a+n);
        
        int ps[n]={0}; //prefix sum
        ps[0] = a[0];
        for(int i=1; i<n; i++)
            ps[i] = ps[i-1] + a[i];
        
        int ans = INT_MAX;
        int prev =0;
        
        for(int i=0; i<n; i++)
        {
            int c=1;
            while(i+1<n && a[i] == a[i+1])
            {
                c++;
                i++;
            }
            
            int permissible = a[i]+k;
            int idx = upper_bound(a, a+n, permissible) - a;
            int actualUbSum = ps[n-1] - ps[idx-1];
            int modifiedUbSum = (n-idx)*(permissible);
            
            int reduce = actualUbSum - modifiedUbSum; 
            ans = min(ans, reduce+prev);
            prev += a[i]*c;
        }
        return ans;
    }
};


// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, K;
        cin>>N>>K;
        
        int A[N];
        for(int i=0; i<N; i++)
            cin>>A[i];

        Solution ob;
        cout << ob.minSteps(A,N,K) << endl;
    }
    return 0;
}  // } Driver Code Ends