/*https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/*/

class Solution {
    boolean[][][] visited = new boolean[100][100][101];
    public boolean hasValidPath(char[][] grid) {
        return check(grid,0,0,0);
    }
    private boolean check(char[][] grid, int i, int j, int bal)
    {
        int R = grid.length, C = grid[0].length;
        bal += grid[i][j] == '(' ? 1 : -1;
        if (bal < 0 || bal > (R+C)/2 || visited[i][j][bal]) return false;
        visited[i][j][bal] = true;
        if (i == R-1 && j == C-1 && bal == 0) return true;
        if (i < R-1 && check(grid,i+1,j,bal)) return true;
        if (j < C-1 && check(grid,i,j+1,bal)) return true;
        return false;
    }
}