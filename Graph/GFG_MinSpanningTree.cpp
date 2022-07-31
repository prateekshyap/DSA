/*
Minimum Spanning Tree 
https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1
*/
class Solution
{
	public:
	//Function to find sum of weights of edges of the Minimum Spanning Tree.
    
    int spanningTree(int V, vector<vector<int>> adj[])
    {
        // return spanningTreePrims(V, adj);
        return spanningTreeKrushkals(V, adj);
    }
    
    //Krushkals Algorithm // Disjoint Set 
    vector<int> parent, rank;
    int spanningTreeKrushkals(int V, vector<vector<int>> adj[])
    {
        parent = vector<int>(V);
        rank = vector<int>(V, 0);
        for(int i=0; i<V; i++) parent[i] = i;
        
        vector<pair<int, pair<int,int>>> edges; //{wt, {u, v}}
        for(int u=0; u<V; u++) {
            for(auto w: adj[u])
                edges.push_back({w[1], {u, w[0]}});   
        }
        sort(edges.begin(), edges.end());
    //   for( auto edge: edges) cout<<edge.first<<" ("<<edge.second.first<<","<<edge.second.second<<")"<<endl;    
        int sumwt=0;
        for( auto edge: edges)
        {
            int u = edge.second.first, v = edge.second.second;
            if(find_set(u) != find_set(v))
            {
                union_set(u,v);
                sumwt += edge.first;
            }
        }
        return sumwt;
    }
    
    bool union_set(int x, int y) {
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
    
    int find_set(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find_set(parent[x]);
    }
    
    // Prims Algorithm
    int spanningTreePrims(int V, vector<vector<int>> adj[])
    {
        
        vector<int> parent(V, -1), weight(V, INT_MAX);
        vector<bool> isMST(V, false);
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq;
        weight[0] = 0; 
        pq.push({weight[0], 0});
        while(!pq.empty())
        {
            int node = pq.top().second; pq.pop(); 
            if(isMST[node]) continue;
            isMST[node] = true;
            for(const auto& w: adj[node])
            {
                int adjnode = w[0]; int wgt = w[1];
                if(!isMST[adjnode] and wgt < weight[adjnode])
                {
                    parent[adjnode] = node;
                    weight[adjnode] = wgt; 
                    pq.push({wgt, adjnode});
                }
            }
        }
        
        int sum=accumulate(weight.begin(), weight.end(), 0);
        return sum;
    }
    
    /*
     int spanningTree(int V, vector<vector<int>> adj[])
    {
        vector<int> parent(V, -1), weight(V, INT_MAX);
        vector<bool> isMST(V, false);
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq;
        weight[0] = 0; 
        pq.push({weight[0], 0});
        while(!pq.empty())
        {
            auto n = pq.top(); pq.pop(); 
            int node = n.second; int w = n.first;
            if(isMST[node]) continue;
            isMST[node] = true;
            weight[node] = w; 
            for(const auto& w: adj[node])
            {
                int adjnode = w[0]; int wgt = w[1];
                if(!isMST[adjnode] and wgt < weight[adjnode])
                {
                    parent[adjnode] = node;
                    pq.push({wgt, adjnode});
                }
            }
        }
        
        int sum=accumulate(weight.begin(), weight.end(), 0);
        return sum;
    }
    */
    
};