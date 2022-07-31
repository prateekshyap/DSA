/* https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1#
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges, check whether it contains any cycle or not.
 */

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
public:

    enum COLOR {WHITE, GRAY, BLACK};
    /*  WHITE = 0  Unvisited
     *  GRAY  = 1  visiting, in stack
     *  BLACK = 2  visited, out of stack
     */
    // Function to detect cycle in a directed graph.
    bool isCyclic(int V, vector<int> adj[]) {

        vector<int> color(V,WHITE);

        vector<bool> visited(V,false);
        vector<bool> rec_stack(V,false);

        for(int v=0; v<V; ++v){ //for disconnected graph
            if(!visited[v]){

                // if(DFS_CD(v, adj, color))   //USING DFS Color method
                //     return true;

                if(DFS_CD_Rec(v, adj, visited, rec_stack))   //USING DFS Recursion method
                    return true;

            }//if vis
        }//for v

        return false; // cycle not detected
    }//isCyclic


    bool DFS_CD(int src, vector<int> adj[],  vector<int> &col){


        col[src]=GRAY;

        for(int w: adj[src]){

            if(col[w] == GRAY) return true; // node already in stack
            else if(col[w]== WHITE && DFS_CD(w, adj, col))
                return true;

        }//for adj
        col[src]=BLACK;
        return false;
    }//DFS

    bool DFS_CD_Rec(int src, vector<int> adj[],  vector<bool> &vis,  vector<bool> &rec){


        vis[src]=true;
        rec[src]=true;

        for(int w: adj[src]){

            if(!vis[w] && DFS_CD_Rec(w, adj, vis, rec)) return true; // node already in stack
            else if(rec[w])
                return true;

        }//for adj

        rec[src]=false;

        return false;
    }//DFS

};

// { Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;

        vector<int> adj[V];

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        cout << obj.isCyclic(V, adj) << "\n";
    }

    return 0;
}
// } Driver Code Ends