/*
https://leetcode.com/problems/n-queens/
51. N-Queens

*/

class Solution {
public:
    /*
    int nq;
    vector<vector<string>> ans;
    vector<string> board;
    vector<vector<string>> solveNQueens(int n) {
        nq = n;
        string s(n, '.');
        board.resize(n, s);
        solve(0);
        return ans;
    }//solveNQueens
    
    void solve(int row)
    {
        if(row == nq)
        {
            ans.push_back(board);
            return;
        }
        
        for(int col=0; col<nq; col++)
        {
            
            if(isSafe(row, col))
            {
                board[row][col] = 'Q';
                solve(row+1);
                board[row][col] = '.';
            }
        }
    }//solve
    
    bool isSafe(int x, int y)
    {
        // current col
        for(int r=0; r<x; r++)
            if(board[r][y] == 'Q')
                return false;
        //left upper dig
        int r=x;
        int c=y;
        while(r>=0 and c>=0)
        {
            if(board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }
        //right upper dig
        r=x;
        c=y;
        while(r>=0 and c<nq)
        {
            if(board[r][c] == 'Q')
                return false;
            r--;
            c++;
        }
        return true;
    }
    */
    int nq;
    vector<string> board;
     vector<vector<string>> ans;
    vector<bool> leftrow, lowerdig, upperdig;
    vector<vector<string>> solveNQueens(int n) {
        nq = n;
        board.resize(n, string(n, '.'));
        leftrow.resize(n, false); lowerdig.resize(2*n - 1, false); upperdig.resize(2*n - 1, false);
        solve(0);
        return ans;
    }//solveNQueens
    
    void solve(int col)
    {
        if(col == nq)
        {
            ans.push_back(board);
            return;
        }
        
        for(int row=0; row<nq; row++)
        {
            if(leftrow[row] == false and lowerdig[row+col]==false and upperdig[nq-1-row+col] == false)
            {
                board[row][col] = 'Q';
                leftrow[row] = true ; lowerdig[row+col]=true ; upperdig[nq-1-row+col] = true;
                solve(col+1);
                leftrow[row] = false ; lowerdig[row+col]=false ; upperdig[nq-1-row+col] = false;
                board[row][col] = '.';
            }
        }
    }
};