/* https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1#
 * Given a directed graph. The task is to do Breadth First Traversal of this graph starting from 0.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
public:
    // Function to return Breadth First Traversal of given graph.
    vector<int> bfsOfGraph(int V, vector<int> adj[]) {
        // Code here

        vector<int> bfs_list;  // to store the bfs traversal
        queue<int> q;
        bool visited[V]={false};

        q.push(0);          //0th node;
        visited[0]=true;

        while(!q.empty()){
            int x = q.front();
            bfs_list.push_back(x);
            q.pop();

            for(int w: adj[x]){
                if(!visited[w]){
                    visited[w]=true;
                    q.push(w);
                }
            }//for adj
        }//while queue
        return bfs_list;
    }//bfsOfGraph
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