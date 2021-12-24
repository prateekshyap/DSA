/* https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#
 * Given a connected undirected graph. Perform a Depth First Traversal of the graph.
 * Note: Use recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    // Function to return a list containing the DFS traversal of the graph.
    vector<int> dfsOfGraph(int V, vector<int> adj[]) {

        vector<int> dfs_list;

        vector <bool> visited(V,false);

        DFS(0, adj, visited, dfs_list);

        return dfs_list;
    }

    void DFS(int s, vector<int> adj[], vector<bool> &vis, vector<int> &dfs_l){

        dfs_l.push_back(s);
        vis[s]=true;

        for(int w: adj[s]){

            if(!vis[w])
                DFS(w,adj,vis,dfs_l);
        }//for adj

    }//DFS
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
        // string s1;
        // cin>>s1;
        Solution obj;
        vector<int> ans = obj.dfsOfGraph(V, adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends