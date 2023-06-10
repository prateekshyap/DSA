/*https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1*/
/*https://leetcode.com/problems/sudoku-solver/*/

class Solution
{
    static boolean isSafe(int[][] b, int row, int col, int key)
    {
        //the row should not contain duplicates
        for (int i = 0; i < 9; ++i)
            if (b[row][i] == key)
                return false;
        
        //the column should not contain duplicates
        for (int i = 0; i < 9; ++i)
            if (b[i][col] == key)
                return false;
        
        //the 3x3 box should not contain duplicates
        int sqrt = (int)Math.sqrt(b.length); 
        int boxRowStart = row - row % sqrt; 
        int boxColStart = col - col % sqrt; 
    
        for (int r = boxRowStart; r < boxRowStart + sqrt; r++)
            for (int d = boxColStart; d < boxColStart + sqrt; d++)
                if (b[r][d] == key)
                    return false;
        
        return true;
    }

    static boolean SolveSudoku(int grid[][])
    {
        int row = -1;
        int col = -1;

        //check if the sudoku is already blank and mark it
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++)
        { 
            for (int j = 0; j < 9; j++)
            { 
                if (grid[i][j] == 0)
                { 
                    row = i; 
                    col = j; 
                    isEmpty = false; 
                    break; 
                } 
            } 
            if (!isEmpty) 
                break;
        }

        //if blank then there always exists a solution
        if (isEmpty)
            return true;

        for (int num = 1; num <= 9; num++) //for each number from 1 to 9
        { 
            if (isSafe(grid, row, col, num)) //if putting any of them is safe at current cell
            { 
                grid[row][col] = num; //backtracking step - 1
                if (SolveSudoku(grid)) //backtracking step - 2
                    return true;
                grid[row][col] = 0; //backtracking step - 3
            } 
        } 
        return false; 
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j)
                System.out.print(grid[i][j]+" ");
    }
}


class Solution {
    char[][] currBoard;
    public static final int N = 9;
    public static final int boxSize = 3;
    
    public void solveSudoku(char[][] board) {
        currBoard = null;
        fill(board, 0, 0);
        board = currBoard;
    }
    
    public void fill(char[][] board, int r, int c)
    {
        if (r == 9 && c == 0)
        {
            if (currBoard == null && isFeasible(board))
            {
                currBoard = new char[N][N];
                for (int i = 0; i < N; ++i)
                    for (int j = 0; j < N; ++j)
                        currBoard[i][j] = board[i][j];
            }
            return;
        }
        
        if (currBoard != null) return;
        
        int nextR = r, nextC = c;
        ++nextC; // move to the next cell on right
        if (nextC >= 9) // if no such cell exists
        {
            nextC = 0; // move to the first cell
            ++nextR; // of the next row
        }
        
        if (board[r][c] == '.')
        {
            for (int i = 1; i <= 9; ++i)
            {
                board[r][c] = (char)('0'+i);
                if (isFeasible(board)) fill(board, nextR, nextC);
                if (currBoard != null) return;
                board[r][c] = '.';
            }
        }
        else
            fill(board, nextR, nextC);
    }
    
    public boolean isFeasible(char[][] board)
    {
        int[] hash = new int[10];
        
        // check for each row
        for (int r = 0; r < 9; ++r)
        {
            for (int c = 0; c < 9; ++c)
                if (board[r][c] != '.')
                    ++hash[board[r][c]-'0'];
        
            for (int i = 1; i <= 9; ++i)
                if (hash[i] > 1)
                    return false;
        
            hash = new int[10];
        }
        
        // check for each column
        for (int c = 0; c < 9; ++c)
        {
            for (int r = 0; r < 9; ++r)
                if (board[r][c] != '.')
                    ++hash[board[r][c]-'0'];
        
            for (int i = 1; i <= 9; ++i)
                if (hash[i] > 1)
                    return false;
            
            hash = new int[10];
        }
        
        // check for each box
        for (int rGap = 0; rGap < N/boxSize; ++rGap)
        {
            for (int cGap = 0; cGap < N/boxSize; ++cGap)
            {
                int R = rGap*boxSize;
                int C = cGap*boxSize;
                for (int r = R; r < R+boxSize; ++r)
                    for (int c = C; c < C+boxSize; ++c)
                        if (board[r][c] != '.')
                            ++hash[board[r][c]-'0'];
                
                for (int i = 1; i <= 9; ++i)
                    if (hash[i] > 1)
                        return false;
                
                hash = new int[10];
            }
        }
        
        return true;
    }
}

//Graph approach
class Solution {
    int n;
    public void solveSudoku(char[][] board) {
        n = board.length;

        boolean[][] row = new boolean[n][n + 1];
        boolean[][] col = new boolean[n][n + 1];
        boolean[][] block = new boolean[n][n + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                int val = Character.getNumericValue(board[i][j]);
                row[i][val] = true;
                col[j][val] = true;
                block[3 * (i/3) + j/3][val] = true;
            }
        }
        dfs(0, 0, row, col, block, board);
        
    }
    public boolean dfs(int i,
                    int j,
                    boolean[][] row,
                    boolean[][] col,
                    boolean[][] block,
                    char[][] board) {
        if(i == board.length) {
            return true;
        }
        if(j == n) {
            return dfs(i + 1, 0, row, col, block, board);
        }
        if(board[i][j] != '.') {
            return dfs(i ,j + 1, row, col, block, board);
        }

        for(int k = 1; k <= 9; k++) {
            if(row[i][k] || col[j][k] || block[3 * (i / 3) + j / 3][k]) {
                continue;
            }
            row[i][k] = true;
            col[j][k] = true;
            block[3 * (i / 3) + j / 3][k] = true;
            board[i][j] = (char) (k + '0');
            if(dfs(i, j + 1, row, col, block, board)) {
                return true;
            }

            row[i][k] = false;
            col[j][k] = false;
            block[3 * (i / 3) + j / 3][k] = false;
            board[i][j] = '.';
        }
        return false;
    }
    
}