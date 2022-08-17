/*
2368. Reachable Nodes With Restrictions

https://leetcode.com/problems/reachable-nodes-with-restrictions/
*/

class Solution {
public:
    int reachableNodes_1(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        int cnt=0;
        vector<int> adj[n];
        unordered_set<int> res(restricted.begin(), restricted.end());
        for(auto& edg: edges)
        {
            if(res.count(edg[0]) or res.count(edg[1])) continue;
            adj[edg[0]].push_back(edg[1]);
            adj[edg[1]].push_back(edg[0]);
        }
        
        queue<int> q; q.push(0);
        vector<int> visited(n, false);
        visited[0] = true;
        while(!q.empty())
        {
            int node = q.front(); q.pop();
            cnt++;
            for(int w: adj[node])
            {
                if(visited[w] == false)
                {
                    visited[w] = true;
                    q.push(w);
                }
            }
        }
        return cnt;
    }//end
    
    int reachableNodes(int n, vector<vector<int>>& edges, vector<int>& restricted) {
        vector<int> adj[n];
        for(auto& edg: edges)
        {
            adj[edg[0]].push_back(edg[1]);
            adj[edg[1]].push_back(edg[0]);
        }
        vector<int> visited(n, false);
        for(int &x: restricted) visited[x]=true;
        // visited[0] = true;
        return dfs(0, visited, adj);
    }//end
    
    int dfs(int src, vector<int>& visited, vector<int> adj[])
    {
        if(visited[src]) return 0;
        visited[src] = true;
        int cnt=1;
        for(auto &w: adj[src])
        {
            if(visited[w] == false)
            cnt+=dfs(w, visited, adj);
        }
        return cnt;
    }
};