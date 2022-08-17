/*
https://leetcode.com/problems/word-search-ii/
212. Word Search II

*/

// class Trie{
//     struct TrieNode{
//       TrieNode* children[26];
//       bool isEnd;
//       string str;
//     };
//     public:
//     int m, n;
//     TrieNode *root;

//     Trie() {
//         root = new TrieNode();
//     }

//    void insert(string& word)
//     {
//         TrieNode* ptr = root; 
//         int key=0;
//         for(char &c: word)
//         {
//             key = c-'a';
//             if(ptr->children[key] == nullptr)
//                 ptr->children[key] = new TrieNode();
//             ptr = ptr->children[key];
//         }
//         ptr->isEnd = true;
//         ptr->str = word;
//     }

//     void searchDFS(TrieNode* ptr, int i, int j, vector<vector<char>>& board)
//     {
//         if(i<0 or i>=m or j<0 or j>=n or board[i][j] == '*' ) return;

//         ptr = ptr -> children[board[i][j] - 'a'];
//         if(ptr == nullptr) return; // word nhi mila
//         if(ptr -> isEnd) // word mil gya first time
//         { 
//             Solution::ans.push_back(ptr->str);
//             ptr->isEnd = false; // next time same word na insert kr de
//         }

//         char ch = board[i][j]; // using it like a visited array
//         board[i][j] = '*';

//         searchDFS(ptr, i-1, j, board); // up
//         searchDFS(ptr, i+1, j, board); // down
//         searchDFS(ptr, i, j-1, board); // left
//         searchDFS(ptr, i, j+1, board); // right

//         board[i][j] = ch;
//     }// end search

// };

class Solution {
public:
    int m, n;
    vector<string> ans;
    vector<string> findWords(vector<vector<char>>& board, vector<string>& words) {
        m = board.size();
        n = board[0].size();
        // Trie tr; tr.m = m; tr.n = n;
        root = new TrieNode();
        for(string &w: words)
            insert(w);
        
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                searchDFS(root, i, j, board);
            }
        }
        
        return ans;
    }//
    
    struct TrieNode{
      TrieNode* children[26];
      bool isEnd;
      string str;
    };
    TrieNode *root;
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
        }
        ptr->isEnd = true;
        ptr->str = word;
    }
    
    void searchDFS(TrieNode* ptr, int i, int j, vector<vector<char>>& board)
    {
        if(i<0 or i>=m or j<0 or j>=n or board[i][j] == '*' ) return;

        ptr = ptr -> children[board[i][j] - 'a'];
        if(ptr == nullptr) return; // word nhi mila
        if(ptr -> isEnd) // word mil gya first time
        { 
            Solution::ans.push_back(ptr->str);
            ptr->isEnd = false; // next time same word na insert kr de
        }

        char ch = board[i][j]; // using it like a visited array
        board[i][j] = '*';

        if(i-1>=0)searchDFS(ptr, i-1, j, board); // up
        if(i+1<m)searchDFS(ptr, i+1, j, board); // down
        if(j-1>=0)searchDFS(ptr, i, j-1, board); // left
        if(j+1<n)searchDFS(ptr, i, j+1, board); // right

        board[i][j] = ch;
    }// end search

};