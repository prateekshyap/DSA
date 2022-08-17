/*
https://practice.geeksforgeeks.org/problems/maximum-of-minimum-for-every-window-size3453/1#
Maximum of minimum for every window size 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends

class Solution
{
    public:
    //Function to find maximum of minimums of every window size.
    vector <int> maxOfMin_TLE(int arr[], int n)
    {
        vector<int> ans;
        int mxOfMn, mn;
        for(int k=1; k<=n; k++) // variable window
        {
            mxOfMn = INT_MIN;
            for(int i=0; i<n-k+1; i++)
            {
                mn = arr[i]; 
                for(int j=i+1; j<i+k; j++)
                {
                    mn = min(mn, arr[j]);
                }
                mxOfMn = max(mxOfMn, mn);
            }
            ans.push_back(mxOfMn);
        }
        return ans;
    }
    
    vector <int> maxOfMin(int arr[], int n)
    {
        vector<int> ans(n+1,0);
        stack<int> st;
        // left -> prev smaller element index on left side of the ith element
        // right -> next smaller element index on right side of the ith element
        vector<int> left(n, -1), right(n, n);
        
        // find prev smaller element index of ith element
        for(int i=0; i<n; i++)
        {
            while(!st.empty() && arr[i] <= arr[st.top()])
                st.pop();
            
            if(!st.empty()) //default -1
                left[i] = st.top();
                
            st.push(i);
        }
        
        while(!st.empty())
            st.pop();
            
        for(int i=n-1; i>=0; i--)
        {
            while(!st.empty() && arr[i] <= arr[st.top()])
                st.pop();
            
            if(!st.empty()) //default -1
                right[i] = st.top();
                
            st.push(i);
        }
        
        int len =0;
        for(int i=0; i<n; i++)
        {
            //length of interval
            len = right[i] - left[i] - 1;
            
            // ans[0] is ans for length 0, useless
            ans[len] = max(ans[len], arr[i]); 
        }
        
        for(int i= n-1; i>=1; i--)
            ans[i] = max(ans[i], ans[i+1]); 
        
        ans.erase(ans.begin());
        
        return ans;
    }
};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;

    while (t--) {
        int n;
        cin >> n;
        int a[n];
        for (int i = 0; i < n; i++) cin >> a[i];
        Solution ob;
        vector <int> res = ob.maxOfMin(a, n);
        for (int i : res) cout << i << " ";
        cout << endl;
    }
    return 0;
}
  // } Driver Code Ends