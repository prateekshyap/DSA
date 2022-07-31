/*https://practice.geeksforgeeks.org/problems/maximum-difference-between-pair-in-a-matrix/1/*/

class Solution {
    public static int findMaxValue(int n, int[][] mat) {
        // code here
        int[][] minFeasibleValues = new int[n][n];
        int r, c, maxDiff = Integer.MIN_VALUE;
        minFeasibleValues[0][0] = mat[0][0]; //copy the first value
        //calculate for the first row and first column
        for (c = 1; c < n; ++c)
            minFeasibleValues[0][c] = Math.min(mat[0][c],minFeasibleValues[0][c-1]);
        for (r = 1; r < n; ++r)
            minFeasibleValues[r][0] = Math.min(mat[r][0],minFeasibleValues[r-1][0]);
        //calculate for the rest of the cells
        for (r = 1; r < n; ++r)
            for (c = 1; c < n; ++c)
                minFeasibleValues[r][c] = Math.min(mat[r][c],Math.min(minFeasibleValues[r-1][c],minFeasibleValues[r][c-1]));
        for (r = 1; r < n; ++r)
            for (c = 1; c < n; ++c)
                if (mat[r][c]-minFeasibleValues[r-1][c-1] > maxDiff) //if the current difference is greater
                    maxDiff = mat[r][c]-minFeasibleValues[r-1][c-1]; //update maximum difference
        return maxDiff;
    }
}