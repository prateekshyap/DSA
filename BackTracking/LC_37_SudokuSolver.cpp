/*
https://leetcode.com/problems/sudoku-solver/
37. Sudoku Solver


https://practice.geeksforgeeks.org/problems/solve-the-sudoku-1587115621/1
Solve the Sudoku
*/

class Solution 
{
    bool isSafe(int row, int col, int c, int grid[N][N])
    {
        // int sq = sqrt(N); //3
        int boxrow = 3*(row/3); 
        int boxcol = 3*(col/3); 
        
        for(int i=0; i<9; i++)
        {
            if(grid[row][i] == c) return false; //the row should not contain duplicates
            if(grid[i][col] == c) return false; //the column should not contain duplicates
             //the 3x3 box should not contain duplicates
            if(grid[boxrow + (i/3)][boxcol + (i%3)] == c) return false;
        }
        return true;
    }
    
    bool solve(int i, int j, int grid[N][N])
    {
        if(i==9) return true;
        if(j==9) return solve(i+1, 0, grid);
        if(grid[i][j] != 0)
            return solve(i, j+1, grid);
        for(int c=1; c<=9; c++)
        {
            if(isSafe(i, j, c, grid))
            {
                grid[i][j] = c;
                if(solve(i, j+1, grid))
                    return true;
                grid[i][j] = 0;    
            }
        } // for c
        // grid[i][j] = 0;
        return false; // if no number can be accomodated
    }
    
    public:
    //Function to find a solved Sudoku. 
    bool SolveSudoku(int grid[N][N])  
    { 
        return solve(0, 0, grid);
        
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(grid[i][j] == 0)
                {
                    for(int c=1; c<=9; c++)
                    {
                        if(isSafe(i, j, c, grid))
                        {
                            grid[i][j] = c;
                            if(SolveSudoku(grid) == true)
                                return true;
                            grid[i][j] = 0;
                        }
                    } // for c
                    // grid[i][j] = 0;
                    return false; // if no number can be accomodated
                } // if grid == 0
            } //for j
        }//for i
        return true;
    }//SolveSudoku
    
    //Function to print grids of the Sudoku.
    void printGrid (int grid[N][N]) 
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                cout<<grid[i][j]<<" ";
            }
        }
    }
};


class Solution {
public:
    void solveSudoku(vector<vector<char>>& board) {
        solve(board);
    }
    
    bool solve(vector<vector<char>>& board)
    {
        for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c='1'; c<='9'; c++)
                    {
                        if(isSafe(i, j, c, board))
                        {
                            board[i][j] = c;
                            if(solve(board) == true)  return true;
                            board[i][j] = '.';
                        }
                    } // for c
                    // board[i][j] = '.';
                    return false; // if no number can be accomodated
                } // if board == '.'
            } //for j
        }//for i
        return true;
    }
    
    bool isSafe(int row, int col, char c, vector<vector<char>>& board)
    {
        int boxrow = 3*(row/3); 
        int boxcol = 3*(col/3); 
        
        for(int i=0; i<9; i++)
        {
            if(board[row][i] == c) return false; //the row should not contain duplicates
            if(board[i][col] == c) return false; //the column should not contain duplicates
             //the 3x3 box should not contain duplicates
            if(board[boxrow + (i/3)][boxcol + (i%3)] == c) return false;
        }
        return true;
    }
};