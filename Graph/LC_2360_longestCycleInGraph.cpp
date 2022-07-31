/*
https://leetcode.com/problems/longest-cycle-in-a-graph/
2360. Longest Cycle in a Graph

*/
class Solution {
public:
//     stack<int> st;
// 	vector<int> visited;
//     vector<int> component;
//     void dfs(int s, vector<vector<int>>& adj, bool insert)
//     {
//         visited[s] = true;
//         for(int w: adj[s])
//         {
//             if(visited[w] == false)
//              {
//                  dfs(w, adj, insert);
//              }
//         }
//         if(insert) //first dfs to put topological sort
//             st.push(s);
//         else // second dfs to put components
//             component.push_back(s);
//     }
    
//     int sizeOfConnectedComponents(vector<int>& edges) {
//         int n = edges.size();
//         vector<vector<int>> adj(n), revadj(n);
//         for(int i=0; i<n; i++)
//         {
//             if(edges[i] != -1)
//             {
//                 adj[i].push_back(edges[i]);
//                 revadj[edges[i]].push_back(i); //reversing the graph/transposing
//             }
//         }
        
//         visited.resize(n, false);
//         //calling dfs first time
//         for(int v=0; v<n; v++)
//         {
//             if(visited[v] == false)
//                 dfs(v, adj, true);
//         }
        
//         visited.assign(n, false);
        
//         int longest=-1;
//         while(!st.empty())
//         {
//             int s = st.top(); st.pop();
//             if(visited[s] == false)
//             {
//                 component.clear();
//                 dfs(s, revadj, false);
//                 int cur = component.size();
//                 if(cur != 1)
//                     longest = max(longest, cur);
//             }
//         }
        
//         return longest;
//     }
    
    int longestCycle(vector<int>& edges) {
        // return sizeOfConnectedComponents(edges);
        int longest = -1;
        int n = edges.size();
        // vector<int> dist(n, INT_MAX);
//         function<void(int,int)> dfs = [&](int u, int d)
//         {
//             if(u == -1)return;
//             if(dist[u] == INT_MAX)
//             {
//                 dist[u] = d;
//                 dfs(edges[u], d+1);
//             }
//             else if(dist[u]>0){
//                 longest = max(longest, d - dist[u]);
//             }
//             dist[u]=0;
//         };
        
//         for(int i=0; i<n; i++)
//             dfs(i, 1);
        
        // for(int i=0, d=1; i<n; i++)
        // {
        //     int u=i, srcd = d;
        //     while(u != -1 and dist[u] ==INT_MAX)
        //     {
        //         dist[u] = d++;
        //         u = edges[u];
        //     }
        //     if(u!=-1 and dist[u] >= srcd)
        //         longest = max(longest, d-dist[u]);
        // }
        // return longest;
        vector<pair<int,int>> memo(n, {-1, -1});
        for(int i=0; i<n; i++)
        {
            for(int u=i, d=1; u!=-1 ; u= edges[u])
            {
                auto [disti, fromi] =  memo[u];
                if(disti == -1)
                    memo[u] = {d++, i};
                else
                {
                    if(fromi == i)
                        longest = max(longest, d-disti);
                    break;
                }
            }
        }
        return longest;
    }
};