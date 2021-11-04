/*https://leetcode.com/problems/house-robber-ii/*/

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        int[] dp = new int[nums.length-1];
        int[] maxTillPoint = new int[nums.length-1];
        dp[0] = maxTillPoint[0] = nums[0];
        dp[1] = nums[1];
        maxTillPoint[1] = Math.max(maxTillPoint[0],dp[1]);
        for (int i = 2; i < nums.length-1; ++i)
        {
            dp[i] = maxTillPoint[i-2]+nums[i];
            maxTillPoint[i] = Math.max(maxTillPoint[i-1],dp[i]);
        }
        int result = maxTillPoint[nums.length-2];
        dp[0] = maxTillPoint[0] = nums[1];
        dp[1] = nums[2];
        maxTillPoint[1] = Math.max(maxTillPoint[0],dp[1]);
        for (int i = 3; i < nums.length; ++i)
        {
            dp[i-1] = maxTillPoint[i-3]+nums[i];
            maxTillPoint[i-1] = Math.max(maxTillPoint[i-2],dp[i-1]);
        }
        result = Math.max(result,maxTillPoint[nums.length-2]);
        return result;
    }
}