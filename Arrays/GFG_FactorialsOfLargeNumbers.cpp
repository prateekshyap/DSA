/*
https://practice.geeksforgeeks.org/problems/factorials-of-large-numbers2508/1#
Factorials of large numbers 
*/
// { Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution {
public:
    vector<int> factorial(int N){
        vector<int> ans;
        
        ans.push_back(1);
        
        int val=0, carry=0;
        for(int x=2; x<=N; x++)
        {
            carry = 0;
            for(int i=0; i<ans.size(); i++)
            {
                val = ans[i]*x + carry;
                carry = val/10;
                ans[i] = val%10;
            }
            while(carry)
            {
                ans.push_back(carry%10);
                carry /= 10;
            }
        }
        
        reverse(ans.begin(), ans.end());
        
        return ans;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        Solution ob;
        vector<int> result = ob.factorial(N);
        for (int i = 0; i < result.size(); ++i){
            cout<< result[i];
        }
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends