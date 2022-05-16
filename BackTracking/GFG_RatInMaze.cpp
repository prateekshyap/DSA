/*
https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
Rat in a Maze Problem - I 
*/
// { Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
// User function template for C++

class Solution{
    public:
    int N=0;
    // vector<vector<bool>> visited;
    vector<string> ans;
    
    // string cpath="";
    
    vector<string> findPath(vector<vector<int>> &m, int n) {
        
        N=n;
        // visited.resize(N, false);
        
        dfsPath(0, 0, "", m);
        
        return ans;
    }//end
    
    void dfsPath(int x, int y, string p, vector<vector<int>>& m)
    {
        // m[x][y]==0 || m[x][y]==-1
        if(x<0 || x==N || y<0 || y==N ||  m[x][y]!=1) // no cell can be visited more than one
            return;
        
        if(x==N-1 && y==N-1)
        {
            ans.push_back(p);
            return;
        }
        
        int oldVal= m[x][y];
        m[x][y]=-1; //mark it as visited
        //check all its neighbours
        if(x-1>=0 &&  m[x-1][y]==1)
            dfsPath(x-1, y, p+"U", m); //up
        if(x+1<N &&  m[x+1][y]==1)
            dfsPath(x+1, y, p+"D", m); //down
        if(y-1>=0 &&  m[x][y-1]==1)
            dfsPath(x, y-1, p+"L", m); //left
        if(y+1<N &&  m[x][y+1]==1)
            dfsPath(x, y+1, p+"R", m); //right
        
        m[x][y]=oldVal; //backtrack
        
    }//dfs
};

    


// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int>> m(n, vector<int> (n,0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> m[i][j];
            }
        }
        Solution obj;
        vector<string> result = obj.findPath(m, n);
        sort(result.begin(), result.end());
        if (result.size() == 0)
            cout << -1;
        else
            for (int i = 0; i < result.size(); i++) cout << result[i] << " ";
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends