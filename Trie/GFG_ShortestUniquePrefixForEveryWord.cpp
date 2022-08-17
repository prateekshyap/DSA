/*
Shortest Unique prefix for every word
https://practice.geeksforgeeks.org/problems/shortest-unique-prefix-for-every-word/0
*/

class Trie{
    
    struct TrieNode{
        TrieNode* children[26];
        int cnt=0;
        bool isEnd;
    };
    
    TrieNode *root;
    public:
    Trie() {
        root = new TrieNode();
    }
    void insert(string& word)
    {
        TrieNode* ptr = root; 
        int key=0;
        for(char &c: word)
        {
            key = c-'a';
            if(ptr->children[key] == nullptr)
                ptr->children[key] = new TrieNode();
            ptr = ptr->children[key];
            ptr->cnt++;
        }
        root->isEnd = true;
    }
	string searchPrefix(string& word) 
    {
        TrieNode *ptr = root;
        int key=0;
        string pre="";
        for(char &c: word)
        {
            pre+=c;
            key = c-'a';
            ptr = ptr->children[key];
            if(ptr->cnt == 1)
                return pre;
        }
        return (pre);
    }// end search
};

class Solution
{
    public:
    vector<string> findPrefixes(string arr[], int n)
    {
        Trie tr;
        for(int i=0; i<n; i++)
        {
            tr.insert(arr[i]); 
        }
        vector<string> ans(n);
        for(int i=0; i<n; i++)
        {
            ans[i] = tr.searchPrefix(arr[i]);
        }
        return ans;
    }//
    
};