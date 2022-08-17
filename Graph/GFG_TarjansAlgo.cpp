/*
https://practice.geeksforgeeks.org/problems/strongly-connected-component-tarjanss-algo-1587115621/1/#
Strongly connected component (Tarjans's Algo) 
*/
 
class Solution
{
	public:
    //Function to return a list of lists of integers denoting the members 
    //of strongly connected components in the given graph.
    
   //for DFS
    int dfs_number;
    vector<int> dfs_st; // DFS node start time // discovery time
    // vector<int> dfs_et; // DFS node end time
    vector<int> lowlink; // DFS node low(v) number
    
    vector<bool> dfs_rec; // node is in recursion stack or not
    // vector<bool> dfs_vis; //visited array for nodes
    stack<int> st;
    
    vector<vector<int>> scc; // strongly connected components
    
    vector<vector<int>> tarjans(int V, vector<int> adj[])
    {
        dfs_st.assign(V,0);
        // dfs_et.assign(V,0);
        lowlink.assign(V,0);
        dfs_rec.assign(V,false);
        // dfs_vis.assign(V,false);
        
        dfs_number = 0;
        for(int v=0; v<V; v++)
        {
            if(dfs_st[v] == 0)
                DFSRec(v, adj);
        }
        sort(scc.begin(), scc.end());
        return scc;
    }
    
    void DFSRec(int s, vector<int> adj[])
    {
        ++dfs_number;
        dfs_st[s] = dfs_number;
        lowlink[s] = dfs_number;
        
        st.push(s);
        dfs_rec[s] = true;
        // dfs_vis[s] = true;
        
        for(auto w: adj[s])
        {
            if(dfs_st[w]==0) // w not visited yet 
            { //Tree Edge
                DFSRec(w, adj);
                lowlink[s] = min(lowlink[s], lowlink[w]);
            }
            else if(dfs_rec[w] == true) //back edge/crossedge
            {
                lowlink[s] = min(lowlink[s], dfs_st[w]);
            }
        }
        
        // ++dfs_number;
        // // dfs_et[s] = dfs_number;
        
        int se; //stack element;
        if(lowlink[s] == dfs_st[s]) //base vertex
        {
            vector<int> comp;
            while(st.top() != s)
            {
                se = st.top(); st.pop();
                dfs_rec[se] = false;
                comp.push_back(se);
            }
            se = st.top(); st.pop();
            dfs_rec[se] = false;
            comp.push_back(se);
            sort(comp.begin(), comp.end());
            scc.push_back(comp);
        }
        // dfs_rec[s] = false;
    }
};
 