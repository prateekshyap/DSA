/*https://leetcode.com/problems/surrounded-regions/*/

class Solution {
    boolean[][] visited;
    int m, n;
    int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        int i, j;

        //mark those Os as visited which can be reached from the Os at the boarder
        for (i = 0; i < m; ++i)
        {
            if (board[i][0] == 'O' && !visited[i][0]) dfs(board,i,0);
            if (board[i][n-1] == 'O' && !visited[i][n-1]) dfs(board,i,n-1);
        }
        for (j = 0; j < n; ++j)
        {
            if (board[0][j] == 'O' && !visited[0][j]) dfs(board,0,j);
            if (board[m-1][j] == 'O' && !visited[m-1][j]) dfs(board,m-1,j);
        }

        //for all other Os, flip them
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                if (board[i][j] == 'O' && !visited[i][j])
                    board[i][j] = 'X';
    }
    public void dfs(char[][] board, int row, int col)
    {
        visited[row][col] = true;
        int r, c, i;
        for (i = 0; i < 4; ++i)
        {
            r = row+pos[i][0];
            c = col+pos[i][1];
            
            if (r >= 0 && r < m && c >= 0 && c < n && board[r][c] == 'O' && !visited[r][c])
                dfs(board,r,c);
        }
    }
}