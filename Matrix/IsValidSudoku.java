/*https://leetcode.com/problems/valid-sudoku/*/

class Solution
{
    public boolean isSafe(char[][] b, int row, int col, char key)
    {
        //the row should not contain duplicates
        for (int i = 0; i < 9; ++i)
            if (b[row][i] == key && i != col)
                return false;
        
        //the column should not contain duplicates
        for (int i = 0; i < 9; ++i)
            if (b[i][col] == key && i != row)
                return false;
        
        //the 3x3 box should not contain duplicates
        int sqrt = (int)Math.sqrt(b.length); 
        int boxRowStart = row - row % sqrt; 
        int boxColStart = col - col % sqrt; 
    
        for (int r = boxRowStart; r < boxRowStart + sqrt; r++)
            for (int d = boxColStart; d < boxColStart + sqrt; d++)
                if (b[r][d] == key && !(r == row && d == col))
                    return false;
        
        return true;
    }

    public boolean isValidSudoku(char[][] board)
    {
        //check if the sudoku is already blank and mark it
        boolean isEmpty = true;
        for (int i = 0; i < 9; i++)
        { 
            for (int j = 0; j < 9; j++)
            { 
                if (board[i][j] != '.')
                {
                    isEmpty = false; 
                    break; 
                } 
            } 
            if (!isEmpty) 
                break;
        }

        //if blank then there always exists a solution
        if (isEmpty) return true;

        int i = 0, j = 0;
        //for all cells
        while (i < 9 && j < 9)
        {
        	//if the cell is empty skip it
            if (board[i][j] == '.')
            {
                ++j;
                if (j == 9)
                {
                    j = i == 8 ? 9 : 0;
                    ++i;
                }
                continue;
            }

            //check the safety of the cell
            if (!isSafe(board,i,j,board[i][j])) return false;

            //move to next cell
            ++j;
            if (j == 9)
            {
                j = i == 8 ? 9 : 0;
                ++i;
            }
        }
        return true; 
    }
}