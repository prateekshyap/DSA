/*https://leetcode.com/problems/number-of-longest-increasing-subsequence/*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, i, j, max = 1, count = 0;
        int[] dp = new int[n], counts = new int[n];
        for (i = 0; i < n; ++i)
            dp[i] = counts[i] = 1;
        for (i = 1; i < n; ++i)
        {
            for (j = 0; j < i; ++j)
            {
                if (nums[i] > nums[j])
                {
                    if (dp[i] < dp[j]+1)
                    {
                        dp[i] = dp[j]+1;
                        counts[i] = counts[j];
                    }
                    else if (dp[i] == dp[j]+1)
                        counts[i] += counts[j];
                }
            }
            if (dp[i] > max) max = dp[i];
        }
        for (i = 0; i < n; ++i)
            if (dp[i] == max)
                count += counts[i];
        return count;
    }
}