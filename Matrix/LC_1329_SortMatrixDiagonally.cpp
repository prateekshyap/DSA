/*
https://leetcode.com/problems/sort-the-matrix-diagonally/
1329. Sort the Matrix Diagonally

https://practice.geeksforgeeks.org/problems/diagonal-morning-assembly0028/1/#
Sort a 2D vector diagonally 
*/
//LC
class Solution {
public:
    vector<vector<int>> diagonalSort(vector<vector<int>>& mat) {
        
        int m = mat.size();
        int n = mat[0].size();
        unordered_map<int, priority_queue<int, vector<int>, greater<int>> > um;
        
        //store all the elements diagonal wise
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                um[i-j].push(mat[i][j]); //[i-j] will be same for dig element
        // elements are sorted as we push in the diagonal
        
        //store back
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                mat[i][j] = um[i-j].top();
                um[i-j].pop();
            }
        return mat;
    }//end
};



//GFG

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution {
  public:
    void diagonalSort(vector<vector<int> >& matrix, int n, int m) {
        
        unordered_map<int, vector<int>> um;
        
        //store all the elements diagonal wise
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
                um[i-j].push_back(matrix[i][j]); //[i-j] will be same for dig element
        
        // sort 
        for(auto &x: um)
        { 
        //==0 skipping principal diagonal
          if(x.first < 0) // negative means upper triangle
            sort(x.second.begin(), x.second.end());
          else if(x.first > 0) // positive means lower traingle
            sort(x.second.rbegin(), x.second.rend());
        }
        
        //store back
        for(int i=0; i<n; i++)
            for(int j=0; j<m; j++)
            {
                if(i!=j) // skip principal dig
                {
                    matrix[i][j] = um[i-j].back();
                    um[i-j].pop_back();
                }
            }
        
    }//end
};

// { Driver Code Starts.

int main() 
{ 
    int t;
    cin>>t;
    while(t--)
    {
        int n, m;
        cin>>n>>m;

        int inputline2[n*m];
        for (int i = 0; i < n*m; ++i)
            cin>> inputline2[i];
        vector<vector<int> > matrix( n , vector<int> (m, 0));

        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; ++j) {
                matrix[i][j] = inputline2[i * m + j]; 
            }
        }
        
        Solution ob;
        ob.diagonalSort(matrix, n, m);

        // print the modified matrix
        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < m; j++) { 
                cout << matrix[i][j] << " "; 
            } 
            cout << endl; 
        }    
    }
    return 0;
}

  // } Driver Code Ends