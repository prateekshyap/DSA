/*
Circle of strings
https://practice.geeksforgeeks.org/problems/circle-of-strings4530/1
*/

class Solution
{
    vector<bool> visited ;
    vector<int> adj[26];
    public:
    int isCircle(int n, vector<string> words)
    {   
        visited.resize(26,false);
        vector<int> in(26,0), out(26, 0);
        
        for(string &w: words)
        {
            char f = w[0]-'a';
            char l = w.back() - 'a';
            in[l]++;
            out[f]++;
            adj[f].push_back(l);
        }
        
        for(int i=0; i<26; i++)
            if(in[i] != out[i])
                return 0;
        
        dfs(words[0].front() - 'a');
        
        for(int i=0; i<26; i++)
        {
            if(visited[i]==false and out[i])
                return false;
        }
        
        return 1;
    }
    
    
    void dfs(int s)
    {
        visited[s] = true;
        for(int &w: adj[s])
        {
            if(visited[w] == false)
                dfs(w);
        }
    }
};

class Solution
{
    int find_set(int x)
    {
        if(parent[x] == x) return x;
        return parent[x] = find_set(parent[x]);
    }
    
    bool union_set(int a, int b)
    {
        int pa = find_set(a);
        int pb = find_set(b);
        if(pa == pb) return true;
        if(rank[pa] > rank[pb])
            swap(pa, pb);
        parent[pa] = pb;
        if(rank[pa] == rank[pb])
            rank[pb]++;
    }
    
    vector<int> parent, rank;
    public:
    int isCircle(int n, vector<string> words)
    {
        parent.resize(26);
        rank.resize(26);
        for(int i=0; i<26; i++)
            parent[i] = i;
            
        vector<int> in(26,0), out(26, 0);
        for(string &w: words)
        {
            char f = w[0]-'a';
            char l = w.back() - 'a';
            in[l]++;
            out[f]++;
            union_set(f, l);
        }
        
        int comp=0;
        for(int i=0; i<26; i++)
        {
            if(out[i] and parent[i] == i) comp++; 
            if(in[i] != out[i] or comp>1)
                return 0;
        }
        return 1;
    }
};