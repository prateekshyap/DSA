/*
Negative weight cycle 
https://practice.geeksforgeeks.org/problems/negative-weight-cycle3504/1

Distance from the Source (Bellman-Ford Algorithm) 
https://practice.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1/
*/

// Negative Cycle
 // } Driver Code Ends
class Solution {
public:
	int isNegativeWeightCycle(int n, vector<vector<int>>edges){
	    // Code here
	    
	    const int INF = 1e8;
        vector<int> dist (n, INF);
        bool negativeCycle = false;
        
        dist[0]=0;
        
        int u,v,dt;
        
        for(int i=1; i<=n-1; i++)
        {
            for(auto x: edges)
            {
               u = x[0];
               v = x[1];
               dt = x[2];
               
               if(dist[u]+dt < dist[v]) // dist[u] != INT_MAX && 
                    dist[v] = dist[u] + dt;
            }
        }
        
        // Run for last iteration to check if it contains negative cycle or not
        for(auto x: edges)
        {
           u = x[0];
           v = x[1];
           dt = x[2];
           
           if(dist[u]+dt < dist[v])
            {    
                negativeCycle= true;
                break;
            }
        }
        
        return negativeCycle;
	}
};

// Distance
class Solution{
	public:
	/*  Function to implement Dijkstra
    *   adj: vector of vectors which represents the graph
    *   S: source vertex to start traversing graph with
    *   V: number of vertices
    */
    vector <int> bellman_ford(int V, vector<vector<int>> adj, int S) {
        
        const int INF = 1e8;
        vector<int> dist (V, INF);
        bool negativeCycle = false;
        
        dist[S]=0;
        
        int u,v,dt;
        
        for(int i=1; i<=V-1; i++)
        {
            for(auto x: adj)
            {
               u = x[0];
               v = x[1];
               dt = x[2];
               
               if(dist[u] != INT_MAX && dist[u]+dt < dist[v])
                    dist[v] = dist[u] + dt;
            }
        }
        
        // Run for last iteration to check if it contains negative cycle or not
        for(auto x: adj)
            {
               u = x[0];
               v = x[1];
               dt = x[2];
               
               if(dist[u]+dt < dist[v])
                    negativeCycle= true;
            }
        
        return dist;
    }//end
};