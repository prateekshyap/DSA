/*
Prerequisite Tasks
https://practice.geeksforgeeks.org/problems/prerequisite-tasks/1
*/

class Solution {
public:
	bool isPossible(int N, vector<pair<int, int> >& prerequisites) {
	    queue<int> q;
        vector<int> ind(N,0); // indegree
        vector<int> adj[N];  // adjacency list
        
         for(const auto& p: prerequisites){
             adj[p.second].push_back(p.first);
             ind[p.first]++;
         }
        
        
        for(int i=0; i<N; i++)
        {
            if(ind[i]==0)
                q.push(i);
        }
        
        int cnt=0;
        
        while(!q.empty())
        {
            int e = q.front(); q.pop();
            
            cnt++;
            for(const auto& x: adj[e] )
            {
                
                if(--ind[x] == 0)
                    q.push(x);
                   
            }
        }
        
        return cnt == N;
	}
};