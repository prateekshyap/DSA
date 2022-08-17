/*
https://leetcode.com/problems/course-schedule-iv/
1462. Course Schedule IV

*/

class Solution {
public:
    vector<bool> checkIfPrerequisite(int numCourses, vector<vector<int>>& prerequisites, vector<vector<int>>& queries) {
        
        // vector<vector<bool>> isReachable(numCourses, vector<bool>(numCourses, false));
        vector< bitset<101> > prevs(numCourses); // all the prerequisites for each node as a bitmask
        // Topological Sorting
        queue<int> q;
        vector<int> adj[numCourses];
        vector<int> ind(numCourses, 0);
        for(auto edge: prerequisites)
        {
            adj[edge[0]].push_back(edge[1]);
            ind[edge[1]]++;
        }
        
        for(int i=0; i<numCourses; i++)
        {
            if(ind[i]==0) q.push(i);
            prevs[i].set(i, 1);
        }
        
        while(!q.empty())
        {
            int src = q.front(); q.pop();
            for(auto& dest : adj[src])
            {
                // isReachable[src][dest] = true;
                // for(int c=0; c<numCourses; c++)
                // {
                //     if(isReachable[c][src])
                //         isReachable[c][dest] = true;
                // }
                prevs[dest] |= prevs[src];
                if(--ind[dest]==0)
                    q.push(dest);
            }
        }
        
        
        vector<bool> ans;
        for(auto q: queries)
        {
            // ans.push_back(isReachable[q[0]][q[1]]);
            ans.push_back(prevs[q[1]].test(q[0])); // dest node me src node set hai ya nahi/means prerequisite hai ya nahi
        }
        
        return ans;
    }
};