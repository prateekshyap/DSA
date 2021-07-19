/*https://leetcode.com/problems/n-queens/*/

class Solution {
    static List<List<String>> list;
    static List<String> getSolution(boolean[][] board, int n)
    {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < n; ++i)
        {
            StringBuilder sb = new StringBuilder("");
            for (int j = 0; j < n; ++j)
                sb.append(board[i][j] ? 'Q' : '.');
            temp.add(new String(sb));
        }
        return temp;
    }
    static boolean isSafe(boolean[][] board, int n, int r, int c)
    {
    	//the row should be empty
        for (int i = 0; i < c; ++i)
            if (board[r][i]) return false;
            
        //both the diagonals should be empty
        
        for (int i = r, j = c; i >= 0 && j >= 0; --i, --j)
            if (board[i][j]) return false;
        
        for (int i = r, j = c; i < n && j >= 0; ++i, --j)
            if (board[i][j]) return false;
            
        return true;
    }
    static boolean solveBoard(boolean[][] board, int n, int c)
    {
    	//if all columns checked, add the solution to the result
        if (c >= n)
        {
            list.add(getSolution(board,n));
        }
        
        //for each row
        for (int i = 0; i < n; ++i)
        {
        	//check which row is safe for the column c
            if (isSafe(board,n,i,c))
            {
                board[i][c] = true; //backtracking step - 1
                //if the solution can be found for the next column, return true
                if (solveBoard(board,n,c+1)) return true; //backtracking step - 2
                board[i][c] = false; //backtracking step - 3
            }
        }
        
        return false;
    }
    public List<List<String>> solveNQueens(int n) {
        list = new ArrayList<List<String>>();
        boolean[][] board = new boolean[n][n];

        //start with column-0
        solveBoard(board,n,0);
        return list;
    }
}