/*
https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/
2316. Count Unreachable Pairs of Nodes in an Undirected Graph

*/

class Solution {
public:
    
    void dfs(int s, vector<bool> &vis, vector<int>* adj, long long &cnt)
    {
        if(vis[s]) return;
        
        vis[s] = true;
        cnt++;
        
        for(auto &w: adj[s])
            if(!vis[w])
                 dfs(w, vis, adj, cnt);
    }
    
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        vector<int> adj[n];
        
        for(auto &x: edges){
            adj[x[0]].push_back(x[1]);
            adj[x[1]].push_back(x[0]);
        }
        
        long long totalpairs = ((long long)n*(n-1))/2;
        
        vector<bool> visited(n, 0);
        for(int i=0; i<n; i++)
        {
            if(!visited[i])
            {
                long long cnt=0;
                dfs(i, visited, adj, cnt);
                totalpairs -= (cnt * (cnt-1))/2;;
            }
        }
        
        return totalpairs;
    }
	
	//    long long res = 0;
    //    for (auto i : counts) {
    //        res += (long long)i * (n-i);
    //        n -= i;
    //    }
    //    return res;
		
    /*
    long long countPairs(int n, vector<vector<int>>& edges) {
        
        // vector<vector<int>> adj(n, vector<int>(n, 0));
        vector<int> adj[n];
        
        for(auto &x: edges)
        {
            int i = x[0];
            int j = x[1];
            // adj[i][j] = adj[j][i] = 1;
            adj[i].push_back(j);
            adj[j].push_back(i);
        }
        // for(int i=0; i<n; i++)
        // {
        //     for(int j=0; j<n; j++)
        //     {
        //         cout<<adj[i][j]<<" ";
        //     }
        //     cout<<endl;
        // }
            // for(int j: adj[0])
            // {
            //     cout<<j<<" ";
            // }
        vector<bool> visited(n, 0);
        long long int pairs = n;
        pairs = (pairs*(pairs-1))/2;
        
        for(int i=0; i<n; i++)
        {
            vector<int> comp;
            long long int compPairs=0;
            if(!visited[i])
            {
                dfs(i, visited, adj, comp);
            }
            compPairs = comp.size();
            compPairs = (compPairs * (compPairs-1))/2;
            // for(int x: comp)
            //     cout<<x<<" ";
            // cout<<endl;
            pairs -= compPairs;
        }
        
        return pairs;
    }//
    
    void dfs(int s, vector<bool> &vis, vector<int>* adj, vector<int>& comp)
    {
        if(vis[s])
            return;
        
        vis[s] = true;
        comp.push_back(s);
        
        for(auto w: adj[s])
        {
            // cout<<"s"<<s<<" w"<<w<<" ";
            if(!vis[w])
            {
                
                 dfs(w, vis, adj, comp);
            }
               
        }
    }
    */
    
};