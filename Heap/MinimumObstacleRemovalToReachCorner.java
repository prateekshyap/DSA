/*https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/*/

class Cell implements Comparable<Cell>
{
    int row, col, obsCount;
    Cell(int row, int col, int count)
    {
        this.row = row;
        this.col = col;
        this.obsCount = count;
    }
    
    @Override
    public int compareTo(Cell c)
    {
        return this.obsCount-c.obsCount;
    }
    
    @Override
    public String toString()
    {
        return "("+row+","+col+"->"+obsCount+")";
    }
}
class Solution {
    int[][] pos = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    boolean[][] visited;
    public int minimumObstacles(int[][] grid) {
        PriorityQueue<Cell> queue = new PriorityQueue<>();
        queue.add(new Cell(0,0,grid[0][0]));
        int i, r, c, min = Integer.MAX_VALUE, m = grid.length, n = grid[0].length, size;
        Cell curr;
        String key;
        StringBuilder build;
        visited = new boolean[m][n];
        
        while (!queue.isEmpty())
        {
            curr = queue.poll();
            if (curr.row == m-1 && curr.col == n-1)
            {
                min = Math.min(curr.obsCount,min);
                continue;
            }
            for (i = 0; i < 4; ++i)
            {
                r = curr.row+pos[i][0];
                c = curr.col+pos[i][1];
                if (r >= 0 && r < m && c >= 0 && c < n && !visited[r][c])
                {
                    visited[r][c] = true;
                    queue.add(new Cell(r,c,curr.obsCount+grid[r][c]));
                }
            }
        }
        return min;
    }
}