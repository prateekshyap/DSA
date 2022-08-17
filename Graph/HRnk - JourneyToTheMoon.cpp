/*
Journey To the Moon Problem
https://www.hackerrank.com/challenges/journey-to-the-moon/problem
*/

vector<int> size;
 vector<int> parent;
 int find_set(int x) {
     if(parent[x]==x) return x;
     return parent[x] = find_set(parent[x]);
 }
 
 bool union_set(int a, int b)
 {
    int pa = find_set(a);
    int pb = find_set(b);
    if(pa == pb) return true;    
    if(size[pa] > size[pb])
        swap(pa, pb);
    parent[pa] = pb;
    size[pb] += size[pa];
    return false;
 }
 
 long journeyToMoon(int n, vector<vector<int>> astronaut) {  
    //  return journeyToMoonDFS(n, astronaut);
    parent.resize(n);
    size.resize(n,1);
    long ans=n;
    for(int i=0; i<n; i++)
        parent[i] = i;
    
    for(auto &edge: astronaut)
    { 
        union_set(edge[0],edge[1]);
    }
    unordered_map<int, int> hash;
    for(int i=0; i<n; i++)
    {
        if(parent[i] == i)
            hash[i] = size[i];
        // cout<<i<<" "<<parent[i]<<" "<<size[i]<<endl;
    }
    
    ans = ans*(ans-1)/2;
    for(auto &x: hash)
    {
        long cnt = x.second;
        ans -= (cnt*(cnt-1))/2;
    }
    
    return ans;
 }
 /*
void dfs(int, vector<int>&);
vector<vector<int>> scc;
vector<bool> visited;
vector<vector<int>> adj;
long journeyToMoonDFS(int n, vector<vector<int>>& astronaut) {  
    adj.resize(n);
    for(auto &edge: astronaut)
    {
        int u=edge[0], v=edge[1];
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    
    visited.resize(n, false);
    for(int i=0; i<n; i++)
    {
        if(visited[i] == false)
        {
            vector<int> comp;
            dfs(i, comp);
            scc.push_back(comp);
        }            
    }
    
    long ans=0;
    long numOfComp = scc.size();
    long prev = 0;
    for(auto i=0; i<numOfComp; i++)
    {  
        // prev+=scc[i].size();
        // ans+= (long)scc[i].size()*(n-prev); 
        
        ans+= (long)scc[i].size()*(prev); 
        prev+=scc[i].size();
    }
    return ans;
}

void dfs(int s, vector<int>& comp)
{
    comp.push_back(s);
    visited[s] = true;
    for(auto &w: adj[s])
    {
        if(visited[w] ==false)
            dfs(w, comp);
    }
}
*/