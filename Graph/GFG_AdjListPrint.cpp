/* https://practice.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1#
 * Given the adjacency list of a bidirectional graph. Your task is to copy/clone the adjacency list for each vertex and return a new list.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    // Function to return the adjacency list for each vertex.
    vector<vector<int>> printGraph(int V, vector<int> adj[]) {

        vector<vector<int>> node_adj_list(V);

        for(int v=0; v<V; v++){

            node_adj_list[v].push_back(v);
            for(auto w: adj[v])
                node_adj_list[v].push_back(w);
        }// for v

        return node_adj_list;
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >> E;
        vector<int> adj[V];
        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        Solution obj;
        vector<vector<int>> ans = obj.printGraph(V, adj);
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans[i].size() - 1; j++) {
                cout << ans[i][j] << "-> ";
            }
            cout << ans[i][ans[i].size() - 1];
            cout << endl;
        }
    }
    return 0;
}  // } Driver Code Ends