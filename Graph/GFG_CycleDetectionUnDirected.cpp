/* https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1#
 * Given an undirected graph with V vertices and E edges, check whether it contains any cycle or not.
 */

// } Driver Code Ends
class Solution {
public:
    // Function to detect cycle in an undirected graph.
    bool isCycle(int V, vector<int> adj[]) {

        vector<bool> visited(V,false);

        for(int v=0; v<V; ++v){ //for disconnected graph
            if(!visited[v]){
                // if(DFS_CD(v, -1, adj, visited))   //USING DFS
                //     return true;
                if(BFS_CD(v, adj, V))    //USING BFS
                    return true;

            }//if vis
        }//for v

        return false; // cycle not detected
    }//isCycle

    bool DFS_CD(int src, int par, vector<int> adj[], vector<bool> &vis){

        vis[src]=true;

        for(int w: adj[src]){

            if(!vis[w]){
                if(DFS_CD(w, src, adj, vis))
                    return true;

            }//vis if
            else if(w != par)  //third vertex
                return true;

        }//for adj
        return false;
    }//DFS

    bool BFS_CD(int src, vector<int> adj[], int V){

        vector<bool> vis(V, false);
        vector<int> par(V,-1);          // parent of node
        queue<int> q;

        q.push(src);
        vis[src]=true;

        while(!q.empty()){
            int x = q.front(); q.pop();

            for(int w: adj[x]){
                if(!vis[w])
                {
                    vis[w]=true;
                    q.push(w);
                    par[w]=x;
                }
                else if(w!=par[x]) return true;
            }// for w
        }// while q
        return false;
    }//BFS_CD

};
 
class Solution {
  public:
    
    vector<int> parent, rank, visited;
    // Function to detect cycle in an undirected graph.
    bool isCycle(int V, vector<int> adj[]) {
        parent = vector<int>(V);
        rank = vector<int>(V, 0);
        visited = vector<int>(V, false);
        for(int i=0; i<V; i++)
            parent[i] = i;
        
        for(int i=0; i<V; i++)
        {
            visited[i] = true;
            for(int w: adj[i])
            {
                if(visited[w]) continue;
                
                if(union_set(i, w))
                    return true;
            }
        }
           
        return false;    
    }//end
    
    bool union_set(int x, int y)
    {
        int px = find_set(x);
        int py = find_set(y);
        
        if(px == py) return true; 
        if(rank[px] > rank[py])
            swap(px, py);
        parent[px] = py;
        if(rank[px] == rank[py])
            rank[py]++;
        return false;
    }
    
    int find_set(int x)
    {
        if(parent[x] == x) return x;
        return parent[x] = find_set(parent[x]);
    }
};