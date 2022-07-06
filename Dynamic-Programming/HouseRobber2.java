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

class Solution {
    Integer[] maxRob;
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0],nums[1]);
        maxRob = new Integer[nums.length+2];
        int max = 0;
        solve(nums, 1, false);
        max = maxRob[1];
        maxRob = new Integer[nums.length+2];
        solve(nums, 0, true);
        max = Math.max(max,maxRob[0]);
        return max;
    }
    public int solve(int[] nums, int index, boolean takeFirst)
    {
        if (!takeFirst && index >= nums.length)
        {
            maxRob[index] = 0;
            return 0;
        }
        if (takeFirst && index >= nums.length-1)
        {
            maxRob[index] = 0;
            return 0;
        }
        if (maxRob[index] != null) return maxRob[index];
        maxRob[index] = Math.max(solve(nums,index+1,takeFirst),solve(nums,index+2,takeFirst)+nums[index]);
        return maxRob[index];
    }
}

class Solution {
    public int rob(int[] nums) {
        int i, n = nums.length, last = -1, secondLast = -1, curr = -1, max = 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0],nums[1]);
        secondLast = nums[0];
        last = Math.max(nums[0],nums[1]);
        max = Math.max(last,secondLast);
        
        for (i = 2; i < n-1; ++i)
        {
            curr = Math.max(last,secondLast+nums[i]);
            secondLast = last;
            last = curr;
        }
        max = Math.max(max,curr);
        secondLast = nums[1];
        last = Math.max(nums[1],nums[2]);
        max = Math.max(max,Math.max(last,secondLast));
        for (i = 3; i < n; ++i)
        {
            curr = Math.max(last,secondLast+nums[i]);
            secondLast = last;
            last = curr;
        }
        
        return Math.max(curr,max);
    }
}
   