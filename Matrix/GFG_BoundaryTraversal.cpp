/*
 	https://practice.geeksforgeeks.org/problems/boundary-elements-of-matrix1102/1/#
	
*/

// { Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends

class Solution {
public:
    vector<int> BoundaryElements(vector<vector<int>>&matrix){
        // Code here
        int r = matrix.size();
        int c = matrix[0].size();
        
        vector<int> ans;
        
        //TC: O(n^2)
        // for(int i=0; i<r; i++)
        // {
        //     for(int j=0; j<c; j++)
        //     {
        //         if(i==0 || j==0 || i==r-1 || j==c-1)
        //             ans.push_back(matrix[i][j]);
        //     }
        // }
        
        for(int j=0;j<c; j++)
            ans.push_back(matrix[0][j]);
        
        for(int i=1; i<r-1; i++)
        {
            ans.push_back(matrix[i][0]);
            ans.push_back(matrix[i][c-1]);
        }
        
        if(r>1)
        for(int j=0; j<c; j++)
        {
            ans.push_back(matrix[r-1][j]);
        }
        
        
        return ans;
    }//end
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>matrix(n, vector<int>(n, 0));
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				cin >> matrix[i][j];
		Solution obj;
		vector<int>ans = obj.BoundaryElements(matrix);
		for(auto i: ans)
			cout << i << " ";
		cout << "\n";
	}
	return 0;
}  // } Driver Code Ends