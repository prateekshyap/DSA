/*
https://practice.geeksforgeeks.org/problems/union-find/1
Union-Find
*/
class Solution
{
    public:
    int find_set(int x, int parent[])
    {
        if(parent[x] == x) return x;
        return parent[x] = find_set(parent[x], parent);
    }
    //Function to merge two nodes a and b.
    void union_( int a, int b, int par[], int rank1[]) 
    {
        int pa = find_set(a, par);
        int pb = find_set(b, par);
        if(pa == pb) return;
        if(rank1[pa] > rank1[pb])
            swap(pa, pb);
        par[pa] = pb;
        rank1[pb] += rank1[pa];
    }
    
    //Function to check whether 2 nodes are connected or not.
    bool isConnected(int x,int y, int par[], int rank1[])
    {
        int px = find_set(x, par);
        int py = find_set(y, par);
        if(px == py) return true;
        return false;
    }
};