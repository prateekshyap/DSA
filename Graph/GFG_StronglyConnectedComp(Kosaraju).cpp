/* https://practice.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1#
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
 * Find the number of strongly connected components in the graph.
 */

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends


class Solution
{
public:
    //Function to find number of strongly connected components in the graph.
    int kosaraju(int V, vector<int> adj[])
    {
        vector<bool> visited(V, false);     // for DFS
        stack<int> st;
        int cnt_scc=0;

        vector<int> rev_adj[V];         // transpose of a graph
        for(int v=0; v<V; ++v)
            for(auto w: adj[v])
                rev_adj[w].push_back(v);

        for(int v=0; v<V; ++v)          // Calling DFS first time
            if(!visited[v])
                DFS(v, adj, visited, st);

        visited.assign(V,false);        // making visited array false

        while(!st.empty()){
            int s = st.top(); st.pop();

            if(!visited[s]){
                DFS2(s, rev_adj, visited);
                cnt_scc++;
            }
        }// while st

        return cnt_scc;
    }// kosaraju

    void DFS(int s, vector<int> adj[], vector<bool> &vis,  stack<int> &st){
        vis[s]=true;

        for(int w: adj[s]){
            if(!vis[w])
                DFS(w,adj,vis,st);
        }//for adj

        st.push(s);         // push vertex according to its finish time
    }//DFS

    void DFS2(int s, vector<int> adj[], vector<bool> &vis){
        vis[s]=true;

        for(int w: adj[s]){
            if(!vis[w])
                DFS2(w,adj,vis);
        }//for adj

    }//DFS2
};

// { Driver Code Starts.


int main()
{

    int t;
    cin >> t;
    while(t--)
    {
        int V, E;
        cin >> V >> E;

        vector<int> adj[V];

        for(int i = 0; i < E; i++)
        {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
        }

        Solution obj;
        cout << obj.kosaraju(V, adj) << "\n";
    }

    return 0;
}

// } Driver Code Ends