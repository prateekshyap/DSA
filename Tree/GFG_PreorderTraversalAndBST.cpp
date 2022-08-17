/*
https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1
Preorder Traversal and BST
*/

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int canRepresentBST(int pre[], int n) {
        stack<int> st;
        int root = INT_MIN;
        for(int i=0; i<n; i++)
        {
            //if we find node on right side which is less than root
            if(pre[i] < root)
                return false;
            
            //if we found bigger then remove lesser element from stack
            while(!st.empty() and st.top() < pre[i])
            {
                root = st.top();
                st.pop();
            }
            
            st.push(pre[i]);
            
        }
        return true;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        int arr[N];
        for (int i = 0; i < N; i++) cin >> arr[i];
        Solution ob;
        cout << ob.canRepresentBST(arr, N) << endl;
    }
    return 0;
}
// } Driver Code Ends