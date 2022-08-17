/*
https://leetcode.com/problems/stream-of-characters/
*/
class Trie{
    struct TrieNode{
        TrieNode* children[26];
        bool isEnd;
    };
    
    TrieNode *root;
    int maxlen=0;
    public:
    Trie() {
        root = new TrieNode();
    }
    void insert(string& word)
    {
        TrieNode* ptr = root; 
        int key=0;
        // for(char &c: word)
        for(int i=word.length()-1; i>=0; i--)
        {
            key = word[i]-'a';
            if(ptr->children[key] == nullptr)
                ptr->children[key] = new TrieNode();
            ptr = ptr->children[key];
        }
        ptr->isEnd = true;
        maxlen = max(maxlen, int(word.length()));
    }
    
	// bool search(deque<char> & dq) 
    bool search(string& word)
    {
        int key=0;
        TrieNode* ptr = root;
        // for(char &ch: dq)
        int curlen = maxlen;
        for(int i=word.length()-1; i>=0 and curlen; i--, curlen--)
        {
            key = word[i]-'a';
            if(ptr->children[key] == nullptr)
                return false;
            ptr = ptr->children[key];
            if(ptr->isEnd) return true;
        }
        return (false);
    }// end search
};
class StreamChecker {
    Trie tr;
    deque<char> stream;
    
public:
    StreamChecker(vector<string>& words) {
        for(string&s : words)
        {
            // reverse(s.begin(), s.end());
            tr.insert(s);
        }
    }
    
    string str;
    bool query(char letter) {
        // stream.push_front(letter);
        str += letter;
        return tr.search(str);
    }
};

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker* obj = new StreamChecker(words);
 * bool param_1 = obj->query(letter);
 */