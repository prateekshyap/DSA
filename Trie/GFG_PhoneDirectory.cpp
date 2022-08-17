/*
https://practice.geeksforgeeks.org/problems/phone-directory4628/1
Phone directory
*/

class Trie{
    struct TrieNode{
        TrieNode* children[26];
        vector<int> indexes;
        bool isEnd;
    };
    
    TrieNode *root;
    public:
    Trie() {
        root = new TrieNode();
    }
    void insert(string& word, int index)
    {
        TrieNode* ptr = root; 
        int key=0;
        for(char &c: word)
        {
            key = c-'a';
            if(ptr->children[key] == nullptr)
                ptr->children[key] = new TrieNode();
            ptr = ptr->children[key];
            ptr->indexes.push_back(index);
        }
        root->isEnd = true;
    }
	vector<vector<string>> searchContacts(string& word, string contact[]) 
    {
        vector<vector<string>> ans;
        TrieNode *ptr = root;
        int key=0;
        int i=0;
        for(i=0; i<word.length(); i++)
        {
            key = word[i]-'a';
            if(ptr->children[key] == nullptr) break;
            ptr = ptr->children[key];
            vector<string> cur;
            for(auto ids: ptr->indexes)
                cur.push_back(contact[ids]);
            ans.push_back(cur);
        }
        while(i++ < word.length())
            ans.push_back({"0"});
        return (ans);
    }// end search
};

class Solution{
public:
    vector<vector<string>> displayContacts(int n, string contact[], string s)
    {
        Trie tr;
        sort(contact, contact+n); // for lexicographical increasing order
        unordered_set<string> us; // to remove duplicates
        for(int i=0; i<n; i++)
        {
            if(us.find(contact[i]) == us.end())
            {
                us.insert(contact[i]);
                tr.insert(contact[i], i);
            }
        }
        return tr.searchContacts(s, contact);
    }
};