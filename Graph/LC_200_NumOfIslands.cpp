/*
200. Number of Islands

https://leetcode.com/problems/number-of-islands/
*/

class Solution {
public:
    vector<pair<int,int>> dirs = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    int m, n;
    int numIslands(vector<vector<char>>& grid) {
        m = grid.size();
        n = grid[0].size();
        int cnt_islands=0;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n;j++)
            {
                if(grid[i][j] == '1')
                {
                    cnt_islands++;
                    // bfs_helper(i, j, grid);
                    dfs_helper(i, j, grid);
                }
            }
        }
        
        return cnt_islands;
    }
    
    void dfs_helper(int x, int y, vector<vector<char>>& grid)
    {
        for(auto [dx, dy] : dirs)
        {
            dx = x + dx;
            dy = y + dy;
            if(dx<0 or dx>=m or dy<0 or dy>=n or grid[dx][dy] != '1') continue;
            grid[dx][dy] = '2';
            dfs_helper(dx, dy, grid);
        }
    }
    
    void bfs_helper(int i, int j, vector<vector<char>>& grid)
    {
        grid[i][j] = '2';
        queue<pair<int,int>> q; q.push({i,j});
        while(!q.empty())
        {
            auto [x, y] = q.front();q.pop() ;
            for(auto [dx, dy] : dirs)
            {
                dx = x + dx;
                dy = y + dy;
                if(dx<0 or dx>=m or dy<0 or dy>=n or grid[dx][dy] != '1') continue;
                grid[dx][dy] = '2';
                q.push({dx,dy});
            }
        }
        return;
    }
};