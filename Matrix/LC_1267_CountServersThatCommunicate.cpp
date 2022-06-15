/*
https://leetcode.com/problems/count-servers-that-communicate/
1267. Count Servers that Communicate

*/
class Solution {
public:
    //Using Hashing for row and column
    int countServers(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        
        vector<int> row(m,0), col(n,0);
        // int row[m]={0};
        // int col[n]={0};
        
        int servers=0;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==1)
                {
                    row[i]++;
                    col[j]++;
                }
            }
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] && (row[i]>1 || col[j]>1))
                {
                    servers++;
                }
            }
                     
        return servers;
    }//end
    
    //Using DFS/BFS
    int countServers_(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        
        vector<int> row(m,0), col(n,0);
        
        int servers=0, count=0;
        
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
            {
                if(grid[i][j]==1)
                {
                    // count = dfs(i,j, grid);
                    count = bfs(i,j, grid);
                    servers += count>1? count: 0;
                }
            }
        
                     
        return servers;
    }//end
    
    int dfs(int r, int c, vector<vector<int>>& g)
    {
        int cnt=1;
        g[r][c]=0; 
        
        for(int i=0; i<g.size(); i++)
            if(g[i][c])
                cnt+= dfs(i,c,g);
        
        for(int j=0; j<g[0].size(); j++)
            if(g[r][j])
                cnt+= dfs(r,j,g);
        
        return cnt;
    }
    
    int bfs(int r, int c, vector<vector<int>>& g)
    {
        int cnt=0;
        queue<pair<int,int>> q;
        q.push({r,c});
        g[r][c]=0; 
        
        while(!q.empty())
        {
            cnt++;
            auto [x,y] = q.front(); q.pop();
            
            for(int i=0; i<g.size(); i++)
                if(g[i][y])
                {
                    g[i][y]=0;
                    q.push({i,y});
                }
                    

            for(int j=0; j<g[0].size(); j++)
                if(g[x][j])
                {
                    g[x][j]=0;
                    q.push({x,j});
                }
        }
        
        return cnt;
    }
};