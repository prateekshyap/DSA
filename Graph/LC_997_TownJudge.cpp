/*
997. Find the Town Judge

https://leetcode.com/problems/find-the-town-judge/
*/
class Solution {
public:
    int findJudge(int n, vector<vector<int>>& trust) {
        
        int ans=-1;
        vector<pair<int,int>> degree(n+1, {0,0}); // {indegree, outdegree}
        
        for(auto edge: trust)
        {
            degree[edge[0]].second++; // outdegree increases
            degree[edge[1]].first++; // indegree increases
        }
        
        for(int i=1; i<=n; i++)
        {
            if(degree[i].first==n-1 && degree[i].second==0)
            {    ans = i;
                break;
            }
        }
        
        
        return ans;
    }// end
};