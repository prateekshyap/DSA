/*
1192. Critical Connections in a Network

https://leetcode.com/problems/critical-connections-in-a-network/
*/

class Solution {
    int timer;
    vector<int> dtime;
    vector<int> low;
    vector<bool> visited; 
    vector<vector<int>> ans;
    vector<vector<int>> adj;
public:
    
    vector<vector<int>> criticalConnections(int n, vector<vector<int>>& connections) {
        adj.resize(n);
        for(auto edge: connections)
        {
            int u=edge[0], v = edge[1];
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        
        timer=0;
        dtime.resize(n, 0);
        low.resize(n, 0);
        visited.resize(n, false);
        
        // for(int i=0; i<n; i++)
        // {
            // if(visited[i] == false)
                dfs(0, -1); 
        // } 
        return ans;
    }
    
    void dfs(int s, int p)
    {
        dtime[s] = low[s] = timer++;
        visited[s] = true;
        
        for(auto &w: adj[s])
        {
            if(visited[w] ==false)
            {
                dfs(w, s);
                low[s] = min(low[s], low[w]);
            }
            else if(w != p) // w visited and w not same as parent that is back edge
            {
                low[s] = min(low[s], dtime[w]);
            }
            if(low[w]>dtime[s])
                ans.push_back({s, w});
        }
    }
};