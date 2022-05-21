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