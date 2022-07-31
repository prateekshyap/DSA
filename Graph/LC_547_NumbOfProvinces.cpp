/*
https://leetcode.com/problems/number-of-provinces/
547. Number of Provinces

*/

class Solution {
public:
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
    
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        int provinces=0;
        
        parent = vector<int>(n, 0);
        rank = vector<int>(n, 0);
        for(int i=0; i<n; i++) parent[i] = i;
        
        for(int i=0; i<n; i++)
        {
            for(int j=i; j<n; j++)
            {
                if(isConnected[i][j])
                {
                    union_set(i, j);
                }
            }
        }
        
        // for(int i=0; i<n; i++)
        //     cout<<parent[i]<<" ";
        for(int i=0; i<n; i++)
            if(parent[i]==i) provinces++;
        
        /* Find through DFS
        visited.resize(n, false);
        for(int i=0; i<n; i++)
        {
            if(visited[i] == false)
            {
                provinces++;
                findDFS(i, isConnected);
            }
        }
        */
        
        return provinces;
    }
    
    vector<bool> visited;
    void findDFS(int s, vector<vector<int>>& isConnected)
    {
        // if(s>=isConnected.size() or visited[s]) return;
        visited[s] = true;
        for(int i=0; i<isConnected.size(); i++)
        {
            if(isConnected[s][i]==1 and visited[i]==0)
                findDFS(i, isConnected);
        }
    }
};