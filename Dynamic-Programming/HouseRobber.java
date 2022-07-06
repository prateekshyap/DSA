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

class Solution {
    Integer[] maxRob;
    public int rob(int[] nums) {
        maxRob = new Integer[nums.length+2];
        solve(nums, 0);
        return maxRob[0];
    }
    public int solve(int[] nums, int index)
    {
        if (index >= nums.length)
        {
            maxRob[index] = 0;
            return 0;
        }
        if (maxRob[index] != null) return maxRob[index];
        maxRob[index] = Math.max(solve(nums,index+1),solve(nums,index+2)+nums[index]);
        return maxRob[index];
    }
}

class Solution {
    public int rob(int[] nums) {
        int i, n = nums.length, last = -1, secondLast = -1, curr = -1;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0],nums[1]);
        secondLast = nums[0];
        last = Math.max(nums[0],nums[1]);
        
        for (i = 2; i < n; ++i)
        {
            curr = Math.max(last,secondLast+nums[i]);
            secondLast = last;
            last = curr;
        }
        
        return curr;
    }
}