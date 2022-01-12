/*https://practice.geeksforgeeks.org/problems/x-total-shapes3617/1/*/

class Pair implements Comparable<Pair>
{
    int x,y;
    Pair(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Pair p)
    {
        return 0;
    }
}

class Solution
{
    boolean[][] visited;
    //Function to find the number of 'X' total shapes.
    public int xShape(char[][] grid)
    {
        //code here
        int n = grid.length;
        int m = grid[0].length;
        int i = 0, j = 0, result = 0;
        visited = new boolean[n][m];
        Queue<Pair> queue = new LinkedList<Pair>();
        for (i = 0; i < n; ++i)
        {
            for (j = 0; j < m; ++j)
            {
                if (grid[i][j] == 'X' && visited[i][j] == false)
                {
                    queue.add(new Pair(i,j));
                    ++result;
                    while (!queue.isEmpty())
                    {
                        Pair p = queue.poll();
                        visited[p.x][p.y] = true;
                        if (p.x-1 >= 0 && grid[p.x-1][p.y] == 'X' && visited[p.x-1][p.y] == false) queue.add(new Pair(p.x-1,p.y));
                        if (p.y-1 >= 0 && grid[p.x][p.y-1] == 'X' && visited[p.x][p.y-1] == false) queue.add(new Pair(p.x,p.y-1));
                        if (p.x+1 < n && grid[p.x+1][p.y] == 'X' && visited[p.x+1][p.y] == false) queue.add(new Pair(p.x+1,p.y));
                        if (p.y+1 < m && grid[p.x][p.y+1] == 'X' && visited[p.x][p.y+1] == false) queue.add(new Pair(p.x,p.y+1));
                    }
                }
            }
        }
        return result;
    }
}