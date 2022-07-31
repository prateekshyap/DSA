/*https://leetcode.com/problems/partition-equal-subset-sum/*/
/*https://binarysearch.com/problems/Equal-Partitions*/

/*Modified subset sum*/
class Solution {
    int target;
    Boolean[][] dp;
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length, i;
        for (i = 0; i < n; ++i)
            sum += nums[i];
        if (sum%2 != 0) return false;
        target = sum/2;
        dp = new Boolean[n+1][target+1];
        recur(nums,n,target);
        return dp[n][target];
    }
    public boolean recur(int[] nums, int index, int currSum)
    {
        if (currSum < 0) return false;
        if (dp[index][currSum] != null) return dp[index][currSum];
        if (currSum == 0)
        {
            dp[index][currSum] = true;
            return true;
        }
        if (index == 0)
        {
            dp[index][currSum] = false;
            return false;
        }
        
        dp[index][currSum] = new Boolean(recur(nums,index-1,currSum) || recur(nums,index-1,currSum-nums[index-1]));
        return dp[index][currSum];
    }
}

/*1D subset sum*/
class Solution {
    public boolean canPartition(int[] nums) {
        int target = 0;

        for (int num : nums)
            target += num;

        if (target%2 == 1)
            return false;

        target = target/2;

        return dfs(nums, new boolean[target+1], 0, target);
    }

    private boolean dfs(int[] nums, boolean[] dp, int index, int target) {
	    if(index >= nums.length) return false;
        else if(nums[index] == target) return true;

		int nextTarget = target-nums[index];

		if (nextTarget > 0 && !dp[nextTarget])
        {
			dp[nextTarget] = true;
			return dfs(nums, dp, index+1, nextTarget) || dfs(nums, dp, index+1, target);
		}
		else return dfs(nums, dp, index+1, target);
	}
}

import java.util.*;

class Solution {
    Boolean[][] dp;
    public boolean solve(int[] nums) {
        int sum = 0;
        int i;
        for (int num : nums)
            sum += num;
        if (sum%2 != 0) return false;
        sum /= 2;
        dp = new Boolean[nums.length+1][sum+1];
        return isSubsetSum(nums, 0, 0, sum, nums.length);
    }
    public boolean isSubsetSum(int[] nums, int index, int sum, int target, int n)
    {
        if (index == n)
        {
            if (sum == target) dp[index][sum] = true;
            else return false;
            return dp[index][sum];
        }
        if (sum > target) return false;
        if (dp[index][sum] != null) return dp[index][sum];
        boolean result = false;
        result |= isSubsetSum(nums, index+1, sum, target, n);
        result |= isSubsetSum(nums, index+1, sum+nums[index], target, n);
        dp[index][sum] = result;
        return result;
    }
}