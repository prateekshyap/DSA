/*
https://practice.geeksforgeeks.org/problems/row-with-max-1s0023/1#
Row with max 1s 
*/
// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++
class Solution{
public:
	int rowWithMax1s(vector<vector<int> > arr, int n, int m) {
	    int row_index = -1;
	    int col_ind = m;
	    
	    for(int r=0; r<n; r++)
	    {
	        while(col_ind > 0 && arr[r][col_ind-1]==1)
	        {
	            row_index = r;
	            col_ind--;
	        }
	        if(col_ind == 0) return row_index;
	    }
	    
	    return row_index;
	}

};

// { Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector< vector<int> > arr(n,vector<int>(m));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cin>>arr[i][j];
            }
        }
        Solution ob;
        auto ans = ob.rowWithMax1s(arr, n, m);
        cout << ans << "\n";
    }
    return 0;
}
  // } Driver Code Ends