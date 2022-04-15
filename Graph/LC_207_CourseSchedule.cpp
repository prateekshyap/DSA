/*
	https://leetcode.com/problems/course-schedule/
	207. Course Schedule
*/
class Solution {
public:
    
        // DFS Cycle Detection
     bool canFinishDFS(int numCourses, vector<vector<int>>& prerequisites) {
         
         // make adjacency list from the dependency given
         vector<int> adj[numCourses+1]; 
         for(auto x: prerequisites){
             adj[x[1]].push_back(x[0]);
         }
         
         vector<int> visited(numCourses, false);
         vector<int> rec_stack(numCourses, false);
         
         for(int v=0; v<numCourses; v++)
         {
             if(!visited[v])
             {
                 if(DFS_CD_Rec(v,adj, visited, rec_stack)) // cycle detected
                     return false;
             }
         }

         return true;
     }// end
    
    
    bool DFS_CD_Rec(int src, vector<int> adj[], vector<int> &vis, vector<int> & rs)
    {
        vis[src] = true;
        rs[src] = true;
            
            for(int w: adj[src])
            {
                if(!vis[w] && DFS_CD_Rec(w, adj, vis, rs)) return true;
                else if(rs[w]) return true;
            }
        
        rs[src] = false;
        return false;
    }// DFS_CD_Rec
    
    // USING Topological sort
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        
        queue<int> q;
        vector<int> ind(numCourses,0); // indegree
        vector<int> adj[numCourses+1];  // adjacency list
        
         for(const auto& p: prerequisites){
             adj[p[1]].push_back(p[0]);
             ind[p[0]]++;
         }
        
        
        for(int i=0; i<numCourses; i++)
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
        
        return cnt == numCourses;
        
    } // end
};