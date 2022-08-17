/*
https://practice.geeksforgeeks.org/problems/bipartite-graph/1
https://leetcode.com/problems/is-graph-bipartite/
*/

class Solution {
public:
    vector<int> color;
    bool isBipartite(vector<vector<int>>& graph) {
        int V = graph.size();
        color.resize(V, -1); 
	    for(int i=0; i<V; i++)
	    {
	        if(color[i] == -1)
	        {
	            color[i] = 0; 
	            if(dfs(i, graph) == false) 
	                return false;
	        }
	    }
	    
	    return true;
    }
    
    bool dfs(int s, vector<vector<int>>& graph)
	{
	    for(auto &w: graph[s])
	    {
	        if(color[w] == -1)
	        {
	            color[w] = 1-color[s];
	            if(dfs(w, graph) == false)
	                return false;
	        }
	        else {
	            if(color[s] == color[w])
	                return false;
	        }
	    }
	    return true;
	}
	
};