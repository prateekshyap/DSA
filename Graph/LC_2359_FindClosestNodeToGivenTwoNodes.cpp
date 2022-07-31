/*
https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
2359. Find Closest Node to Given Two Nodes

*/

#define INF 1e9
class Solution {
public:
    
//     vector<int> bfs_trav(int src, int n, vector<int> adj[])
//     {
//         vector<int> dist(n, INF);
//         queue<int>q;
//         q.push(src);
//         dist[src] = 0;
//         while(!q.empty())
//         {
//             int src = q.front(); q.pop();
//             for(int w: adj[src])
//             {
//                 if(dist[w] == INF)
//                 {
//                     dist[w] = dist[src] + 1;
//                     q.push(w);
//                 }//if
//             }//for w
//         }// while q
//         return dist;
//     }
    
//     int UsingBFS(vector<int>& edges, int node1, int node2) {
//         int n = edges.size();
//         vector<int> adj[n];
//         for(int i=0; i<n; i++)
//             if(edges[i]!=-1) adj[i].push_back(edges[i]);
        
//         auto dist1=bfs_trav(node1, n, adj);
//         auto dist2=bfs_trav(node2, n, adj);
        
//         int ansnode=-1; 
//         int mindist=INF;
//         for(int i=0; i<n; i++)
//         {
//             if(dist1[i] != INF and dist2[i] != INF)
//             {
//                int d = max(dist1[i], dist2[i]); 
//                if(ansnode == -1 || d < mindist)
//                {
//                    ansnode = i;
//                    mindist = d;
//                }
//             }
//         }
        
//         return ansnode;
//     }
    
     int closestMeetingNode(vector<int>& edges, int node1, int node2) {
        // return UsingBFS(edges, node1, node2);
         int n = edges.size();
        int ansnode=-1;
        int mindist = INF;
        vector<int> dist1(n, INF), dist2(n, INF);
        int v=node1, d = 0;
         while(v!=-1 and dist1[v]==INF)
         {
             dist1[v] = d++;
             v = edges[v];
         }
         v=node2; d = 0;
         while(v!=-1 and dist2[v]==INF)
         {
             dist2[v] = d++;
             v = edges[v];
         }
         
         for(int i=0; i<n; i++)
        {
            if(dist1[i] != INF and dist2[i] != INF)
            {
               int cd = max(dist1[i], dist2[i]); 
               if(ansnode == -1 || cd < mindist)
               {
                   ansnode = i;
                   mindist = cd;
               }
            }
        }
         return ansnode;
    }
};