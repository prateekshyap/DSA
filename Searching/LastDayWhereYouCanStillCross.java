/*https://leetcode.com/problems/last-day-where-you-can-still-cross/*/

class Pair
{
    int i, j;
    Pair(int i, int j)
    {
        this.i = i;
        this.j = j;
    }
    
    public String toString()
    {
        return "("+this.i+","+this.j+")";
    }
}

class Solution {
    int[][] cells;
    int[][] pos = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
    int row, col;
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.cells = cells;
        this.row = row;
        this.col = col;
        int low = 0, high = cells.length-1, mid, result = -1;
        
        while (low <= high)
        {
            mid = low+(high-low)/2;
            if (isFeasible(mid))
            {
                result = mid;
                low = mid+1;
            }
            else high = mid-1;
        }
        
        return result+1;
    }
    private boolean isFeasible(int day)
    {
        int[][] mat = new int[row][col];
        int len, i, j, r, c;
        Pair p;
        for (i = 0; i <= day; ++i)
            mat[cells[i][0]-1][cells[i][1]-1] = 1;
        Queue<Pair> queue = new LinkedList<Pair>();
        for (i = 0; i < col; ++i)
            if (mat[0][i] == 0)
                queue.add(new Pair(0,i));
        boolean[][] visited = new boolean[row][col];
        while (!queue.isEmpty())
        {
            len = queue.size();
            for (i = 0; i < len; ++i)
            {
                p = queue.poll();
                if (p.i < 0 || p.i >= row || p.j < 0 || p.j >= col || visited[p.i][p.j] || mat[p.i][p.j] == 1) continue;
                if (p.i == row-1) return true;
                visited[p.i][p.j] = true;
                for (j = 0; j < 4; ++j)
                {
                    r = p.i+pos[j][0];
                    c = p.j+pos[j][1];
                    queue.add(new Pair(r,c));
                }
            }
        }
        return false;
    }
}

