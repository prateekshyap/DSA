/*https://leetcode.com/problems/maximum-height-by-stacking-cuboids/*/

class Solution {
    public int maxHeight(int[][] cuboids) {
        int j, n = cuboids.length, result = 0;
        for (int i = 0; i < n; ++i)
            Arrays.sort(cuboids[i]);
        Arrays.sort(cuboids,(a,b)->(a[0] == b[0] ? (a[1] == b[1] ? b[2]-a[2] : b[1]-a[1]) : b[0]-a[0]));
        int[] dp = new int[n];
        for (int i = 0; i < n; ++i)
        {
            dp[i] = cuboids[i][2];
            if (dp[i] > result) result = dp[i];
        }
        for (int i = 1; i < n; ++i)
        {
            for (j = 0; j < i; ++j)
            {
                if(cuboids[i][0] <= cuboids[j][0] && cuboids[i][1] <= cuboids[j][1] && cuboids[i][2] <= cuboids[j][2])
                    dp[i] = Math.max(dp[i], dp[j]+cuboids[i][2]);
            }
            if (dp[i] > result)
                result = dp[i];
        }
        return result;
    }
}