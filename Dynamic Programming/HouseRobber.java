/*https://leetcode.com/problems/house-robber/*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        int[] maxTillPoint = new int[nums.length];
        dp[0] = maxTillPoint[0] = nums[0];
        dp[1] = nums[1];
        maxTillPoint[1] = Math.max(maxTillPoint[0],dp[1]);
        for (int i = 2; i < nums.length; ++i)
        {
            dp[i] = maxTillPoint[i-2]+nums[i];
            maxTillPoint[i] = Math.max(maxTillPoint[i-1],dp[i]);
        }
        return maxTillPoint[nums.length-1];
    }
}