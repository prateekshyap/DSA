/*https://leetcode.com/problems/shortest-path-in-binary-matrix/*/

class Data implements Comparable<Data>
{
    int r, c;
    Data(int r, int c)
    {
        this.r = r;
        this.c = c;
    }
    
    @Override
    public int compareTo(Data d)
    {
        return 0;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int i, j, r, c, m = grid.length, n = grid[0].length;
        int[][] result = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<Data> queue = new LinkedList<Data>();
        Data d;
        int[][] pos = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
        
        for (i = 0; i < m; ++i)
            for (j = 0; j < n; ++j)
                result[i][j] = Integer.MAX_VALUE;
        if (grid[0][0] == 0)
        {
            result[0][0] = 1;
            queue.add(new Data(0,0));
        }
        while (!queue.isEmpty())
        {
            d = queue.poll();
            if (visited[d.r][d.c]) continue;
            visited[d.r][d.c] = true;
            for (i = 0; i < 8; ++i)
            {
                r = d.r+pos[i][0];
                c = d.c+pos[i][1];
                if (r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 0)
                {
                    result[r][c] = Math.min(result[r][c],result[d.r][d.c]+1);
                    queue.add(new Data(r,c));
                }
            }
        }
        return result[m-1][n-1] == Integer.MAX_VALUE ? -1 : result[m-1][n-1];
    }
}

class Solution {
    final static int[] vec = {1, 0, -1, 0, 1, -1, -1, 1, 1};
    final static int START = 2;
    final static int END = 3;
    
    // Approach 2: Bidirectional BFS
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) {
            return -1;
        } else if(grid.length == 1 && grid[0][0] == 0) {
            return 1;
        }

        int steps = 2;
        Queue<int[]> qs = new LinkedList<>();
        Queue<int[]> qe = new LinkedList<>();
        qs.add(new int[]{0,0});
        qe.add(new int[]{n-1,n-1});
        
        grid[0][0] = START;
        grid[n-1][n-1] = END;
        
        while(!qs.isEmpty() && !qe.isEmpty()) {
            boolean meet = false;
            if (qs.size() <= qe.size()) {
                meet = layer(grid, n, qs, START);
            } else {
                meet = layer(grid, n, qe, END);
            }
            
            if(meet) {
                return steps;
            }
            steps++;
        }
        return -1;
    }
    
    private boolean layer(int [][]grid, int n, Queue<int[]> q, int sign) {
        int size = q.size();
        for(int i=0; i<size; i++) {
            int[] curr = q.poll();
            for(int j=0; j<8; j++) {
                int newX = curr[0] + vec[j];
                int newY = curr[1] + vec[j+1];

                if(newX < 0 || newX >= n || newY < 0 || newY >= n || grid[newX][newY] == 1 || grid[newX][newY] == sign) {
                    continue;
                }
                
                // It means wew meet the other sign if it's the new cell is not 0. 
                // The cell with SIGN for this path is already filter by the condition above
                if(grid[newX][newY] != 0) {
                    return true;
                }
                grid[newX][newY] = sign;
                q.add(new int[]{newX, newY});
            }
        }
        
        return false;
    }
}