/*
https://practice.geeksforgeeks.org/problems/bridge-edge-in-graph/1
Bridge edge in a graph
*/


class Solution
{
    
    vector<bool> vis;
	public:
    //Function to find if the given edge is a bridge in graph.
    int isBridge(int V, vector<int> adj[], int c, int d) 
    {
        vis = vector<bool>(V, false);
        
        //DFS
        C=c; D=d;
        dfs(c , adj);
        return vis[d] == false;
        
        //BFS
        adj[c].erase(find(adj[c].begin(), adj[c].end(), d));
        adj[d].erase(find(adj[d].begin(), adj[d].end(), c));
        queue<int> q;
        q.push(c);
        vis[c] = true;
        
        while(!q.empty())
        {
            int e = q.front(); q.pop();
            for(auto &w: adj[e])
            {
                if(vis[w]==false)
                {
                    vis[w] = true;
                    q.push(w);
                    if(w==d) return 0;
                }
            }
        }
        return vis[d]==false;
    }
    
    int C, D;
    void dfs(int s, vector<int> adj[])
    {
        vis[s] = true;
        for(auto &w: adj[s])
        {
            if(vis[w]==false and (w!=D || s!=C))
            {
                vis[w] = true;
                if(w==D) return;
                dfs(w, adj);
            }
        }
    }
};