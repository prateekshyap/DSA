/*
684. Redundant Connection
https://leetcode.com/problems/redundant-connection/
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
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
        vector<int> ans;
        int n=edges.size();
        parent.resize(n, 0); rank.resize(n, 0);
        for(int i=0; i<n; i++)
            parent[i] = i;
        
        for(auto x: edges)
        {   
            int u = x[0]-1, v = x[1]-1;
            if(union_set(u, v))
            {
                ans = {u+1,v+1};
            }
        }
        
        return ans;
    }
};