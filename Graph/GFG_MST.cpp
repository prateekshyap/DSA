/*
	https://practice.geeksforgeeks.org/problems/minimum-spanning-tree/1#
	Minimum Spanning Tree 
*/

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends


class Solution
{
	public:
	//Function to find sum of weights of edges of the Minimum Spanning Tree.
    int spanningTree(int V, vector<vector<int>> adj[])
    {
        int sum_wgt=0;
        vector<int> parent(V, -1); // parent of each node; 
        vector<int> weights(V,INT_MAX); // weights of each node;
        vector<bool> isMst(V, false);
        
        // include first vertex into the mst
        weights[0] = 0;
        parent[0] = -1;
        
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
        // pair {wgt, node};
        pq.push({weights[0],0});
        
        while(!pq.empty())
        {
            int e = pq.top().second; pq.pop();
            
            isMst[e] = true;
            // sum_wgt += weights[e];
            
            for(const auto& w : adj[e])
            {
                int adjNode = w[0];
                int wgt = w[1];
                if(!isMst[adjNode] && wgt < weights[adjNode])
                {
                    parent[adjNode] = e;
                    weights[adjNode] = wgt;
                    pq.push({weights[adjNode], adjNode});
                }
            }
            
        }// while
        
        for(int v=0; v<V; v++)
        {
            if(weights[v]!=INT_MAX)
                sum_wgt += weights[v];
        }
        return sum_wgt;
    }// end
};

// { Driver Code Starts.


int main()
{
    int t;
    cin >> t;
    while (t--) {
        int V, E;
        cin >> V >> E;
        vector<vector<int>> adj[V];
        int i=0;
        while (i++<E) {
            int u, v, w;
            cin >> u >> v >> w;
            vector<int> t1,t2;
            t1.push_back(v);
            t1.push_back(w);
            adj[u].push_back(t1);
            t2.push_back(u);
            t2.push_back(w);
            adj[v].push_back(t2);
        }
        
        Solution obj;
    	cout << obj.spanningTree(V, adj) << "\n";
    }

    return 0;
}

  // } Driver Code Ends