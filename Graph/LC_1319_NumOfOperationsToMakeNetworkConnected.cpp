/*
1319. Number of Operations to Make Network Connected

https://leetcode.com/problems/number-of-operations-to-make-network-connected/
*/

class Solution {
public:
    vector<int> parent, rank;
    int find_set(int a)
    {
        if(parent[a] == a) return a;
        return parent[a] = find_set(parent[a]);
    }
    
    bool union_set(int a, int b)
    {
        int pa = find_set(a);
        int pb = find_set(b);
        
        if(pa == pb) return true;
        if(rank[pa]>rank[pb])
            swap(pa, pb);
        parent[pa] = pb;
        if(rank[pa] == rank[pb])
            rank[pb]++;
        return false;
    }
    
    int makeConnected(int n, vector<vector<int>>& connections) {
        int conn = connections.size();
        if(conn < n-1) return -1;
        
        parent.resize(n); 
        rank.resize(n, 0);
        
        iota(parent.begin(), parent.end(), 0);
        // for(int i=0; i<n; i++) parent[i]=i;
        
        int disconn=0;
        for(auto wire: connections){
            union_set(wire[0], wire[1]);
        }
        
        for(int i=0; i<n; i++)
        {
            if(parent[i]==i) disconn++;
        }
        
        return disconn-1;
    }
};