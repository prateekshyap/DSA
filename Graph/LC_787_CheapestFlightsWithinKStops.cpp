/*
https://leetcode.com/problems/cheapest-flights-within-k-stops/
787. Cheapest Flights Within K Stops

*/

class Solution {
public:
//     int Bellman(int n, vector<vector<int>>& flights, int src, int dst, int k) {
//         //Using Bellman Ford
//         vector<int> dist(n, 1e9);
//         int edges = flights.size();
        
//         dist[src] = 0;
//         for(int v=0; v<=k; v++)
//         {
//             vector<int> ndist = dist;
//             for(int e=0; e<edges; e++)
//             {
//                 int u = flights[e][0], v = flights[e][1], p = flights[e][2];
//                 if(dist[u] + p < ndist[v])
//                     ndist[v] = dist[u]+p;
//             }
//             dist = ndist;
//         }
        
//         // for(int x: dist) cout<<x<<" "; cout<<endl;
        
//         return dist[dst] == 1e9 ? -1 : dist[dst];
//     }
    
    typedef pair<int, pair<int,int>> pii; //cost, src, stops
    typedef pair<int,int> pi; // dst, price
    int dijkstra_1(int n, int src, int dst, int k, vector<pi> adj[]) {
         
         priority_queue<pii, vector<pii>, greater<>> pq;
         pq.push({0, {src, 0}});// cost, src, stops
         
         vector<int> cost(n, 1e9);
         vector<int> stops(n, 1e9); 
         cost[src] = 0; stops[src] = 0;
         
         while(!pq.empty())
         {
             int c = pq.top().first; //cost of u
             int u = pq.top().second.first; // u
             int s = pq.top().second.second; pq.pop();// stops of u
             if(s >= k+1) continue;
             
             for(auto [v, price]: adj[u])
             {
                 if(v == dst)
                 {
                     if(c + price < cost[v] and s<=k)
                     {
                        cost[v] =c+price; stops[v] = s;
                        pq.push({cost[v],{v, stops[v]}});
                     }
                 } // either price should be less or hops is less then insert into priority queue
                 else if((c + price < cost[v]) or (1 + s < stops[v]))
                 {
                     cost[v] =c+price; stops[v] = 1+s;
                     pq.push({cost[v],{v, stops[v]}});
                 }
             }
         }//while
         
         // for(int i=0; i<n; i++) cout<<cost[i]<<" "; cout<<endl;
         // for(int i=0; i<n; i++) cout<<stops[i]<<" "; cout<<endl;
         
         if(cost[dst] == 1e9)
             return -1;
         else
             return cost[dst];
    }
    
    int dijkstra_2(int n, int src, int dst, int k, vector<pi> adj[]) {
         
         priority_queue<pii, vector<pii>, greater<>> pq;
         pq.push({-1, {0, src}});// level, cost, src
         
         vector<int> cost(n, 1e9);  
         cost[src] = 0; 
         
         while(!pq.empty())
         {
             int l = pq.top().first;  
             int c = pq.top().second.first;  
             int u = pq.top().second.second; pq.pop(); 
             
             if(l+1 > k) continue;
             
             for(auto [v, price]: adj[u])
             {
                  if(c + price < cost[v]  )
                 {
                     cost[v] =c+price;  
                     pq.push({l+1,{cost[v], v}});
                 }
             }
         }//while
         
         // for(int i=0; i<n; i++) cout<<cost[i]<<" "; cout<<endl;
         // for(int i=0; i<n; i++) cout<<stops[i]<<" "; cout<<endl;
         
         if(cost[dst] == 1e9)
             return -1;
         else
             return cost[dst];
    }
    
    int dijkstra_3(int n, int src, int dst, int k, vector<pi> adj[]) {
         
         priority_queue<pi> pq; // MAX HEAP
         pq.push({0, src});// cost, src
         
         vector<int> cost(n, 1e9), level(n, 1e9);  
         cost[src] = 0; level[src] = -1; 
         
         while(!pq.empty())
         {
             auto [c, u] = pq.top(); pq.pop(); 
             if(level[u] == k) continue;
             
             // cout<<u<<" "<<c<<" "<<level[u]<<") ";
             for(auto [v, price]: adj[u])
             {
                  if(c + price < cost[v]  )
                 {
                      level[v]  = 1 + level[u];
                     cost[v] =c+price;   
                     pq.push({cost[v], v});
                 }
             }
         }//while
         
         for(int i=0; i<n; i++) cout<<cost[i]<<" "; cout<<endl;
         for(int i=0; i<n; i++) cout<<level[i]<<" "; cout<<endl;
         
         if(cost[dst] == 1e9)
             return -1;
         else
             return cost[dst];
    }
    
     int findCheapestPrice(int n, vector<vector<int>>& flights, int src, int dst, int k) {
         // return Bellman(n, flights, src, dst, k);
         
         vector<pi> adj[n];
         for(auto &e: flights)
             adj[e[0]].push_back({e[1], e[2]});
         // return dijkstra_1(n, src, dst, k, adj);
         return dijkstra_2(n, src, dst, k, adj); // min heap + level
         // return dijkstra_3(n, src, dst, k, adj); //max heap + level
    }
};