/*https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1*/

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