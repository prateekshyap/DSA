/*
Articulation Point - I
https://practice.geeksforgeeks.org/problems/articulation-point-1/1
*/

class Solution {
  public:
    int timer;
    vector<int> dtime;
    vector<int> low;
    vector<bool> visited;
    vector<bool> isArti;
    
    vector<int> articulationPoints(int V, vector<int>adj[]) {
        dtime.resize(V, 0);
        low.resize(V, 0);
        visited.resize(V, false);
        isArti.resize(V, false);
        
        timer = 0;
        // for(int v=0; v<V; v++)
        // {
            // if(dtime[v] == 0)
                dfs(0, -1, adj);
        // }
        vector<int> ans;
        for(int i=0; i<V; i++)
            if(isArti[i]) ans.push_back(i);
            
        if(ans.size()==0) return {-1}; 
        return ans;
    }
    
    void dfs(int s, int p, vector<int> adj[])
    {
        dtime[s] = low[s] = ++timer;
        visited[s] = true;
        int children = 0;
        for(auto w: adj[s])
        {
            if(w == p) continue; // same parent
            if(visited[w]== true) // w!=p and visited, that is backedge
            {  
                low[s] = min(low[s], dtime[w]);
            }
            else  // not visited, tree edge,
            {
                dfs(w, s, adj);
                children++;
                low[s] = min(low[s], low[w]);
                if(low[w] >= dtime[s] and p != -1) // not root
                    isArti[s] = true;
            }
        } 
        // root node
        if(p == -1 and children > 1)
            isArti[s] = true;
    }
};