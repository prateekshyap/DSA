/*
https://leetcode.com/problems/parallel-courses-iii/
2050. Parallel Courses III

*/

class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        int semesters=0;
        queue<int> q;
        vector<int> ind(n,0); // indegree
        vector<int> adj[n];  // adjacency list

        vector<int> endtime(n, 0);
        
        for(const auto& c: relations){
            adj[c[0]-1].push_back(c[1]-1); // numbered 1 to N
            ind[c[1]-1]++;
        }
        
        for(int i=0; i<n; i++) {
            if(ind[i]==0)
            {    
                q.push(i); 
                endtime[i] = time[i];
            }
        }
        
        while(!q.empty())
        {
            int src = q.front(); q.pop();
            
            for(auto dest: adj[src])
            {
                endtime[dest] = max(endtime[dest], endtime[src]+time[dest]);
                if(--ind[dest] == 0)
                    q.push(dest);
            }
            
        }
        // for(int i=0; i<n; i++)
        //     cout<<i+1<<" "<<endtime[i]<<"| ";
        // cout<<endl;
        return *max_element(endtime.begin(), endtime.end());
        
    }
};