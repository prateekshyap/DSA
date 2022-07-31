/*
https://practice.geeksforgeeks.org/problems/large-factorial4721/1/
Large Factorial 
*/


// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function template for C++


class Solution{
public:
const int mod = 1e9+7;
    vector<long long> factorial(vector<long long> a, int n) {
        long long maxele = *max_element(a.begin(), a.end());
        
        vector<long long> fac(maxele+1, -1);
        fac[0] = 1;
        fac[1] = 1;
        
        for(int i=2; i<=maxele; i++)
            fac[i] = (fac[i-1]*i)%mod;
        
        vector<long long> ans;
        
        for(int i=0; i<n; i++)
            ans.push_back(fac[a[i]]);
        
        
        return ans;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, i;
        cin >> n;
        vector<long long> a(n);
        for (i = 0; i < n; i++) {
            cin >> a[i];
        }
        Solution ob;
        vector<long long> res = ob.factorial(a, n);
        for (i = 0; i < n; i++) {
            cout << res[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
  // } Driver Code Ends