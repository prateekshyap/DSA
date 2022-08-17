/*
211. Design Add and Search Words Data Structure

https://leetcode.com/problems/design-add-and-search-words-data-structure/
*/

// /*
class WordDictionary {
    
    struct TrieNode{
      TrieNode* children[26];
      bool isEnd; 
    }; 
    TrieNode *root; 
    
public:  
    WordDictionary() {
        root = new TrieNode();
    }
    
    void addWord(string word) { 
        TrieNode* ptr = root; 
        int key=0;
        for(char &c: word)
        {
            key = c-'a';
            if(ptr->children[key] == nullptr)
                ptr->children[key] = new TrieNode();
            ptr = ptr->children[key];
        }
        ptr->isEnd = true; 
    }
    
    bool TrieSearch(int i, TrieNode* ptr, string& word)
    {
        // cout<<i<<" "<<word<<endl;
        if(i == word.length()){
            return ptr->isEnd;
        }
        int key=0; 
        if(word[i] != '.')
        {
            for(int j=i; j<word.size(); j++)
            {
                key = word[j]-'a';
                if(ptr->children[key] == nullptr) 
                    return false;
                else 
                {
                    ptr = ptr->children[key];
                }
                if(j+1<word.size() and word[j+1] == '.')
                    return TrieSearch(j+1, ptr, word);
            } 
            return ptr->isEnd;
        }
        else{
            for(int j=0; j<26; j++)
            {
                if(ptr->children[j])
                {
                    if(TrieSearch(i+1, ptr->children[j], word))
                        return true;
                }
            }
        }  
        return false;
    }
    
    bool search(string word) {
        return TrieSearch(0, root, word);
    }
};

// */
/* // Approach 2
class WordDictionary {
public:
    array<unordered_set<string>, 26> dict;
    WordDictionary() {
        
    }
    
    void addWord(string word) {
        dict[word.size()].insert(word);
    }
    
    bool search(string word) {
        if(word.find('.') == string::npos)
            return dict[word.size()].count(word);
        
        for(auto& d: dict[word.size()])
        {
            bool match = true;
            for(int i=0; i<word.size(); i++)
            {
                if(word[i] != '.' and d[i]!=word[i])
                {
                    match=false; break;
                }
            }
            if(match) return true;
        }
        return false;
    }
};
*/
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary* obj = new WordDictionary();
 * obj->addWord(word);
 * bool param_2 = obj->search(word);
 */