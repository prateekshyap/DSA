/* https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1#
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
public:
    // Function to detect cycle in an undirected graph.
    bool isCycle(int V, vector<int> adj[]) {

        vector<bool> visited(V,false);

        for(int v=0; v<V; ++v){ //for disconnected graph
            if(!visited[v]){
                // if(DFS_CD(v, -1, adj, visited))   //USING DFS
                //     return true;
                if(BFS_CD(v, adj, V))    //USING BFS
                    return true;

            }//if vis
        }//for v

        return false; // cycle not detected
    }//isCycle

    bool DFS_CD(int src, int par, vector<int> adj[], vector<bool> &vis){

        vis[src]=true;

        for(int w: adj[src]){

            if(!vis[w]){
                if(DFS_CD(w, src, adj, vis))
                    return true;

            }//vis if
            else if(w != par)  //third vertex
                return true;

        }//for adj
        return false;
    }//DFS

    bool BFS_CD(int src, vector<int> adj[], int V){

        vector<bool> vis(V, false);
        vector<int> par(V,-1);          // parent of node
        queue<int> q;

        q.push(src);
        vis[src]=true;

        while(!q.empty()){
            int x = q.front(); q.pop();

            for(int w: adj[x]){
                if(!vis[w])
                {
                    vis[w]=true;
                    q.push(w);
                    par[w]=x;
                }
                else if(w!=par[x]) return true;
            }// for w
        }// while q
        return false;
    }//BFS_CD

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
        bool ans = obj.isCycle(V, adj);
        if (ans)
            cout << "1\n";
        else
            cout << "0\n";
    }
    return 0;
}  // } Driver Code Ends