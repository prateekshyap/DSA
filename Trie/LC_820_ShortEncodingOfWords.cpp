/*
https://leetcode.com/problems/short-encoding-of-words/
*/
class Trie{
    struct TrieNode{
        TrieNode* children[26];
        bool isEnd;
    };
    TrieNode *root;
    public:
    Trie() {
        root = new TrieNode();
    }
    void insert(string& word, bool &isSuffix)
    {
        TrieNode* ptr = root; 
        int key=0;
        for(int i=word.length()-1; i>=0; i--)
        {
            key = word[i]-'a';
            if(ptr->children[key] == nullptr)
            {
                isSuffix = false;
                ptr->children[key] = new TrieNode();
            }
            ptr = ptr->children[key];
        }
        ptr->isEnd = true;
    }
    
};

class Solution {
public:
    int minimumLengthEncoding(vector<string>& words) {
//         sort(words.begin(), words.end(), [&](string& a, string& b){return a.size()>b.size();});
//         int len=0;
//         Trie tr;
//         for(auto w: words)
//         {
//             bool isSuffix=true;
//             tr.insert(w, isSuffix);
//             if(isSuffix == false) len += w.size()+1; //+ # 
//         }
        
//         return len;
        
        unordered_set<string> s(words.begin(), words.end());
        for(string w: s)
        {
            for(int i=1; i<w.size(); i++)
                s.erase(w.substr(i));
        }
        int len=0;
        for(string w: s)
            len += w.size()+1;
        return len;
    }
};