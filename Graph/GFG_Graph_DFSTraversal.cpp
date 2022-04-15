/* https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#
 * Given a connected undirected graph. Perform a Depth First Traversal of the graph.
 * Note: Use recursive approach to find the DFS traversal of the graph starting from the 0th vertex from left to right according to the graph.
 */

#include <bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
  public:
    // Function to return Breadth First Traversal of given graph.
    vector<int> bfsOfGraph(int V, vector<int> adj[]) {
        // Code here
        
        vector<int> bfs_lists;
        queue<int> q;
        vector<bool> visited(V,0);
        
        q.push(0);
        visited[0]=true;
        
        while(!q.empty())
        {
            int i = q.front(); q.pop();
            bfs_lists.push_back(i);
            
            for(int w: adj[i])
            {
                if(!visited[w])
                    {
                        visited[w] = true;
                        q.push(w);
                    }
            }
            
        }// while
        
        return bfs_lists;
    }
};

// { Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int V, E;
        cin >> V >>

            E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            // 		adj[v].push_back(u);
        }
        // string s1;
        // cin>>s1;
        Solution obj;
        vector<int> ans = obj.bfsOfGraph(V, adj);
        for (int i = 0; i < ans.size(); i++) {
            cout << ans[i] << " ";
        }
        cout << endl;
    }
    return 0;
}  // } Driver Code Ends