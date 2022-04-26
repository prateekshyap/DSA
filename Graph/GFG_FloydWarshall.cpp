/*
Floyd Warshall 
https://practice.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1
*/

//Initial template for C++

#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
//User function template for C++

class Solution {
  public:
	void shortest_distance(vector<vector<int>>&matrix){
	   
	   int v = matrix.size();
	   
	   for(int k = 0; k<v; k++) // intermediate vertices
	   {
	       for(int i=0; i<v; i++) // source
	       {
	           for(int j=0; j<v; j++) // destination
	           {
	               if(i==k || j==k || matrix[i][k]==-1 || matrix[k][j]==-1 || i==j)
	                continue;
	                // matrix[i][j] > matrix[k][j]+matrix[i][k]
	                if(matrix[i][j]==-1)
	                    matrix[i][j] = matrix[i][k]+matrix[k][j];
	               else
	                    matrix[i][j] = min(matrix[i][j], matrix[i][k]+matrix[k][j]);
	           }
	       }
	   }
	   
	   
	}// end;
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<vector<int>>matrix(n, vector<int>(n, -1));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cin >> matrix[i][j];
			}
		}
		Solution obj;
		obj.shortest_distance(matrix);
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				cout << matrix[i][j] << " ";
			}
			cout << "\n";
		}
	}
	return 0;
}  // } Driver Code Ends