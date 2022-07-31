/* https://practice.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1#
 * Given a weighted, undirected and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
 * Note: The Graph doesn't contain any negative weight cycle.
 */

class Solution
{
	public:
	//Function to find the shortest distance of all the vertices
    //from the source vertex S.
    vector <int> dijkstra_PQ(int V, vector<vector<int>> adj[], int S)
    {
        vector<int> dist(V, INT_MAX);
        vector<bool> relaxed(V, false);
        priority_queue<pair<int,int>, vector<pair<int,int>>, greater<>> pq;
        pq.push({0, S});
        
        while(!pq.empty())
        {
            auto n = pq.top(); pq.pop();
            int node = n.second; int curdist = n.first;
            if(relaxed[node]) continue;
            
            dist[node] = curdist;
            relaxed[node] =true;
            
            for(auto w : adj[node])
            {
                if(!relaxed[w[0]] and curdist+w[1] < dist[w[0]])
                {
                    pq.push({curdist+w[1], w[0]});
                }
            }
        }
        
        return dist;
    }
    
    vector <int> dijkstra(int V, vector<vector<int>> adj[], int S)
    {
        vector<int> dist(V, INT_MAX);
        dist[S] = 0;
        set<pair<int,int>> pq;
        pq.insert({0, S});
        
        while(!pq.empty())
        {
            auto n = *pq.begin() ;
            int node = n.second; int curdist = n.first;
            pq.erase(pq.begin());
            
            for(auto w : adj[node])
            {
                if(curdist+w[1] < dist[w[0]])
                {
                    dist[w[0]]= curdist+w[1];
                    pq.insert({dist[w[0]], w[0]});
                }
            }
        }
        
        return dist;
    }
};