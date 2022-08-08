/*https://leetcode.com/problems/dungeon-game/*/

class Cell
{
    int i, j;
    Cell(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
    @Override
    public String toString()
    {
        return "("+this.i+","+this.j+")";
    }
}
class Solution {
    int[][] dp;
    boolean[][] visited;
    public int calculateMinimumHP(int[][] dungeon) {
        int i, m = dungeon.length, n = dungeon[0].length, qLen;
        dp = new int[m][n];
        visited = new boolean[m][n];
        for (i = 0; i < m; ++i)
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        dp[m-1][n-1] = dungeon[m-1][n-1] > 0 ? 1 : Math.abs(dungeon[m-1][n-1])+1;
        Queue<Cell> queue = new LinkedList<Cell>();
        queue.add(new Cell(m-1,n-1));
        Cell c;
        while (!queue.isEmpty())
        {
            qLen = queue.size();
            for (i = 0; i < qLen; ++i)
            {
                c = queue.poll();
                if (c.i < 0 ||c.j < 0 || visited[c.i][c.j]) continue;
                visited[c.i][c.j] = true;
                if (c.i > 0) dp[c.i-1][c.j] = Math.min(dp[c.i-1][c.j],Math.max(1,dp[c.i][c.j]-dungeon[c.i-1][c.j]));
                queue.add(new Cell(c.i-1,c.j));
                if (c.j > 0) dp[c.i][c.j-1] = Math.min(dp[c.i][c.j-1],Math.max(1,dp[c.i][c.j]-dungeon[c.i][c.j-1]));
                queue.add(new Cell(c.i,c.j-1));
            }
        }
        return dp[0][0];
    }
}

class Solution
{
    int m, n;
    Integer[][] table;
    public int calculateMinimumHP(int[][] dungeon)
    {
        m = dungeon.length; n = dungeon[0].length;
        table = new Integer[m][n];
        table[0][0] = minHealth(dungeon,0,0);
        return table[0][0];
    }
    private int minHealth(int[][] dungeon, int i, int j)
    {
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        if (table[i][j] != null) return table[i][j];
        if (i == m-1 && j == n-1) return table[i][j] = dungeon[i][j] > 0 ? 1 : 1-dungeon[i][j];
        int down = minHealth(dungeon,i+1,j);
        int right = minHealth(dungeon,i,j+1);
        int health = Math.min(down,right);
        return table[i][j] = Math.max(1,health-dungeon[i][j]);
    }
}