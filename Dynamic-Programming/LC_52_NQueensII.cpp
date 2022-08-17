/*
52. N-Queens II

https://leetcode.com/problems/n-queens-ii/
*/

class Solution {
public:
    
    int totalNQueens(int n) {
       // vector<int> sol = {1, 1, 0, 0, 2, 10, 4, 40, 92, 352, 724, 2680, 14200, 73712, 365596, 2279184, 14772512, 95815104};
       // return sol[n];
        
        nq = n;
        board.resize(n, string(n, '.'));
        leftrow.resize(n, false); lowerdig.resize(2*n - 1, false); upperdig.resize(2*n - 1, false);
        solve(0);
        return ans.size();
    }
    
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