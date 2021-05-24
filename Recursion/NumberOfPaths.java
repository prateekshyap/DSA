/*https://practice.geeksforgeeks.org/problems/number-of-paths0926/1*/

class Solution{
    long paths;
    int row, col;
    long numberOfPaths(int m, int n) {
        paths = 0;
        row = m;
        col = n;
        countPaths(0,0);
        return paths;
    }
    public void countPaths(int r, int c)
    {
        if (r == row-1 && c == col-1) //when exhausted
        {
            ++paths;
            return;
        }

         //if reached at bottom, start moving right
        if (r == row-1)
        {
            countPaths(r,c+1);
            return;
        }

        //if reached at right end, start moving down
        if (c == col-1)
        {
            countPaths(r+1,c);
            return;
        }

        //in other cases, move in both the directions
        countPaths(r+1,c);
        countPaths(r,c+1);
    }
}