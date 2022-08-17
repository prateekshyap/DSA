/*
980. Unique Paths III

https://leetcode.com/problems/unique-paths-iii/
*/

class Solution {
public:
    int m, n;
    int sx,sy, ex,ey; //start and end point
    int uniquePathsIII(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size(); 
        int nonobs=0;
        if(m==1 and n==1) return 0;
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                switch(grid[i][j])
                {
                    case 1: sx = i; sy = j;
                        break;
                    case 2: ex = i; ey = j; nonobs++;
                        break;
                    case 0:  nonobs++;
                        break;
                }
            }
        }// for
        // cout<<sx<<" "<<sy<<" "<<nonobs<<endl;
        return solve(sx, sy, nonobs, grid);
    }
    
    // vector<pair<int,int>> path;
    vector<pair<int,int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int solve(int i, int j, int nonobs, vector<vector<int>>& grid)
    {
        // out of bounds, obstacle or visited 
        if(i<0 or j<0 or i>=m or j>=n or grid[i][j] == -1 or grid[i][j] == 3)
            return 0;
        
        if(grid[i][j] == 2)// reach end
        {
            // if(nonobs==0) myprint(path);
            return nonobs==0 ? 1 : 0; // reach end with one nonobs remaining
        }
        
        int prev = grid[i][j];
        grid[i][j] = 3;
        
        int cnt=0;
        for(auto d: dirs)
        {
            // path.push_back({i+d.first, j+d.second});
            cnt+= solve( i+d.first, j+d.second, nonobs-1, grid);
            // path.pop_back();
        }
        
        grid[i][j] =prev;        
        return cnt;
    }
    
    // void myprint(vector<pair<int,int>>& vec)
    // {
    //     for(auto [i, j]: vec)
    //         cout<<"("<<i<<" "<<j<<") "; cout<<endl;
    // }
};