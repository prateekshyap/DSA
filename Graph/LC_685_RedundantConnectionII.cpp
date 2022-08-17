/*
https://leetcode.com/problems/redundant-connection-ii/
*/

class Solution {
    
    vector<int> parent, rank;
    int find_set(int x){
        if(parent[x] == x) return x; // return parent
        return parent[x] = find_set(parent[x]); // travel upward
    }
    
    bool union_set(int x, int y)
    {
        int px = find_set(x);
        int py = find_set(y);
        if(px == py) return true;
        if(rank[px] > rank[py]) 
            swap(px, py);
        parent[px] = py;
        if(rank[px] == rank[py])
            rank[py]++;
        return false;
    }
    
public:
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
        int n = edges.size();
        // return findByDFS(edges);
        return findByUnionFind(edges);
    }//findRedundantDirectedConnection
    
    
    vector<int> findByUnionFind(vector<vector<int>>& edges) {
        int n = edges.size(); 
        parent.resize(n+1, 0);
        rank.resize(n+1, 0);
        
        int child = -1, candA =  -1, candB = -1;
        // 1. check whether there is a node with two parents/ two incoming edge. remove the second incoming edge
        for(auto &edge: edges)
        {
            int u = edge[0], v = edge[1];
            if(parent[v] == 0)
                parent[v] = u;
            else {
                candA = parent[v];
                candB = u;
                child = v;
                edge[1] = 0; // removes the edge
            }
            // cout<<edge[0]<<" "<<edge[1]<<") ";
        }
        
        //2. Union Find : try to find cycle in the graph, remove the first node resultes in cycle.
        for(int i=1; i<=n; i++) parent[i] = i;
        for(auto &edge: edges)
        {
            int u = edge[0], v = edge[1];
            if(union_set(u,v)) // found a cycle
            {
                if(candA == -1) return edge; // without remove the edge
                return {candA, child}; // with removing the edge still we found the cycle then other edge was the main culprit
            }
        }
        // for(int i=0; i<=n; i++) cout<<parent[i]<<" ";cout<<endl;
        return {candB, child}; // we didnt found a cycle bec of removing this edge
    }//findRedundantDirectedConnection
    
    
    
    /*
    vector<bool> visited;
    vector<int> findByDFS(vector<vector<int>>& edges) {
        int n = edges.size(); 
        vector<int> adj[n+1]; 
        vector<int> ind(n, 0); // to find root node
        for(auto x: edges)
        {  
            int u = x[0]-1, v = x[1]-1;  
            adj[u].push_back(v); // adj list
            ind[v]++;
        }
           
        for(int i=n-1; i>=0; i--)
        {  
            int u = edges[i][0]-1, v = edges[i][1]-1; 
            ind[v]--; // remove edge
            visited.assign(n, false); 
        
            for(int i=0; i<n ; i++)
            {
                if(ind[i] == 0)
                {
                    int p = n;
                    bool res = dfs(i, p, adj, u, v);
                    // cout<<"root "<< i+1<<" ("<<u+1<<" "<<v+1<<") "<<res<<endl;
                    if(res == true) return {u+1, v+1};
                    break;
                }
            }
            
            ind[v]++; // add edge
        }
        
        return {};
    }//
    
    bool dfs(int s,  int &numNodes, vector<int> adj[], int& src, int& dst)
    {
        visited[s] = true;
        if(--numNodes == 0) return true;
        for(auto &w: adj[s])
        {
            if(s == src and w == dst) continue;
            if(!visited[w] and dfs(w, numNodes, adj, src, dst))
               return true;
        }
        return false;
    }
    */
};