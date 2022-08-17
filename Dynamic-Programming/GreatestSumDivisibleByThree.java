/*https://leetcode.com/problems/greatest-sum-divisible-by-three/*/

class Solution {
    int[][] dp;
    int len;
    public int maxSumDivThree(int[] nums) {
        dp = new int[nums.length][3];
        len = nums.length;
        for (int temp[] : dp)
            Arrays.fill(temp,-1);
        return rec(0,nums,0);
    }
    int rec(int curr,int nums[],int rem)
    {
        if (curr == len)
        {
            if (rem != 0) return Integer.MIN_VALUE;
            return 0;
        }
        if (dp[curr][rem] != -1) return dp[curr][rem];
        int max = Math.max(nums[curr]+rec(curr+1,nums,(rem+nums[curr])%3), //include
                        rec(curr+1,nums,rem)); //exclude
        return dp[curr][rem] = max;
    }
}