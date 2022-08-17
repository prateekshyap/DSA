/*
994. Rotting Oranges
https://leetcode.com/problems/rotting-oranges/
https://practice.geeksforgeeks.org/problems/rotten-oranges2536/1
*/
class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int minutes = 0;
        int freshO = 0; // fresh Oranges
        queue<pair<int,int>> q;
        vector<pair<int,int>> directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(grid[i][j] == 1)
                    freshO++; // count number of fresh oranges
                else if(grid[i][j]==2)
                    q.push({i,j}); // add rotten oragne index to queue.
            }
        }
        
        if(freshO==0) return minutes; // return 0; no fresh oranges at minute 0
        
        
        while(!q.empty())
        {
            int q_size = q.size();
            while(q_size--)
            {
                pair<int,int> org = q.front(); q.pop();
                
                for(auto [x,y]: directions)
                {
                    x = x+org.first;
                    y = y+org.second;
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1)
                    {
                        grid[x][y] = 2; // rot it
                        freshO--; // decrease number of Fresh Orange
                        q.push({x,y});
                    }
                }
            }
            minutes++;
            
            if(freshO == 0)
                return minutes;
        }
        
        return -1;
    }// end;
};