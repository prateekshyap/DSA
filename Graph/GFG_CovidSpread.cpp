/*
Covid Spread
https://practice.geeksforgeeks.org/problems/269f61832b146dd5e6d89b4ca18cbd2a2654ebbe/1
*/

class Solution {
public:
    int m, n;
    int helpaterp(vector<vector<int>> hospital)
    {
        m=hospital.size(); n=hospital[0].size();
        int timer=0;
        int uninfected=0;
        queue<pair<int,int>> q;
        vector<pair<int,int>> dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(hospital[i][j] == 2)
                    q.push({i,j});
                else if(hospital[i][j] == 1)
                    uninfected++;
            }
        }
        
        // cout<<uninfected<<" "<<endl;
        
        while(!q.empty())
        {
            int sz = q.size();
            while(sz--)
            {
                auto p = q.front(); q.pop();  
                for(auto d: dirs)
                {
                    int x = p.first+d.first, y = p.second+d.second;
                    if(x<0 or y<0 or x>=m or y>=n or hospital[x][y] != 1) continue;
                    hospital[x][y] = 2;
                    uninfected--;
                    q.push({x,y});
                }
            }
            
            timer++;
        }
        
        if(uninfected != 0) return -1;
        
        return timer-1;
    }
};