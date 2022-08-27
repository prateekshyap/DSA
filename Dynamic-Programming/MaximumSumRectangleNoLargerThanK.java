/*https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/*/

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int r1, c1, r2, c2, R = matrix.length, C = matrix[0].length;
        int[][] preSum = new int[R+1][C+1];
        for (r1 = 0; r1 < R; ++r1)
            for (c1 = 0; c1 < C; ++c1)
                preSum[r1+1][c1+1] = preSum[r1][c1+1]+preSum[r1+1][c1]-preSum[r1][c1]+matrix[r1][c1];
        int result = Integer.MIN_VALUE, curr;
        for (r1 = 1; r1 <= R; ++r1)
        {
            for (c1 = 1; c1 <= C; ++c1)
            {
                for (r2 = r1; r2 <= R; ++r2)
                {
                    for (c2 = c1; c2 <= C; ++c2)
                    {
                        curr = preSum[r2][c2]-preSum[r2][c1-1]-preSum[r1-1][c2]+preSum[r1-1][c1-1];
                        if (curr > result && curr <= k) result = curr;
                        if (result == k)
                        {
                            // System.out.println(r1+" "+c1+" "+r2+" "+c2);
                            return result;
                        }
                    }
                }
            }
        }
        return result;
    }
}