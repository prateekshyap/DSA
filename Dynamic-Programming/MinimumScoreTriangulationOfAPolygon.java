/*https://leetcode.com/problems/minimum-score-triangulation-of-polygon/*/

class Solution {
    Integer[][] table;
    public int minScoreTriangulation(int[] values) {
        int N = values.length;
        table = new Integer[N+1][N+1];
        table[0][N-1] = solve(values,0,N-1);
        return table[0][N-1];
    }
    private int solve(int[] arr, int i, int j)
    {
        if (i+1 == j) return 0;
        if (table[i][j] != null) return table[i][j];
        int result = Integer.MAX_VALUE, k;
        for (k = i+1; k < j; ++k)
            result = Math.min(result,solve(arr,i,k)+solve(arr,k,j)+(arr[i]*arr[k]*arr[j]));
        return table[i][j] = result;
    }
}