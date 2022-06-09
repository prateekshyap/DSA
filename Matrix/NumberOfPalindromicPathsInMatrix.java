/*https://practice.geeksforgeeks.org/problems/number-of-palindromic-paths-in-a-matrix0819/1#*/

class Solution
{
    long paths;
    int row, col;
    char[][] matrix;
    Integer[][][][] dp;
    int[] x1 = {0, 0, 1, 1}, y1 = {1, 1, 0, 0}, x2 = {-1, 0, 0, -1}, y2 = {0, -1, -1, 0};
    public int countOfPalindromicPaths(char[][] matrix)
    {
        // Code here
        paths = 0;
        row = matrix.length;
        col = matrix[0].length;
        this.matrix = matrix;
        if (matrix[0][0] != matrix[row-1][col-1]) return 0;
        dp = new Integer[row][col][row][col];
        return countPaths(0,0,row-1,col-1);
    }
    public int countPaths(int i1, int j1, int i2, int j2)
    {
        if (i2 < i1 || j2 < j1 || matrix[i1][j1] != matrix[i2][j2]) return 0;
        if (i1 == i2 && j1 == j2) return 1;
        if (i1 == i2 && j1+1 == j2) return 1;
        if (i1+1 == i2 && j1 == j2) return 1;
        if (dp[i1][j1][i2][j2] != null) return dp[i1][j1][i2][j2];
        int result = 0, i;
        for (i = 0; i < 4; ++i)
            result = (result+countPaths(i1+x1[i],j1+y1[i],i2+x2[i],j2+y2[i]))%1000000007;
        return dp[i1][j1][i2][j2] = result;
    }
}