/*
https://leetcode.com/problems/course-schedule-ii/
210. Course Schedule II

*/

class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<int> ans;
        queue<int> q;
        vector<int> ind(numCourses,0); // indegree
        vector<int> adj[numCourses];  // adjacency list
        
         for(const auto& p: prerequisites){
             adj[p[1]].push_back(p[0]);
             ind[p[0]]++;
         }
        
        
        for(int i=0; i<numCourses; i++)
        {
            if(ind[i]==0)
                q.push(i);
        }
        
        while(!q.empty())
        {
            int e = q.front(); q.pop();
            ans.push_back(e);
            for(const auto& x: adj[e] )
            {
                if(--ind[x] == 0)
                    q.push(x);
            }
        }
        
        if(ans.size() == numCourses)
            return ans;
        else
            return {};
    
    }
};