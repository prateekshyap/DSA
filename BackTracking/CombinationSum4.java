/*https://leetcode.com/problems/combination-sum-iv/*/

class Solution
{
    private int[] dp;
    public int combinationSum4(int[] nums, int target)
    {
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return combination(nums, target);
    }
    
    
    private int combination(int[] arr, int n) {
		if(dp[n] != -1) {
			return dp[n];
		}
		int count = 0;
		for (int i = 0; i < arr.length; ++i)
        {
			if(n >= arr[i])
                count += combination(arr, n-arr[i]);
		}
        dp[n] = count;
        return count;
	}
}

class Solution {
    Integer[] table;
    public int combinationSum4(int[] nums, int target) {
        table = new Integer[target+1];
        return countCombinations(nums,target,0);
    }
    private int countCombinations(int[] nums, int target, int sum)
    {
        if (sum == target) return 1;
        if (table[sum] != null) return table[sum];
        int count = 0;
        for (int i = 0; i < nums.length; ++i)
            if (sum+nums[i] <= target)
                count += countCombinations(nums,target,sum+nums[i]);
        table[sum] = count;
        return count;
    }
}

class Solution {
    Integer[] table;
    public int combinationSum4(int[] nums, int target) {
        table = new Integer[target+1];
        return countCombinations(nums,target);
    }
    private int countCombinations(int[] nums, int target)
    {
        if (target == 0) return 1;
        if (table[target] != null) return table[target];
        int count = 0;
        for (int i = 0; i < nums.length; ++i)
            if (nums[i] <= target)
                count += countCombinations(nums,target-nums[i]);
        table[target] = count;
        return count;
    }
}