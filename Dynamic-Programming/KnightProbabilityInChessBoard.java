/*https://leetcode.com/problems/knight-probability-in-chessboard/*/

class Solution {
    double in, out;
    Double[][][] table;
    public double knightProbability(int n, int k, int row, int column) {
        in = out = 0;
        table = new Double[k+1][n][n];
        table[k][row][column] = solve(n,k,row,column);
        return table[k][row][column]/(double)Math.pow(8,k);
    }
    private double solve(int n, int moves, int r, int c)
    {
        if (r < 0 || r >= n || c < 0 || c >= n) return 0;
        if (moves == 0) return 1;
        
        if (table[moves][r][c] != null) return table[moves][r][c];
        
        table[moves][r][c] = solve(n,moves-1,r+2,c+1)+
        solve(n,moves-1,r+2,c-1)+
        solve(n,moves-1,r+1,c+2)+
        solve(n,moves-1,r+1,c-2)+
        solve(n,moves-1,r-1,c+2)+
        solve(n,moves-1,r-1,c-2)+
        solve(n,moves-1,r-2,c+1)+
        solve(n,moves-1,r-2,c-1);
        
        return table[moves][r][c];
    }
}

class Solution {
    double in, out;
    Double[][][] table;
    int[][] dirs = new int[][]{{2,1},{2,-1},{1,2},{1,-2},{-2,1},{-2,-1},{-1,2},{-1,-2}};
    public double knightProbability(int n, int k, int row, int column) {
        in = out = 0;
        table = new Double[k+1][n][n];
        table[k][row][column] = solve(n,k,row,column);
        return table[k][row][column]/(double)Math.pow(8,k);
    }
    private double solve(int n, int moves, int r, int c)
    {
        if (r < 0 || r >= n || c < 0 || c >= n) return 0;
        if (moves == 0) return 1;
        
        if (table[moves][r][c] != null) return table[moves][r][c];
        
        table[moves][r][c] = 0.0;
        for (int[] dir : dirs)
            table[moves][r][c] += solve(n,moves-1,r+dir[0],c+dir[1]);
        
        return table[moves][r][c];
    }
}