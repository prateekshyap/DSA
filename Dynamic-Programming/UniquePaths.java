/*https://leetcode.com/problems/unique-paths/*/

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] table = new int[m][n];

        //we can reach from top to bottom in a single column in just 1 way
        for (int i = m-1; i >= 0; --i)
            table[i][n-1] = 1;

        //we can reach from left to right in a single row in just 1 way
        for (int i = n-1; i >= 0; --i)
            table[m-1][i] = 1;

        /*
        we can move from one cell to another in 1 way
        since we can move right and down, we'll add both of them
        to get the number of ways in which we can reach from the cell
        to the cell at its right and to the cell at its bottom
        */
        for (int i = m-2; i >= 0; --i)
            for (int j = n-2; j >= 0; --j)
                table[i][j] = table[i+1][j]+table[i][j+1];

        //value at the first cell will be the answer
        return table[0][0];
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[2][n];
        int row, col, index = 0;
        for (col = 0; col < n; ++col)
            ways[0][col] = 1;
        for (row = 1; row < m; ++row)
        {
            ways[1-index][0] = 1;
            for (col = 1; col < n; ++col)
                ways[1-index][col] = ways[index][col]+ways[1-index][col-1];
            index = 1-index;
        }
        return ways[index][n-1];
    }
}