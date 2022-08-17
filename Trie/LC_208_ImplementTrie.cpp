/*
https://leetcode.com/problems/implement-trie-prefix-tree/
*/

struct TrieNode{
  struct TrieNode* childs[26];
  bool isLeaf;
    
    // TrieNode()
    // {   
    //     // childs = new TrieNode[26];
    //     this->isLeaf = false;
    // }
};

class Trie {
public:
    TrieNode* root;
    
    Trie() {
         root = new TrieNode();    // create new TrieNode and return as root;
    }
    
    void insert(string word) {
        TrieNode *ptr = root;
        for(int i=0; i<word.length(); i++)
        {
            int k = word[i]-'a';
            if(!ptr->childs[k])
                ptr->childs[k] = new TrieNode();
            ptr = ptr->childs[k];
        }
        ptr->isLeaf = true;
    }// insert
    
    bool search(string word) {
        TrieNode *ptr = root;
        for(int i=0; i<word.length(); i++)
        {
            int k = word[i]-'a';
            if(!ptr->childs[k])
                return false;
            ptr = ptr->childs[k];
        }
        return ptr->isLeaf; 
    }
    
    bool startsWith(string prefix) {
         TrieNode *ptr = root;
        int i=0;
        for( i=0; i<prefix.length(); i++)
        {
            int k = prefix[i]-'a';
            if(!ptr->childs[k])
                return false;
            ptr = ptr->childs[k];
        }
        if(i==prefix.length())
                return true;
        return false; 
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */