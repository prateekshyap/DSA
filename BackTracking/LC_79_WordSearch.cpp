/*
79. Word Search

https://leetcode.com/problems/word-search/
*/

class Solution {
public:
    int m, n;
    // vector<vector<bool>> vis;
    // string w;
    // vector<vector<char>>  board;
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        n = board[0].size();
        // w = word;
        // this->board = board;
        // vis.resize(m, vector<bool>(n, false));
        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(word[0] == board[i][j])
                {   
                    // cout<<i<<" "<<j<<endl;
                    if(solve2(0, i, j, board, word)) return true;
                }
                // if(milgya) return true;
            }
        }
        return false;
    }
    
    bool solve2(int idx, int i, int j, vector<vector<char>>& board, string& word)
    {
        if(idx == word.size())
            return true;
        if(i<0 or i>=m or j<0 or j>=n or board[i][j] != word[idx] ) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        
        // down, up, left, right
        bool ans = solve2(idx+1, i+1, j, board, word)
            or
            solve2(idx+1, i-1, j, board, word)
            or
            solve2(idx+1, i, j-1, board, word)
            or
            solve2(idx+1, i, j+1, board, word);
             
        board[i][j] = temp;
        return ans;
    }
    
    // left right, up down
    // vector<pair<int,int>> dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; 
    // bool solve(int idx, int i, int j)
    // {
    //     if(idx == w.size())
    //         return true;    
    //       // cout<<idx<<" "<<w[idx]<<" "<<i<<" "<<j<<endl;
    //     for(auto [x, y] : dirs)
    //     {
    //         x = i + x;
    //         y = j + y;
    //         if(x>=m or x<0 or y>=n  or y<0 or vis[x][y] or board[x][y] != w[idx]) continue;
    //         vis[i][j] = true;
    //         if(solve(idx+1, x, y))  return true;
    //         vis[i][j] = false;
    //     }
    //     return false;
    // }
};