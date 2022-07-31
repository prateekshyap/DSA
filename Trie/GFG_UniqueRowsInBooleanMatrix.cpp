/*
https://practice.geeksforgeeks.org/problems/unique-rows-in-boolean-matrix/1
Unique rows in boolean matrix
*/

struct TrieNode{
    TrieNode* children[2];
    bool isEnd;
}*root;
vector<vector<int>> ans;
int coln; 

void insertIntoTrie(int mat[MAX])
{
    TrieNode* ptr = root;
    for(int c=0; c<coln; c++)
    {
        int ele = mat[c];
        if(ptr->children[ele] == nullptr)
            ptr->children[ele] = new TrieNode();
        ptr = ptr->children[ele];
    }
    if(ptr->isEnd == false)
    {
        ptr->isEnd = true;
        ans.push_back(vector<int>(mat, mat+coln));
    }
}
/*You are required to complete this function*/
vector<vector<int>> uniqueRow(int M[MAX][MAX],int row,int col)
{
    coln = col;
    root = new TrieNode();
    ans.clear();
    
    for(int r=0; r<row; r++)
        insertIntoTrie(M[r]);
        
    return ans;
}

// Approach 2
/*You are required to complete this function*/
vector<vector<int>> uniqueRow(int M[MAX][MAX],int row,int col)
{
    vector<vector<int>> ans;
    set<vector<int>> s;
    for(int r=0; r<row; r++)
    {
        vector<int> v(M[r], M[r] + col);
        if(s.find(v) == s.end())
        {
            ans.push_back(v);
            s.insert(v);
        }
    }
    return ans;
}