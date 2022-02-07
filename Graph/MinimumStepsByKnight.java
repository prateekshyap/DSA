/*https://practice.geeksforgeeks.org/problems/steps-by-knight5927/1/*/

class Cell implements Comparable<Cell>
{
    int x;
    int y;
    int steps;
    Cell(int x, int y, int steps)
    {
        this.x = x;
        this.y = y;
        this.steps = steps;
    }
    @Override
    public int compareTo(Cell c)
    {
        return 0;
    }
}

class Solution
{
    boolean result;
    int minSteps;
    int n;
    int destRow, destCol;
    
    public boolean isSafe(int r, int c, boolean[][] visited) {
        //if boundary conditions violate, return false
        if (r <= -1 || r >= n || c <= -1 || c >= n)
            return false;
            
        //if the move is unsafe, return false
        if (visited[r][c])
            return false;
            
        //return true
        return true;
    }
    
    public void checkReachability(int srcRow, int srcCol, boolean[][] visited) {
        Queue<Cell> queue = new LinkedList<Cell>();
        queue.add(new Cell(srcRow,srcCol,0));
        visited[srcRow][srcCol] = true;
        int r = -1, c = -1, steps = -1;
        
        while (!queue.isEmpty())
        {
            Cell currCell = queue.poll();
            r = currCell.x;
            c = currCell.y;
            steps = currCell.steps;
            
            //if conditions violate, return
            if (r <= -1 || c <= -1 || r >= n || c >= n) return;
            
            //if destination is reached, store true and return
            if (r == destRow && c == destCol)
            {
                result = true;
                minSteps = Math.min(minSteps,steps);
            }
            
            //move in all four directions (backtracking step-2)
            if (isSafe(r+2,c+1,visited))
            {
                queue.add(new Cell(r+2,c+1,steps+1));
                visited[r+2][c+1] = true;
            }
            if (isSafe(r+1,c+2,visited))
            {
                queue.add(new Cell(r+1,c+2,steps+1));
                visited[r+1][c+2] = true;
            }
            if (isSafe(r-2,c+1,visited))
            {
                queue.add(new Cell(r-2,c+1,steps+1));
                visited[r-2][c+1] = true;
            }
            if (isSafe(r+1,c-2,visited))
            {
                queue.add(new Cell(r+1,c-2,steps+1));
                visited[r+1][c-2] = true;
            }
            if (isSafe(r-1,c+2,visited))
            {
                queue.add(new Cell(r-1,c+2,steps+1));
                visited[r-1][c+2] = true;
            }
            if (isSafe(r+2,c-1,visited))
            {
                queue.add(new Cell(r+2,c-1,steps+1));
                visited[r+2][c-1] = true;
            }
            if (isSafe(r-1,c-2,visited))
            {
                queue.add(new Cell(r-1,c-2,steps+1));
                visited[r-1][c-2] = true;
            }
            if (isSafe(r-2,c-1,visited))
            {
                queue.add(new Cell(r-2,c-1,steps+1));
                visited[r-2][c-1] = true;
            }
        }
    }
    
    //Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N)
    {
        // Code here
        result = false;
        minSteps = Integer.MAX_VALUE;
        n = N;
        int i = 0, j = 0;
        destRow = TargetPos[0]-1;
        destCol = TargetPos[1]-1;
        
        boolean[][] visited = new boolean[n][n];
        checkReachability(KnightPos[0]-1, KnightPos[1]-1, visited);
        
        return result ? minSteps : -1;
    }
}