/*https://leetcode.com/problems/minesweeper/*/

class Solution {
    boolean[][] visited;
    int m, n;
    int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        m = board.length; n = board[0].length;
        visited = new boolean[m][n];
        
        board = reveal(board,click[0],click[1]);
        
        return board;
    }
    public char[][] reveal(char[][] board, int row, int col)
    {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) return board;
        visited[row][col] = true;
        int result = 0, i, temp;
        for (i = 0; i < 8; ++i)
            result += checkAdjacentCells(board, row+pos[i][0], col+pos[i][1]);
        if (result == 0)
        {
            board[row][col] = 'B';
            for (i = 0; i < 8; ++i)
                board = reveal(board, row+pos[i][0], col+pos[i][1]);
            return board;
        }
        board[row][col] = Integer.toString(result).charAt(0);
        return board;
    }
    public int checkAdjacentCells(char[][] board, int row, int col)
    {
        if (row < 0 || row >= m || col < 0 || col >= n) return 0;
        if (board[row][col] == 'M') return 1;
        return 0;
    }
}