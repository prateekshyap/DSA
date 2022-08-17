/*
Steps by Knight
https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1
*/

class Solution 
{ 
    vector<pair<int,int>> dirs = {
        {-2,1}, {-1,2}, {1,2}, {2,1},
        {-2,-1}, {-1,-2}, {1,-2}, {2,-1}
    };
    public:
    //Function to find out minimum steps Knight needs to reach target position.
	int minStepToReachTarget(vector<int>&KnightPos,vector<int>&TargetPos,int N)
	{ 
	    if(KnightPos[0] == TargetPos[0] and KnightPos[1] == TargetPos[1]) return 0;
	    
	    vector<vector<bool>>vis (N, vector<bool>(N, false));
	    queue<pair<int,int>> q; q.push({KnightPos[0]-1, KnightPos[1]-1});
	    vis[KnightPos[0]-1][KnightPos[1]-1] = true;
	    int ans=0;
	    while(!q.empty())
	    {
	        int sz = q.size();
            ans++;
	        while(sz--)
	        {
	            auto k = q.front(); q.pop();  
	            for(auto d: dirs)
	            {
	                int x = d.first + k.first;
	                int y = d.second + k.second;
	                if(x<0 or y<0 or x>=N or y>=N or vis[x][y]) continue;
	                vis[x][y] =true;
	                if(x == TargetPos[0]-1 and y == TargetPos[1]-1) return ans;
	                q.push({x, y});
	            }
	        } 
	    }
	    return -1;
	}
};