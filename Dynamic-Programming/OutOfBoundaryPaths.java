/*https://leetcode.com/problems/out-of-boundary-paths/*/

class Solution {
    Long[][][] table;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        table = new Long[m][n][maxMove+1];
        table[startRow][startColumn][maxMove] = solve(m,n,maxMove,startRow,startColumn);
        return table[startRow][startColumn][maxMove].intValue();
    }
    private long solve(int m, int n, int maxMoves, int row, int col)
    {
        if (row == m || row < 0 || col == n || col < 0) return 1;
        if (table[row][col][maxMoves] != null) return table[row][col][maxMoves];
        if (maxMoves == 0) return table[row][col][maxMoves] = 0l;
        table[row][col][maxMoves] = (solve(m,n,maxMoves-1,row+1,col)+
            solve(m,n,maxMoves-1,row-1,col)+
            solve(m,n,maxMoves-1,row,col+1)+
            solve(m,n,maxMoves-1,row,col-1))%((int)1e9+7);
        return table[row][col][maxMoves];
    }
}

class Solution {
    Long[][][] table;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        table = new Long[m][n][maxMove+1];
        table[startRow][startColumn][maxMove] = solve(m,n,maxMove,startRow,startColumn);
        return table[startRow][startColumn][maxMove].intValue();
    }
    private long solve(int m, int n, int maxMoves, int row, int col)
    {
        if (row == m || row < 0 || col == n || col < 0) return 1;
        if (table[row][col][maxMoves] != null) return table[row][col][maxMoves];
        
        table[row][col][maxMoves] = 0l;
        if (maxMoves == 0) return table[row][col][maxMoves];
        
        for (int[] dir : dirs)
            table[row][col][maxMoves] = (table[row][col][maxMoves]+solve(m,n,maxMoves-1,row+dir[0],col+dir[1]))%((int)1e9+7);
        
        return table[row][col][maxMoves];
    }
}